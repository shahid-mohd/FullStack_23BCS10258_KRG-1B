package com.dlms.module2_bookmanagement.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.module2_bookmanagement.service.BookService;
import com.dlms.module2_bookmanagement.model.Book;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/books")
public class BookController {
  @Autowired private BookService svc;

  @GetMapping
  public Page<Book> list(@RequestParam(required=false) String q, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="10") int size){
    return svc.search(q,page,size);
  }

  @PostMapping
  public Book create(@RequestBody Book b){ return svc.save(b); }

  @PutMapping("/{id}")
  public Book update(@PathVariable Long id, @RequestBody Book b){ b.setId(id); return svc.save(b); }

  @DeleteMapping("/{id}")
  public Object delete(@PathVariable Long id){ svc.delete(id); return java.util.Map.of("message","deleted"); }
}
