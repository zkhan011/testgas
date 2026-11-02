package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class TxnType implements java.io.Serializable {
    protected java.lang.Integer txn_id;
    protected java.lang.Integer mdt_txn_id;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public TxnType() {
    }

    public java.lang.Integer getTxn_id() {
        return txn_id;
    }

    public void setTxn_id(java.lang.Integer txn_id) {
        this.txn_id = txn_id;
    }

    public java.lang.Integer getMdt_txn_id() {
        return mdt_txn_id;
    }

    public void setMdt_txn_id(java.lang.Integer mdt_txn_id) {
        this.mdt_txn_id = mdt_txn_id;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
