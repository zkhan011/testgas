package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class AnchorageType implements java.io.Serializable {
    protected java.lang.Integer code;
    protected java.lang.String codeDesc;

    public AnchorageType() {
    }

    public java.lang.Integer getCode() {
        return code;
    }

    public void setCode(java.lang.Integer code) {
        this.code = code;
    }

    public java.lang.String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(java.lang.String codeDesc) {
        this.codeDesc = codeDesc;
    }
}
