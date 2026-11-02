package com.dpw.services.exception;
public class ApplicationException extends RuntimeException {
 public ApplicationException(String message){super(message);}
 public ApplicationException(String code,String message){super(message);}
 public ApplicationException(String message,Throwable cause){super(message,cause);}
}
