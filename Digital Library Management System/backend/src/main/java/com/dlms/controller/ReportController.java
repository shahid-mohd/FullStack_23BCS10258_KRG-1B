package com.dlms.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.repo.BookRepository;
import com.dlms.repo.LendingRepository;
import com.dlms.repo.FineRepository;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
  @Autowired private BookRepository bookRepo;
  @Autowired private LendingRepository lendingRepo;
  @Autowired private FineRepository fineRepo;

  @GetMapping("/summary")
  public Map<String,Object> summary(){
    long totalBooks = bookRepo.count();
    long lent = lendingRepo.count();
    long overdue = lendingRepo.findAll().stream().filter(r -> r.getReturnedAt() == null && r.getDueDate().isBefore(java.time.LocalDate.now())).count();
    double fineCollected = fineRepo.findAll().stream().filter(F->F.getPaid()!=null && F.getPaid()).mapToDouble(F->F.getAmount()).sum();
    return Map.of("totalBooks", totalBooks, "lentBooks", lent, "overdue", overdue, "fineCollected", fineCollected);
  }
}
