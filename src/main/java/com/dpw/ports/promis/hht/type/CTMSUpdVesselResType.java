package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class CTMSUpdVesselResType implements java.io.Serializable {
    protected java.lang.String err_msg;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public CTMSUpdVesselResType() {
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
