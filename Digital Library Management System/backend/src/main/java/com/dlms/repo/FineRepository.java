package com.dlms.repo;
import com.dlms.model.FineRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FineRepository extends JpaRepository<FineRecord,Long> {
  List<FineRecord> findByUserId(Long userId);
}
