package com.dlms.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.service.FineService;
import com.dlms.model.FineRecord;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fines")
public class FineController {
  @Autowired private FineService fineService;

  @GetMapping("/user/{userId}")
  public List<FineRecord> finesForUser(@PathVariable Long userId){ return fineService.getFinesForUser(userId); }

  @PostMapping("/charge")
  public FineRecord charge(@RequestBody Map<String,Object> body){
    Long userId = Long.valueOf(body.get("userId").toString());
    Long lendingId = Long.valueOf(body.get("lendingId").toString());
    Double amount = Double.valueOf(body.get("amount").toString());
    return fineService.chargeFine(userId, lendingId, amount);
  }

  @PostMapping("/pay")
  public Map<String,String> pay(@RequestBody Map<String,Object> body){
    Long id = Long.valueOf(body.get("id").toString());
    fineService.payFine(id);
    return Map.of("message","paid");
  }
}
