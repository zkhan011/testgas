package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class ContrResType implements java.io.Serializable {
    protected java.lang.String tokenNo;
    protected com.dpw.ports.promis.hht.type.DummyContainerType[] dummyContrList;
    protected java.lang.String errMsg;

    public ContrResType() {
    }

    public java.lang.String getTokenNo() {
        return tokenNo;
    }

    public void setTokenNo(java.lang.String tokenNo) {
        this.tokenNo = tokenNo;
    }

    public com.dpw.ports.promis.hht.type.DummyContainerType[] getDummyContrList() {
        return dummyContrList;
    }

    public void setDummyContrList(com.dpw.ports.promis.hht.type.DummyContainerType[] dummyContrList) {
        this.dummyContrList = dummyContrList;
    }

    public java.lang.String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(java.lang.String errMsg) {
        this.errMsg = errMsg;
    }
}
