package com.dpw.gasws.domain;

import java.io.Serializable;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class ContrDetailsSqlType implements SQLData , Serializable {
    private static final long serialVersionUID = 1L;     
    
    private String containerNo;
    private String isoCode;
    private String doorDirection;
    private String contrPosition;
    private String chassisNo; 
    private String sealPresence;             
   
    private String SQLTypeName = "CAMCO_CONTR_OBJ";

    public String getSQLTypeName() throws SQLException {
        return SQLTypeName;
    }

    public void setSQLTypeName(String typeName) {
        SQLTypeName = typeName;
    }
    
    public ContrDetailsSqlType() {
    }
  

    public void readSQL(SQLInput stream, String typeName) throws SQLException{
        SQLTypeName = typeName;
        containerNo = stream.readString();                
        isoCode = stream.readString();                
        doorDirection = stream.readString();
        contrPosition= stream.readString();
        chassisNo = stream.readString();  
        sealPresence = stream.readString();  
    }

    public void writeSQL(SQLOutput stream) throws SQLException{
        if (containerNo != null) {
            stream.writeString(containerNo);
        } else {
            stream.writeString("");
        }
        
        if (isoCode != null) {
            stream.writeString(isoCode);
        } else {
            stream.writeString("");
        }
        
        if (doorDirection != null) {
            stream.writeString(doorDirection);
        } else {
            stream.writeString("");
        }
        
        if (contrPosition != null) {
            stream.writeString(contrPosition);
        } else {
            stream.writeString("");
        }
        
        if (chassisNo != null) {
            stream.writeString(chassisNo);
        } else {
            stream.writeString("");
        } 
        
        if (sealPresence != null) {
            stream.writeString(sealPresence);
        } else {
            stream.writeString("");
        }  
        
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

