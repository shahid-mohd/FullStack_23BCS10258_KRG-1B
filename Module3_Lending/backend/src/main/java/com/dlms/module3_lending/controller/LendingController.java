package com.dlms.module3_lending.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.module3_lending.service.LendingService;
import com.dlms.module3_lending.model.LendingRecord;
import java.util.Map;

@RestController
@RequestMapping("/api/lending")
public class LendingController {
  @Autowired private LendingService svc;

  @PostMapping("/borrow")
  public LendingRecord borrow(@RequestBody Map<String,Object> body){
    Long userId = Long.valueOf(body.get("userId").toString());
    Long bookId = Long.valueOf(body.get("bookId").toString());
    int days = Integer.parseInt(body.getOrDefault("days",14).toString());
    return svc.borrow(userId, bookId, days);
  }

  @PostMapping("/return")
  public LendingRecord returnBook(@RequestBody Map<String,Object> body){
    Long lendingId = Long.valueOf(body.get("lendingId").toString());
    return svc.returnBook(lendingId);
  }
}
