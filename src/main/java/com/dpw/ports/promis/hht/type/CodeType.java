package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class CodeType implements java.io.Serializable {
    protected java.lang.String codeName;
    protected java.lang.String codeValue;

    public CodeType() {
    }

    public java.lang.String getCodeName() {
        return codeName;
    }

    public void setCodeName(java.lang.String codeName) {
        this.codeName = codeName;
    }

    public java.lang.String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(java.lang.String codeValue) {
        this.codeValue = codeValue;
    }
}
