package com.dpw.gasws.type;


public class ServiceExceptionType implements java.io.Serializable {
    protected ExceptionType technicalException;
    protected ExceptionType businessException;
    
    public ServiceExceptionType() {
    }
    
    public ExceptionType getTechnicalException() {
        return technicalException;
    }
    
    public void setTechnicalException(ExceptionType technicalException) {
        this.technicalException = technicalException;
    }
    
    public ExceptionType getBusinessException() {
        return businessException;
    }
    
    public void setBusinessException(ExceptionType businessException) {
        this.businessException = businessException;
    }
}
