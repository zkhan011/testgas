package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class TOSMsgResType implements java.io.Serializable {
    protected java.lang.String msg;
    protected java.lang.String errMsg;

    public TOSMsgResType() {
    }

    public java.lang.String getMsg() {
        return msg;
    }

    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }

    public java.lang.String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(java.lang.String errMsg) {
        this.errMsg = errMsg;
    }
}
