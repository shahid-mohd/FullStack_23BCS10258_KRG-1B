package com.dlms.repo;
import com.dlms.model.LendingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LendingRepository extends JpaRepository<LendingRecord,Long> {
  List<LendingRecord> findByUserIdAndReturnedAtIsNull(Long userId);
}
