package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class PrintEirResType implements java.io.Serializable {
    protected java.lang.String status;
    protected com.dpw.ports.promis.hht.type.PrintEirType[] printEirDet;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public PrintEirResType() {
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public com.dpw.ports.promis.hht.type.PrintEirType[] getPrintEirDet() {
        return printEirDet;
    }

    public void setPrintEirDet(com.dpw.ports.promis.hht.type.PrintEirType[] printEirDet) {
        this.printEirDet = printEirDet;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
