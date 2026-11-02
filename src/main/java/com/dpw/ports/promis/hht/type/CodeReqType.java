package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class CodeReqType implements java.io.Serializable {
    protected java.lang.Integer includeNonMajor;

    public CodeReqType() {
    }

    public java.lang.Integer getIncludeNonMajor() {
        return includeNonMajor;
    }

    public void setIncludeNonMajor(java.lang.Integer includeNonMajor) {
        this.includeNonMajor = includeNonMajor;
    }
}
