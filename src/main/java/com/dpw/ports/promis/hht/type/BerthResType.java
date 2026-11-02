package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class BerthResType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.BerthType[] berth;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public BerthResType() {
    }

    public com.dpw.ports.promis.hht.type.BerthType[] getBerth() {
        return berth;
    }

    public void setBerth(com.dpw.ports.promis.hht.type.BerthType[] berth) {
        this.berth = berth;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
