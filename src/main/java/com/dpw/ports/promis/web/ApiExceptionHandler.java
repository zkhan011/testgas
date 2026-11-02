package com.dpw.ports.promis.web;
import org.springframework.web.bind.annotation.*;import org.springframework.http.*;import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;import com.dpw.services.exception.ApplicationException;
@RestControllerAdvice(assignableTypes={HhtController.class,VoyageController.class,SchedulerController.class}) public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
 @ExceptionHandler(IllegalArgumentException.class) ProblemDetail invalid(IllegalArgumentException e){return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,"Invalid request parameters");}
 @ExceptionHandler(ApplicationException.class) ProblemDetail business(ApplicationException e){org.slf4j.LoggerFactory.getLogger(getClass()).warn("Operation rejected",e);return ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY,"Operation rejected; consult server logs");}
 @ExceptionHandler(Exception.class) ProblemDetail unexpected(Exception e){org.slf4j.LoggerFactory.getLogger(getClass()).error("Request failed",e);return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,"Operation failed; consult server logs");}
}
