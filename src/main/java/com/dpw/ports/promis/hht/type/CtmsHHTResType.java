package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class CtmsHHTResType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.CtmsHHTRotnResp[] getVoyages;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public CtmsHHTResType() {
    }

    public com.dpw.ports.promis.hht.type.CtmsHHTRotnResp[] getGetVoyages() {
        return getVoyages;
    }

    public void setGetVoyages(com.dpw.ports.promis.hht.type.CtmsHHTRotnResp[] getVoyages) {
        this.getVoyages = getVoyages;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
