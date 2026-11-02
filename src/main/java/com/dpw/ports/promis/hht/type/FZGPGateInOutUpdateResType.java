package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class FZGPGateInOutUpdateResType implements java.io.Serializable {
    protected java.lang.String prownos;
    protected java.lang.String param;
    protected java.lang.String perno;

    public FZGPGateInOutUpdateResType() {
    }

    public java.lang.String getPrownos() {
        return prownos;
    }

    public void setPrownos(java.lang.String prownos) {
        this.prownos = prownos;
    }

    public java.lang.String getParam() {
        return param;
    }

    public void setParam(java.lang.String param) {
        this.param = param;
    }

    public java.lang.String getPerno() {
        return perno;
    }

    public void setPerno(java.lang.String perno) {
        this.perno = perno;
    }
}
