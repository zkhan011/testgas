package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class SignRespType implements java.io.Serializable {
    protected java.lang.Integer txn_id;
    protected java.lang.String err_msg;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public SignRespType() {
    }

    public java.lang.Integer getTxn_id() {
        return txn_id;
    }

    public void setTxn_id(java.lang.Integer txn_id) {
        this.txn_id = txn_id;
    }

    public java.lang.String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(java.lang.String err_msg) {
        this.err_msg = err_msg;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
