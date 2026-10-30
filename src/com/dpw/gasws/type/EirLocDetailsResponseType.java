package com.dpw.gasws.type;


public class  EirLocDetailsResponseType implements java.io.Serializable {
   
    protected EirDetailsType[] eirDetails; //Changed to object array for future enhancements
    protected LocDetailsType[] locDetails;
    protected String errorMessage;
    protected ServiceExceptionType exception;    
    
    public EirLocDetailsResponseType() {
    }

    public void setException(ServiceExceptionType exception) {
        this.exception = exception;
    }

    public ServiceExceptionType getException() {
        return exception;
    }  

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        sb.append("\n----EirLocDetailsResponseType----\n");
            if(eirDetails != null && eirDetails.length > 0) {
                for(EirDetailsType obj:eirDetails){
                  sb.append(obj.toString()).append("#####");
                }
            }
            if(locDetails != null && locDetails.length > 0) {
                for(LocDetailsType obj:locDetails){
                 sb.append(obj.toString()).append("#####");
                }
            }
        sb.append("Error:").append(this.errorMessage).append("\n");
        return sb.toString();
     }

    public void setEirDetails(EirDetailsType[] eirDetails) {
        this.eirDetails = eirDetails;
    }

    public EirDetailsType[] getEirDetails() {
        return eirDetails;
    }

    public void setLocDetails(LocDetailsType[] locDetails) {
        this.locDetails = locDetails;
    }

    public LocDetailsType[] getLocDetails() {
        return locDetails;
    }
}
