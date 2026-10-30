package com.dpw.gasws.type;

import java.util.Date;

public class TokenDetailsType implements java.io.Serializable {
    protected String tokenNo;
    protected String containerNo;
    protected String terminalId;
    protected Date startTime;
    protected Date endTime;
           
    public TokenDetailsType() {
    }

    public void setTokenNo(String tokenNo) {
        this.tokenNo = tokenNo;
    }

    public String getTokenNo() {
        return tokenNo;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer("");       
          sb.append("##TOKEN NO:")
            .append(this.tokenNo)
            .append(" ## ")
            .append("CONTR NO:")
            .append(this.containerNo)            
            .append(" ## ")
            .append("TERMINAL ID:")
            .append(this.terminalId)
            .append(" ## ")
            .append("START TIME:")
            .append(this.startTime)
            .append(" ## ")
            .append("END TIME:")
            .append(this.endTime)
            .append(" ##\n");          
        return sb.toString();
    }
}
