package com.dlms.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lending_records")
public class LendingRecord {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long bookId;
  private Long userId;
  private LocalDate borrowedAt;
  private LocalDate dueDate;
  private LocalDate returnedAt;

  // getters/setters
  public Long getId(){ return id; }
  public void setId(Long id){ this.id = id; }
  public Long getBookId(){ return bookId; }
  public void setBookId(Long bookId){ this.bookId = bookId; }
  public Long getUserId(){ return userId; }
  public void setUserId(Long userId){ this.userId = userId; }
  public LocalDate getBorrowedAt(){ return borrowedAt; }
  public void setBorrowedAt(LocalDate borrowedAt){ this.borrowedAt = borrowedAt; }
  public LocalDate getDueDate(){ return dueDate; }
  public void setDueDate(LocalDate dueDate){ this.dueDate = dueDate; }
  public LocalDate getReturnedAt(){ return returnedAt; }
  public void setReturnedAt(LocalDate returnedAt){ this.returnedAt = returnedAt; }
}
