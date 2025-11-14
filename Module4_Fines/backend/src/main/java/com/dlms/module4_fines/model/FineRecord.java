package com.dlms.module4_fines.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="fines")
public class FineRecord {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private Long userId;
  private Long lendingRecordId;
  private Double amount;
  private Boolean paid = false;
  private LocalDate chargedAt;
  // getters/setters
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public Long getUserId(){return userId;} public void setUserId(Long userId){this.userId=userId;}
  public Long getLendingRecordId(){return lendingRecordId;} public void setLendingRecordId(Long lendingRecordId){this.lendingRecordId=lendingRecordId;}
  public Double getAmount(){return amount;} public void setAmount(Double amount){this.amount=amount;}
  public Boolean getPaid(){return paid;} public void setPaid(Boolean paid){this.paid=paid;}
  public LocalDate getChargedAt(){return chargedAt;} public void setChargedAt(LocalDate chargedAt){this.chargedAt=chargedAt;}
}
