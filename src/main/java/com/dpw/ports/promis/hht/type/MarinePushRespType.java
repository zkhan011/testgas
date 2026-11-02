package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class MarinePushRespType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;
    protected com.dpw.ports.promis.hht.type.TxnType[] txnType;

    public MarinePushRespType() {
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }

    public com.dpw.ports.promis.hht.type.TxnType[] getTxnType() {
        return txnType;
    }

    public void setTxnType(com.dpw.ports.promis.hht.type.TxnType[] txnType) {
        this.txnType = txnType;
    }
}
