package com.dlms.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.service.BookService;
import com.dlms.model.Book;
import org.springframework.data.domain.Page;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {
  @Autowired private BookService bookService;

  @GetMapping
  public Page<Book> list(@RequestParam(required=false) String q, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="10") int size){
    return bookService.search(q,page,size);
  }

  @PostMapping
  public Book create(@RequestBody Book book){ return bookService.save(book); }

  @PutMapping("/{id}")
  public Book update(@PathVariable Long id, @RequestBody Book book){
    book.setId(id);
    return bookService.save(book);
  }

  @DeleteMapping("/{id}")
  public Map<String,String> delete(@PathVariable Long id){ bookService.delete(id); return Map.of("message","deleted"); }
}
