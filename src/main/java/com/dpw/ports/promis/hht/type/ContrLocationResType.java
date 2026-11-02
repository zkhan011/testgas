package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class ContrLocationResType implements java.io.Serializable {
    protected java.lang.String status;
    protected com.dpw.ports.promis.hht.type.ContrLocationType[] contrLocationdet;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public ContrLocationResType() {
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public com.dpw.ports.promis.hht.type.ContrLocationType[] getContrLocationdet() {
        return contrLocationdet;
    }

    public void setContrLocationdet(com.dpw.ports.promis.hht.type.ContrLocationType[] contrLocationdet) {
        this.contrLocationdet = contrLocationdet;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
