package com.dpw.gasws.type;


public class TokenDetailsReqType implements java.io.Serializable {
    protected String tokenNo;
   
           
    public TokenDetailsReqType() {
    }

    public void setTokenNo(String tokenNo) {
        this.tokenNo = tokenNo;
    }

    public String getTokenNo() {
        return tokenNo;
    }  
    
    public String toString(){
        StringBuffer sb = new StringBuffer("");       
        sb.append("##TOKEN NO:")
          .append(this.tokenNo)           
          .append(" ##");          
        return sb.toString();
    }   
}
