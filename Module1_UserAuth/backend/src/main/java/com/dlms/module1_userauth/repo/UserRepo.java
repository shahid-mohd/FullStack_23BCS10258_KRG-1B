package com.dlms.module1_userauth.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.dlms.module1_userauth.model.User;
public interface UserRepo extends JpaRepository<User,Long> { Optional<User> findByEmail(String email); }
