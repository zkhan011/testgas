package com.dpw.ports.promis.web;
import org.springframework.context.annotation.Configuration;import org.springframework.web.servlet.config.annotation.*;
@Configuration public class WebConfiguration implements WebMvcConfigurer{
 private final ApiKeyInterceptor auth;public WebConfiguration(ApiKeyInterceptor auth){this.auth=auth;}
 @Override public void addInterceptors(InterceptorRegistry r){r.addInterceptor(auth);}
}
