package com.dpw.gasws.type;


public class ContrDetailsReqType implements java.io.Serializable {   
    protected String containerNo;
    protected String isoCode;
    protected String doorDirection;
    protected String contrPosition;
    protected String chassisNo;   
    protected String sealPresence;
           
    public ContrDetailsReqType() {
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getContainerNo() {
        return containerNo;
    } 
    
    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getIsoCode() {
        return isoCode;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer("");       
          sb.append("##CONTIANER NO:")
            .append(this.containerNo)
            .append(" ## ")
            .append("ISO CODE:")
            .append(this.isoCode)            
            .append(" ##")
            .append("DOOR DIRECTION:")
            .append(this.doorDirection)
            .append(" ##")
            .append("CONTR POSITION:")
            .append(this.contrPosition)
            .append(" ##")
            .append("CHASSIS NO:")
            .append(this.chassisNo)
            .append(" ##")
            .append("SEAL PRESENCE:")
            .append(this.sealPresence);        
        return sb.toString();
    }


    public void setDoorDirection(String doorDirection) {
        this.doorDirection = doorDirection;
    }

    public String getDoorDirection() {
        return doorDirection;
    }

    public void setContrPosition(String contrPosition) {
        this.contrPosition = contrPosition;
    }

    public String getContrPosition() {
        return contrPosition;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setSealPresence(String sealPresence) {
        this.sealPresence = sealPresence;
    }

    public String getSealPresence() {
        return sealPresence;
    }
}
