package com.dlms.service;
import com.dlms.model.FineRecord;
import com.dlms.repo.FineRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.List;

@Service
public class FineService {
  @Autowired private FineRepository fineRepo;

  public FineRecord chargeFine(Long userId, Long lendingRecordId, double amount){
    FineRecord f = new FineRecord();
    f.setUserId(userId);
    f.setLendingRecordId(lendingRecordId);
    f.setAmount(amount);
    f.setChargedAt(LocalDate.now());
    return fineRepo.save(f);
  }

  public List<FineRecord> getFinesForUser(Long userId){ return fineRepo.findByUserId(userId); }

  public FineRecord payFine(Long id){
    FineRecord f = fineRepo.findById(id).orElseThrow();
    f.setPaid(true);
    return fineRepo.save(f);
  }
}
