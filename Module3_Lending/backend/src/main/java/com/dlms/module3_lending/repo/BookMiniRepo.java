package com.dlms.module3_lending.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dlms.module3_lending.model.BookMini;
public interface BookMiniRepo extends JpaRepository<BookMini,Long> {}
