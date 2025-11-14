package com.dlms.module4_fines.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dlms.module4_fines.model.FineRecord;
import java.util.List;
public interface FineRepo extends JpaRepository<FineRecord,Long> { java.util.List<FineRecord> findByUserId(Long userId); }
