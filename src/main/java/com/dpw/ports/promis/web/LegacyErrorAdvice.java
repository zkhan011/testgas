package com.dpw.ports.promis.web;
import com.dpw.ports.promis.hht.type.ServiceExceptionType;import org.springframework.core.MethodParameter;import org.springframework.http.*;import org.springframework.http.converter.HttpMessageConverter;import org.springframework.http.server.*;import org.springframework.web.bind.annotation.RestControllerAdvice;import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@RestControllerAdvice public class LegacyErrorAdvice implements ResponseBodyAdvice<Object>{
 public boolean supports(MethodParameter p,Class<? extends HttpMessageConverter<?>> c){return p.getContainingClass()==HhtController.class;}
 public Object beforeBodyWrite(Object body,MethodParameter p,MediaType media,Class<? extends HttpMessageConverter<?>> c,ServerHttpRequest req,ServerHttpResponse res){
  if(body==null)return null;
  try{Object value=body.getClass().getMethod("getException").invoke(body);if(value instanceof ServiceExceptionType errors){
   if(errors.getTechnicalException()!=null && errors.getTechnicalException().length>0){res.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);for(var error:errors.getTechnicalException())if(error!=null)error.setMessage("Technical operation failure; consult server logs");}
   else if(errors.getBusinessException()!=null && errors.getBusinessException().length>0)res.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY);
  }}catch(NoSuchMethodException ignored){}catch(ReflectiveOperationException e){throw new IllegalStateException(e);}return body;
 }
}
