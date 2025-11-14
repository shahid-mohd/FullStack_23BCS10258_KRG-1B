package com.dlms.module5_reporting.controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api/reports")
public class ReportController {
  @GetMapping("/summary")
  public Map<String,Object> summary(){
    // For an independent module, return sample aggregated values
    return Map.of("totalBooks",50,"lentBooks",12,"overdue",3,"fineCollected",120.5);
  }
}
