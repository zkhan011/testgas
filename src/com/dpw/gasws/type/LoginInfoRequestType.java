package com.dpw.gasws.type;


public class LoginInfoRequestType implements java.io.Serializable {
    protected java.lang.String username;
    protected java.lang.String password;
  
    public LoginInfoRequestType() {
    }
    
    public java.lang.String getUsername() {
        return username;
    }
    
    public void setUsername(java.lang.String username) {
        this.username = username;
    }
    
    public java.lang.String getPassword() {
        return password;
    }
    
    public void setPassword(java.lang.String password) {
        this.password = password;
    }   
  
}
