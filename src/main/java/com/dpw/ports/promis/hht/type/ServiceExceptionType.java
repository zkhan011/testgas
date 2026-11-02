package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class ServiceExceptionType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.ExceptionType[] technicalException;
    protected com.dpw.ports.promis.hht.type.ExceptionType[] businessException;

    public ServiceExceptionType() {
    }

    public com.dpw.ports.promis.hht.type.ExceptionType[] getTechnicalException() {
        return technicalException;
    }

    public void setTechnicalException(com.dpw.ports.promis.hht.type.ExceptionType[] technicalException) {
        this.technicalException = technicalException;
    }

    public com.dpw.ports.promis.hht.type.ExceptionType[] getBusinessException() {
        return businessException;
    }

    public void setBusinessException(com.dpw.ports.promis.hht.type.ExceptionType[] businessException) {
        this.businessException = businessException;
    }
}
