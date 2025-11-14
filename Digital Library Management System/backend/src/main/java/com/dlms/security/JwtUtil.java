package com.dlms.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.*;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration-ms}")
  private long expirationMs;

  private Key key(){
    return Keys.hmacShaKeyFor(secret.getBytes());
  }

  public String generateToken(String subject, String role){
    return Jwts.builder()
      .setSubject(subject)
      .claim("role", role)
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
      .signWith(key())
      .compact();
  }

  public Jws<Claims> validate(String token){
    return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token);
  }
}
