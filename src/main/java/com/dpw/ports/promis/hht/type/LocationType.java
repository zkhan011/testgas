package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class LocationType implements java.io.Serializable {
    protected java.lang.String portCode;
    protected java.lang.String code;
    protected java.lang.String codeDesc;

    public LocationType() {
    }

    public java.lang.String getPortCode() {
        return portCode;
    }

    public void setPortCode(java.lang.String portCode) {
        this.portCode = portCode;
    }

    public java.lang.String getCode() {
        return code;
    }

    public void setCode(java.lang.String code) {
        this.code = code;
    }

    public java.lang.String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(java.lang.String codeDesc) {
        this.codeDesc = codeDesc;
    }
}
