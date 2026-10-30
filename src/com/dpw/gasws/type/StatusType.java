package com.dpw.gasws.type;


public class StatusType implements java.io.Serializable {
    protected String statusValue;
    
    public static final java.lang.String SUCCESS_STR = "SUCCESS";
    public static final java.lang.String FAILURE_STR = "FAILURE";
    
    public StatusType() {
    }
    
    public StatusType(String value) {
        this.statusValue = value;
    }


    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getStatusValue() {
        return statusValue;
    }
}
