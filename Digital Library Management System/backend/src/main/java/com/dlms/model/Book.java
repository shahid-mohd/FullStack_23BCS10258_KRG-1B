package com.dlms.model;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String author;
  private String isbn;
  private String category;
  private Integer year;
  private Boolean available = true;

  // getters/setters
  public Long getId(){ return id; }
  public void setId(Long id){ this.id = id; }
  public String getTitle(){ return title; }
  public void setTitle(String title){ this.title = title; }
  public String getAuthor(){ return author; }
  public void setAuthor(String author){ this.author = author; }
  public String getIsbn(){ return isbn; }
  public void setIsbn(String isbn){ this.isbn = isbn; }
  public String getCategory(){ return category; }
  public void setCategory(String category){ this.category = category; }
  public Integer getYear(){ return year; }
  public void setYear(Integer year){ this.year = year; }
  public Boolean getAvailable(){ return available; }
  public void setAvailable(Boolean available){ this.available = available; }
}
