package com.yourstomorrow.api.controllers.middlewares;

import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourstomorrow.api.exceptions.UnauthorizedUserException;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestValidationMidlleware implements HandlerInterceptor {
  private final Logger logger = org.slf4j.LoggerFactory.getLogger(RequestValidationMidlleware.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String authHeader = request.getHeader("x-auth-id");
    System.out.println(authHeader.length());
    if (authHeader == null || authHeader.length() < 32) {
      Map<String, String> map = new Hashtable<>();
      map.put("status", "failed");
      map.put("message", "Unauthorized request");
      map.put("payload", "UN_AUTHORIZED");
      response.setContentType("application/json;  charset=utf-8");
      response.setStatus(401);
      response.getWriter().write(map.toString());
      return false;
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
  }
}
