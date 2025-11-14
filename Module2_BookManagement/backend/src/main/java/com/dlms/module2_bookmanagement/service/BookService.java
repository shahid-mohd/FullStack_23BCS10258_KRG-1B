package com.dlms.module2_bookmanagement.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.module2_bookmanagement.repo.BookRepo;
import com.dlms.module2_bookmanagement.model.Book;
import org.springframework.data.domain.*;
import java.util.Optional;

@Service
public class BookService {
  @Autowired private BookRepo repo;
  public Page<Book> search(String q,int page,int size){
    Pageable p = PageRequest.of(page,size);
    if(q==null||q.isBlank()) return repo.findAll(p);
    return repo.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(q,q,p);
  }
  public Book save(Book b){ return repo.save(b); }
  public Optional<Book> findById(Long id){ return repo.findById(id); }
  public void delete(Long id){ repo.deleteById(id); }
}
