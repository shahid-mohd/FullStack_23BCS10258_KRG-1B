package com.dlms.security;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;

@Component
public class JwtFilter extends GenericFilter {
  @Autowired
  private JwtUtil jwtUtil;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    String auth = req.getHeader("Authorization");
    if(auth != null && auth.startsWith("Bearer ")){
      String token = auth.substring(7);
      try {
        jwtUtil.validate(token);
        // in a full app you would set the Spring Security context here
      } catch (Exception e){
        ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
        return;
      }
    }
    chain.doFilter(request,response);
  }
}
