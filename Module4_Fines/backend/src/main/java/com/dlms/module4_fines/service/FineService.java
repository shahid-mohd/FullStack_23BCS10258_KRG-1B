package com.dlms.module4_fines.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.module4_fines.repo.FineRepo;
import com.dlms.module4_fines.model.FineRecord;
import java.time.LocalDate;
import java.util.List;

@Service
public class FineService {
  @Autowired private FineRepo repo;
  // charge fine with simple daily rate calculation
  public FineRecord charge(Long userId, Long lendingId, long daysLate, double ratePerDay){
    FineRecord f = new FineRecord();
    f.setUserId(userId); f.setLendingRecordId(lendingId);
    f.setAmount(daysLate * ratePerDay);
    f.setChargedAt(LocalDate.now());
    return repo.save(f);
  }
  public List<FineRecord> forUser(Long userId){ return repo.findByUserId(userId); }
  public FineRecord pay(Long id){ var f = repo.findById(id).orElseThrow(); f.setPaid(true); return repo.save(f); }
}
