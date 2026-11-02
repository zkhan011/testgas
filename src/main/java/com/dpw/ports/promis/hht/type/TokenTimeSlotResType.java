package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class TokenTimeSlotResType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.TokenSlotType[] tokenSlotList;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public TokenTimeSlotResType() {
    }

    public com.dpw.ports.promis.hht.type.TokenSlotType[] getTokenSlotList() {
        return tokenSlotList;
    }

    public void setTokenSlotList(com.dpw.ports.promis.hht.type.TokenSlotType[] tokenSlotList) {
        this.tokenSlotList = tokenSlotList;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
