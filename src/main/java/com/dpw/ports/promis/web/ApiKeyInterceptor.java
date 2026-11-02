package com.dpw.ports.promis.web;
import java.io.IOException;import java.nio.charset.StandardCharsets;import java.security.MessageDigest;
import jakarta.servlet.http.*;import org.springframework.stereotype.Component;import org.springframework.beans.factory.annotation.Value;import org.springframework.web.servlet.HandlerInterceptor;import org.springframework.web.method.HandlerMethod;
@Component
public class ApiKeyInterceptor implements HandlerInterceptor{
 private final String clientKey,adminKey;
 public ApiKeyInterceptor(@Value("${gate.security.api-key}")String clientKey,@Value("${gate.security.admin-key}")String adminKey){
  if(clientKey.length()<24 || adminKey.length()<24 || clientKey.equals(adminKey))throw new IllegalArgumentException("Configure distinct gate.security.api-key and admin-key of at least 24 characters");this.clientKey=clientKey;this.adminKey=adminKey;
 }
 public boolean preHandle(HttpServletRequest req,HttpServletResponse res,Object handler)throws IOException{
  if(!(handler instanceof HandlerMethod method))return true;Class<?> type=method.getBeanType();
  if(type!=HhtController.class && type!=VoyageController.class && type!=SchedulerController.class)return true;
  String supplied=req.getHeader("X-API-Key");boolean admin=equal(supplied,adminKey),client=equal(supplied,clientKey);
  if(!admin && (!client || type==SchedulerController.class)){res.setStatus(client?403:401);res.setContentType("application/problem+json");res.getWriter().write("{\"title\":\"Access denied\",\"status\":"+(client?403:401)+"}");return false;}return true;
 }
 private static boolean equal(String actual,String expected){return actual!=null && MessageDigest.isEqual(actual.getBytes(StandardCharsets.UTF_8),expected.getBytes(StandardCharsets.UTF_8));}
}
