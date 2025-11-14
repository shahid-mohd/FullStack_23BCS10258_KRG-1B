package com.dlms.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlms.service.UserService;
import com.dlms.model.User;
import com.dlms.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired private UserService userService;
  @Autowired private PasswordEncoder passwordEncoder;
  @Autowired private JwtUtil jwtUtil;

  @PostMapping("/register")
  public Map<String,Object> register(@RequestBody Map<String,String> body){
    User u = new User();
    u.setName(body.get("name"));
    u.setEmail(body.get("email"));
    u.setPassword(passwordEncoder.encode(body.get("password")));
    u.setRole(body.getOrDefault("role","MEMBER"));
    User saved = userService.register(u);
    String token = jwtUtil.generateToken(saved.getEmail(), saved.getRole());
    return Map.of("token", token, "userId", saved.getId(), "role", saved.getRole());
  }

  @PostMapping("/login")
  public Map<String,Object> login(@RequestBody Map<String,String> body){
    String email = body.get("email");
    String pwd = body.get("password");
    var opt = userService.findByEmail(email);
    if(opt.isEmpty()) throw new RuntimeException("Invalid credentials");
    User u = opt.get();
    if(!passwordEncoder.matches(pwd, u.getPassword())) throw new RuntimeException("Invalid credentials");
    String token = jwtUtil.generateToken(u.getEmail(), u.getRole());
    return Map.of("token", token, "userId", u.getId(), "role", u.getRole());
  }
}
