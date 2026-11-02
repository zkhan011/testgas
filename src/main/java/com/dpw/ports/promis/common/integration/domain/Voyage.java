package com.dpw.ports.promis.common.integration.domain;

import com.dpw.ports.promis.common.Utilities;
import com.dpw.services.exception.ApplicationException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;

public class Voyage
implements Serializable {
    private String portCode;
    private String terminalId;
    private Integer rotationNo;
    private String vesselName;
    private Integer voyageType;
    private String callType;
    private String callReason;
    private String voyageRoute;
    private String voyageNoIn;
    private String voyageNoOut;
    private Date etaDate;
    private Date etdDate;
    private Date portArrivalDate;
    private String arrivalfrom;
    private String sailTo;
    private Date sailDate;
    private String plannedBerth;
    private String currentBerth;
    private Double stayHours;
    private Double arrivalDraft;
    private Date firstCallDate;
    private Date readyToSailDate;
    private Double sailDraft;
    private String lineCode;
    private String createdBy;




    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public Integer getRotationNo() {
        return this.rotationNo;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public void setVoyageType(Integer voyageType) {
        this.voyageType = voyageType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public void setCallReason(String callReason) {
        this.callReason = callReason;
    }

    public void setVoyageRoute(String voyageRoute) {
        this.voyageRoute = voyageRoute;
    }

    public void setVoyageNoIn(String voyageNoIn) {
        this.voyageNoIn = voyageNoIn;
    }

    public void setVoyageNoOut(String voyageNoOut) {
        this.voyageNoOut = voyageNoOut;
    }

    public void setEtaDate(Date etaDate) {
        this.etaDate = etaDate;
    }

    public void setEtdDate(Date etdDate) {
        this.etdDate = etdDate;
    }

    public void setPortArrivalDate(Date portArrivalDate) {
        this.portArrivalDate = portArrivalDate;
    }

    public void setArrivalfrom(String arrivalfrom) {
        this.arrivalfrom = arrivalfrom;
    }

    public void setSailTo(String sailTo) {
        this.sailTo = sailTo;
    }

    public void setSailDate(Date sailDate) {
        this.sailDate = sailDate;
    }

    public void setPlannedBerth(String plannedBerth) {
        this.plannedBerth = plannedBerth;
    }

    public void setCurrentBerth(String currentBerht) {
        this.currentBerth = currentBerht;
    }

    public void setStayHours(Double stayHours) {
        this.stayHours = stayHours;
    }

    public void setArrivalDraft(Double arrivalDraft) {
        this.arrivalDraft = arrivalDraft;
    }

    public void setFirstCallDate(Date firstCallDate) {
        this.firstCallDate = firstCallDate;
    }

    public void setReadyToSailDate(Date readyToSailDate) {
        this.readyToSailDate = readyToSailDate;
    }

    public void setSailDraft(Double sailDraft) {
        this.sailDraft = sailDraft;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getPortCode() {
        return this.portCode;
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    public void setRotationNo(Integer rotationNo) {
        this.rotationNo = rotationNo;
    }

    public String getVesselName() {
        return this.vesselName;
    }

    public Integer getVoyageType() {
        return this.voyageType;
    }

    public String getCallType() {
        return this.callType;
    }

    public String getCallReason() {
        return this.callReason;
    }

    public String getVoyageRoute() {
        return this.voyageRoute;
    }

    public String getVoyageNoIn() {
        return this.voyageNoIn;
    }

    public String getVoyageNoOut() {
        return this.voyageNoOut;
    }

    public Date getEtaDate() {
        return this.etaDate;
    }

    public Date getEtdDate() {
        return this.etdDate;
    }

    public Date getPortArrivalDate() {
        return this.portArrivalDate;
    }

    public String getArrivalfrom() {
        return this.arrivalfrom;
    }

    public String getSailTo() {
        return this.sailTo;
    }

    public Date getSailDate() {
        return this.sailDate;
    }

    public String getPlannedBerth() {
        return this.plannedBerth;
    }

    public String getCurrentBerth() {
        return this.currentBerth;
    }

    public Double getStayHours() {
        return this.stayHours;
    }

    public Double getArrivalDraft() {
        return this.arrivalDraft;
    }

    public Date getFirstCallDate() {
        return this.firstCallDate;
    }

    public Date getReadyToSailDate() {
        return this.readyToSailDate;
    }

    public Double getSailDraft() {
        return this.sailDraft;
    }

    public String getLineCode() {
        return this.lineCode;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void performBusinessRules() {
        if (!this.isPortCodeValid()) {
            throw new ApplicationException("RGEN-0001", "Invalid Port Code");
        }
        if (Utilities.isNullOrEmpty(this.terminalId)) {
            throw new ApplicationException("RGEN-0002", "Invalid Terminal ID");
        }
        if (Utilities.isNullOrEmpty(this.vesselName)) {
            throw new ApplicationException("RGEN-0003", "Invalid Vessel Name");
        }
        if (this.voyageType == null || this.voyageType != 0) {
            throw new ApplicationException("RGEN-0004", "Invalid Voyage type");
        }
        if (Utilities.isNullOrEmpty(this.callType)) {
            throw new ApplicationException("RGEN-0005", "Invalid Call type");
        }
        if (Utilities.isNullOrEmpty(this.callReason)) {
            throw new ApplicationException("RGEN-0006", "Invalid Call Reason");
        }
        if (Utilities.isNullOrEmpty(this.voyageNoIn)) {
            throw new ApplicationException("RGEN-0007", "Invalid Voyage In");
        }
        if (Utilities.isNullOrEmpty(this.voyageNoOut)) {
            throw new ApplicationException("RGEN-0008", "Invalid Voyage Out");
        }
        if (this.etaDate == null) {
            throw new ApplicationException("RGEN-0009", "Invalid ETA Date");
        }
        if (Utilities.isNullOrEmpty(this.lineCode)) {
            throw new ApplicationException("RGEN-0010", "ETA Date is required");
        }
        if (Utilities.isNullOrEmpty(this.createdBy)) {
            throw new ApplicationException("RGEN-0011", "Created By is required");
        }
    }

    public boolean isPortCodeValid() {
        return !Utilities.isNullOrEmpty(this.portCode) && (this.portCode.equalsIgnoreCase("R") || this.portCode.equalsIgnoreCase("J"));
    }

    public void applyIntegrationSpecificChangesOnFields() {
        if (!Utilities.isNullOrEmpty(this.terminalId)) {
            this.setTerminalId(this.terminalId.substring(1));
        }
    }
}
