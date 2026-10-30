package com.dpw.gasws.type;


public class  ExceptionDataResponseType implements java.io.Serializable {
   
    protected String errorMessage;
    protected ServiceExceptionType exception;    
    
    public ExceptionDataResponseType() {
    }


    public void setException(ServiceExceptionType exception) {
        this.exception = exception;
    }

    public ServiceExceptionType getException() {
        return exception;
    }
  
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    
    public String toString() {
         StringBuffer sb = new StringBuffer("");        
         sb.append("Error:").append(this.errorMessage).append("\n");
         return sb.toString();
     }    
}
