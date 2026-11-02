package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class VoyagesResType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.VoyagesType[] voyages;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public VoyagesResType() {
    }

    public com.dpw.ports.promis.hht.type.VoyagesType[] getVoyages() {
        return voyages;
    }

    public void setVoyages(com.dpw.ports.promis.hht.type.VoyagesType[] voyages) {
        this.voyages = voyages;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
