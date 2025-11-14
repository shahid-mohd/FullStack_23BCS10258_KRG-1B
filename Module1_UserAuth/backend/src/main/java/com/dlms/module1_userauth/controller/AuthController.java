package com.dlms.module1_userauth.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.module1_userauth.repo.UserRepo;
import com.dlms.module1_userauth.model.User;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired private UserRepo userRepo;

  @PostMapping("/register")
  public ResponseEntity<?> register(@Validated @RequestBody User u){
    if(userRepo.findByEmail(u.getEmail()).isPresent()) return ResponseEntity.badRequest().body(Map.of("error","Email exists"));
    u.setRole(u.getRole().toUpperCase());
    // NOTE: password stored plain for scaffold; hash in production
    User saved = userRepo.save(u);
    return ResponseEntity.ok(Map.of("userId",saved.getId(),"role",saved.getRole()));
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String,String> cred){
    Optional<User> opt = userRepo.findByEmail(cred.get("email"));
    if(opt.isEmpty() || !opt.get().getPassword().equals(cred.get("password"))) return ResponseEntity.status(401).body(Map.of("error","Invalid"));
    User u = opt.get();
    // simplified token: userId-role
    String token = u.getId()+"-"+u.getRole();
    return ResponseEntity.ok(Map.of("token",token,"role",u.getRole(),"userId",u.getId()));
  }
}
