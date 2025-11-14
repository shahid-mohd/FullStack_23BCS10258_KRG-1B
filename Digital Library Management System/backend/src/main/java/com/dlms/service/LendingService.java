package com.dlms.service;
import com.dlms.model.LendingRecord;
import com.dlms.model.Book;
import com.dlms.repo.LendingRepository;
import com.dlms.repo.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class LendingService {
  @Autowired private LendingRepository lendingRepo;
  @Autowired private BookRepository bookRepo;

  public LendingRecord borrow(Long userId, Long bookId, int days){
    Optional<Book> bOpt = bookRepo.findById(bookId);
    if(bOpt.isEmpty() || !bOpt.get().getAvailable()) throw new RuntimeException("Book not available");
    Book b = bOpt.get();
    b.setAvailable(false);
    bookRepo.save(b);

    LendingRecord r = new LendingRecord();
    r.setBookId(bookId);
    r.setUserId(userId);
    r.setBorrowedAt(LocalDate.now());
    r.setDueDate(LocalDate.now().plusDays(days));
    return lendingRepo.save(r);
  }

  public LendingRecord returnBook(Long lendingId){
    Optional<LendingRecord> opt = lendingRepo.findById(lendingId);
    if(opt.isEmpty()) throw new RuntimeException("Lending record not found");
    LendingRecord rec = opt.get();
    rec.setReturnedAt(LocalDate.now());
    lendingRepo.save(rec);
    // set book available
    bookRepo.findById(rec.getBookId()).ifPresent(b->{ b.setAvailable(true); bookRepo.save(b); });
    return rec;
  }
}
