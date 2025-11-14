package com.dlms.module3_lending.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.module3_lending.repo.LendingRepo;
import com.dlms.module3_lending.repo.BookMiniRepo;
import com.dlms.module3_lending.model.LendingRecord;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class LendingService {
  @Autowired private LendingRepo lendingRepo;
  @Autowired private BookMiniRepo bookRepo;

  public LendingRecord borrow(Long userId, Long bookId, int days){
    Optional<com.dlms.module3_lending.model.BookMini> bo = bookRepo.findById(bookId);
    if(bo.isEmpty() || !bo.get().getAvailable()) throw new RuntimeException("Book not available");
    var book = bo.get();
    book.setAvailable(false); bookRepo.save(book);
    LendingRecord r = new LendingRecord();
    r.setBookId(bookId); r.setUserId(userId); r.setBorrowedAt(LocalDate.now());
    r.setDueDate(LocalDate.now().plusDays(days));
    return lendingRepo.save(r);
  }

  public LendingRecord returnBook(Long lendingId){
    var recOpt = lendingRepo.findById(lendingId);
    if(recOpt.isEmpty()) throw new RuntimeException("not found");
    var rec = recOpt.get();
    rec.setReturnedAt(LocalDate.now());
    lendingRepo.save(rec);
    bookRepo.findById(rec.getBookId()).ifPresent(b->{ b.setAvailable(true); bookRepo.save(b); });
    return rec;
  }
}
