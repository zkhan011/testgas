package com.dpw.gasws.type;


public class  ContainerDetailsResponseType implements java.io.Serializable {
   
    protected ContainerDetailsType[] contrDetails;
    protected String errorMessage;
    protected ServiceExceptionType exception;    
    
    public ContainerDetailsResponseType() {
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

    public void setContrDetails(ContainerDetailsType[] contrDetails) {
        this.contrDetails = contrDetails;
    }

    public ContainerDetailsType[] getContrDetails() {
        return contrDetails;
    }
}
