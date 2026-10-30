package com.dpw.gasws.type;


public class  GetTokenResponseType implements java.io.Serializable {
   
    protected TokenDetailsType[] tokenDetails;
    protected String errorMessage;
    protected ServiceExceptionType exception;    
    
    public GetTokenResponseType() {
    }


    public void setException(ServiceExceptionType exception) {
        this.exception = exception;
    }

    public ServiceExceptionType getException() {
        return exception;
    }

    public void setTokenDetails(TokenDetailsType[] tokenDetails) {
        this.tokenDetails = tokenDetails;
    }

    public TokenDetailsType[] getTokenDetails() {
        return tokenDetails;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    
    public String toString() {
         StringBuffer sb = new StringBuffer("");
         sb.append("\n----GetTokenResponseType----\n");        
         if(tokenDetails != null && tokenDetails.length > 0) {
            for(TokenDetailsType obj:tokenDetails){
              sb.append(obj.toString()).append("#####");
            }
         }
         sb.append("Error:").append(this.errorMessage).append("\n");
         return sb.toString();
     }    
}
