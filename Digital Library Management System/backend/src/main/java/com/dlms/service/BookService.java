package com.dlms.service;
import com.dlms.model.Book;
import com.dlms.repo.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

@Service
public class BookService {
  @Autowired private BookRepository bookRepo;

  public Page<Book> search(String q, int page, int size){
    Pageable p = PageRequest.of(page, size);
    if(q == null || q.isBlank()) return bookRepo.findAll(p);
    return bookRepo.findByTitleContainingIgnoreCase(q, p);
  }

  public Book save(Book b){ return bookRepo.save(b); }
  public void delete(Long id){ bookRepo.deleteById(id); }
  public java.util.Optional<Book> findById(Long id){ return bookRepo.findById(id); }
}
