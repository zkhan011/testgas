package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class ContainerResType implements java.io.Serializable {
    protected java.lang.String tokenNo;
    protected com.dpw.ports.promis.hht.type.ContainerType[] contrList;
    protected java.lang.String errMsg;

    public ContainerResType() {
    }

    public java.lang.String getTokenNo() {
        return tokenNo;
    }

    public void setTokenNo(java.lang.String tokenNo) {
        this.tokenNo = tokenNo;
    }

    public com.dpw.ports.promis.hht.type.ContainerType[] getContrList() {
        return contrList;
    }

    public void setContrList(com.dpw.ports.promis.hht.type.ContainerType[] contrList) {
        this.contrList = contrList;
    }

    public java.lang.String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(java.lang.String errMsg) {
        this.errMsg = errMsg;
    }
}
