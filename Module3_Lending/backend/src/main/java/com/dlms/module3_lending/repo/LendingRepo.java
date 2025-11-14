package com.dlms.module3_lending.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.dlms.module3_lending.model.LendingRecord;
public interface LendingRepo extends JpaRepository<LendingRecord,Long> {
  List<LendingRecord> findByUserIdAndReturnedAtIsNull(Long userId);
}
