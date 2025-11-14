package com.dlms.module2_bookmanagement.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.dlms.module2_bookmanagement.model.Book;
public interface BookRepo extends JpaRepository<Book,Long> {
  Page<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String t, String a, Pageable p);
}
