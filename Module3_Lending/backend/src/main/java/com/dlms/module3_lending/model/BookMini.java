package com.dlms.module3_lending.model;
import jakarta.persistence.*;
@Entity
@Table(name="books_mini")
public class BookMini {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String title;
  private Boolean available = true;
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getTitle(){return title;} public void setTitle(String title){this.title=title;}
  public Boolean getAvailable(){return available;} public void setAvailable(Boolean available){this.available=available;}
}
