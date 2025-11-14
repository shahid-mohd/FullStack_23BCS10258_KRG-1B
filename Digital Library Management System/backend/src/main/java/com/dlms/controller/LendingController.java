package com.dlms.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.service.LendingService;
import com.dlms.model.LendingRecord;
import java.util.Map;

@RestController
@RequestMapping("/api/lending")
public class LendingController {
  @Autowired private LendingService lendingService;

  @PostMapping("/borrow")
  public LendingRecord borrow(@RequestBody Map<String,Object> body){
    Long userId = Long.valueOf(body.get("userId").toString());
    Long bookId = Long.valueOf(body.get("bookId").toString());
    int days = Integer.parseInt(body.getOrDefault("days",14).toString());
    return lendingService.borrow(userId, bookId, days);
  }

  @PostMapping("/return")
  public LendingRecord returnBook(@RequestBody Map<String,Object> body){
    Long lendingId = Long.valueOf(body.get("lendingId").toString());
    return lendingService.returnBook(lendingId);
  }
}
