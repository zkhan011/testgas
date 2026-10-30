package com.dpw.gasws.type;


public class ExceptionType implements java.io.Serializable {
    protected java.lang.String id;
    protected java.lang.String message;
    
    public ExceptionType() {
    }
    
    public java.lang.String getId() {
        return id;
    }
    
    public void setId(java.lang.String id) {
        this.id = id;
    }
    
    public java.lang.String getMessage() {
        return message;
    }
    
    public void setMessage(java.lang.String message) {
        this.message = message;
    }
}
