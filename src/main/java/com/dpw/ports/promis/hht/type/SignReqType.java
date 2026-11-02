package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class SignReqType implements java.io.Serializable {
    protected java.lang.Integer txn_id;
    protected com.dpw.ports.promis.hht.type.LoginInfoReqType userCredentials;
    protected byte[] sign;

    public SignReqType() {
    }

    public java.lang.Integer getTxn_id() {
        return txn_id;
    }

    public void setTxn_id(java.lang.Integer txn_id) {
        this.txn_id = txn_id;
    }

    public com.dpw.ports.promis.hht.type.LoginInfoReqType getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(com.dpw.ports.promis.hht.type.LoginInfoReqType userCredentials) {
        this.userCredentials = userCredentials;
    }

    public byte[] getSign() {
        return sign;
    }

    public void setSign(byte[] sign) {
        this.sign = sign;
    }
}
