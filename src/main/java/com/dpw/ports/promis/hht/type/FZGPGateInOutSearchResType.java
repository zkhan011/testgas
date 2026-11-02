package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class FZGPGateInOutSearchResType implements java.io.Serializable {
    protected java.lang.String status;
    protected java.lang.String inspmessage;
    protected java.lang.String inspmessflag;
    protected com.dpw.ports.promis.hht.type.FZGPGateInOutSearchList[] gplist;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public FZGPGateInOutSearchResType() {
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.lang.String getInspmessage() {
        return inspmessage;
    }

    public void setInspmessage(java.lang.String inspmessage) {
        this.inspmessage = inspmessage;
    }

    public java.lang.String getInspmessflag() {
        return inspmessflag;
    }

    public void setInspmessflag(java.lang.String inspmessflag) {
        this.inspmessflag = inspmessflag;
    }

    public com.dpw.ports.promis.hht.type.FZGPGateInOutSearchList[] getGplist() {
        return gplist;
    }

    public void setGplist(com.dpw.ports.promis.hht.type.FZGPGateInOutSearchList[] gplist) {
        this.gplist = gplist;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
