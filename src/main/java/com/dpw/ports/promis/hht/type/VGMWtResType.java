package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class VGMWtResType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.VGMWtType[] vgmWtdet;
    protected java.lang.String errorMsg;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public VGMWtResType() {
    }

    public com.dpw.ports.promis.hht.type.VGMWtType[] getVgmWtdet() {
        return vgmWtdet;
    }

    public void setVgmWtdet(com.dpw.ports.promis.hht.type.VGMWtType[] vgmWtdet) {
        this.vgmWtdet = vgmWtdet;
    }

    public java.lang.String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
