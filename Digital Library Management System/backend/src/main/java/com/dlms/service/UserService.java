package com.dlms.service;
import com.dlms.model.User;
import com.dlms.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class UserService {
  @Autowired private UserRepository userRepo;
  public User register(User u){ return userRepo.save(u); }
  public Optional<User> findByEmail(String email){ return userRepo.findByEmail(email); }
  public Optional<User> findById(Long id){ return userRepo.findById(id); }
}
