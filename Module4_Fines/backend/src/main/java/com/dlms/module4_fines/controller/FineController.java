package com.dlms.module4_fines.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.module4_fines.service.FineService;
import com.dlms.module4_fines.model.FineRecord;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fines")
public class FineController {
  @Autowired private FineService svc;

  @PostMapping("/charge")
  public FineRecord charge(@RequestBody Map<String,Object> body){
    Long userId = Long.valueOf(body.get("userId").toString());
    Long lendingId = Long.valueOf(body.get("lendingId").toString());
    long daysLate = Long.valueOf(body.getOrDefault("daysLate",0).toString());
    double rate = Double.valueOf(body.getOrDefault("rate",1.0).toString());
    return svc.charge(userId,lendingId,daysLate,rate);
  }

  @GetMapping("/user/{userId}")
  public List<FineRecord> userFines(@PathVariable Long userId){ return svc.forUser(userId); }

  @PostMapping("/pay")
  public Map<String,String> pay(@RequestBody Map<String,Object> body){ Long id = Long.valueOf(body.get("id").toString()); svc.pay(id); return Map.of("message","paid"); }
}
