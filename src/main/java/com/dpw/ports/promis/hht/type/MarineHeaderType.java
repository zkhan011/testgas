package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class MarineHeaderType implements java.io.Serializable {
    protected java.lang.Integer twsid;
    protected java.lang.Integer txn_id;
    protected java.lang.Integer mdt_txn_id;
    protected java.lang.Integer rotn;
    protected java.lang.String move_type;
    protected java.lang.String from_location;
    protected java.lang.String to_location;
    protected java.lang.String vessel_board_time;
    protected java.lang.String vessel_leave_time;
    protected java.lang.String launch_boat_code;
    protected java.lang.Integer modified_vessel_draft;
    protected java.lang.String channel_entry_time;
    protected java.lang.String channel_exit_time;
    protected java.lang.String buoy_no;
    protected java.lang.String buoy_cross_time;
    protected java.lang.String breakwater_cross_time;
    protected java.lang.String fl_time;
    protected java.lang.String ll_time;
    protected java.lang.Integer is_detained;
    protected java.lang.String detention_from_date;
    protected java.lang.String detention_to_date;
    protected java.lang.Integer is_dead_ship;
    protected java.lang.String remarks;
    protected java.lang.String vessel_master_name;
    protected java.lang.String vessel_master_sign_date;
    protected java.lang.Integer is_job_complete;
    protected java.lang.Integer is_valid;
    protected java.lang.String crt_mod_by;
    protected java.lang.String crt_mod_passwd;
    protected java.lang.String crt_mod_device;
    protected java.lang.String crt_mod_date;
    protected java.lang.String anchoragetime;
    protected java.lang.Integer anchoragereason;
    protected java.lang.String anchorageremarks;

    public MarineHeaderType() {
    }

    public java.lang.Integer getTwsid() {
        return twsid;
    }

    public void setTwsid(java.lang.Integer twsid) {
        this.twsid = twsid;
    }

    public java.lang.Integer getTxn_id() {
        return txn_id;
    }

    public void setTxn_id(java.lang.Integer txn_id) {
        this.txn_id = txn_id;
    }

    public java.lang.Integer getMdt_txn_id() {
        return mdt_txn_id;
    }

    public void setMdt_txn_id(java.lang.Integer mdt_txn_id) {
        this.mdt_txn_id = mdt_txn_id;
    }

    public java.lang.Integer getRotn() {
        return rotn;
    }

    public void setRotn(java.lang.Integer rotn) {
        this.rotn = rotn;
    }

    public java.lang.String getMove_type() {
        return move_type;
    }

    public void setMove_type(java.lang.String move_type) {
        this.move_type = move_type;
    }

    public java.lang.String getFrom_location() {
        return from_location;
    }

    public void setFrom_location(java.lang.String from_location) {
        this.from_location = from_location;
    }

    public java.lang.String getTo_location() {
        return to_location;
    }

    public void setTo_location(java.lang.String to_location) {
        this.to_location = to_location;
    }

    public java.lang.String getVessel_board_time() {
        return vessel_board_time;
    }

    public void setVessel_board_time(java.lang.String vessel_board_time) {
        this.vessel_board_time = vessel_board_time;
    }

    public java.lang.String getVessel_leave_time() {
        return vessel_leave_time;
    }

    public void setVessel_leave_time(java.lang.String vessel_leave_time) {
        this.vessel_leave_time = vessel_leave_time;
    }

    public java.lang.String getLaunch_boat_code() {
        return launch_boat_code;
    }

    public void setLaunch_boat_code(java.lang.String launch_boat_code) {
        this.launch_boat_code = launch_boat_code;
    }

    public java.lang.Integer getModified_vessel_draft() {
        return modified_vessel_draft;
    }

    public void setModified_vessel_draft(java.lang.Integer modified_vessel_draft) {
        this.modified_vessel_draft = modified_vessel_draft;
    }

    public java.lang.String getChannel_entry_time() {
        return channel_entry_time;
    }

    public void setChannel_entry_time(java.lang.String channel_entry_time) {
        this.channel_entry_time = channel_entry_time;
    }

    public java.lang.String getChannel_exit_time() {
        return channel_exit_time;
    }

    public void setChannel_exit_time(java.lang.String channel_exit_time) {
        this.channel_exit_time = channel_exit_time;
    }

    public java.lang.String getBuoy_no() {
        return buoy_no;
    }

    public void setBuoy_no(java.lang.String buoy_no) {
        this.buoy_no = buoy_no;
    }

    public java.lang.String getBuoy_cross_time() {
        return buoy_cross_time;
    }

    public void setBuoy_cross_time(java.lang.String buoy_cross_time) {
        this.buoy_cross_time = buoy_cross_time;
    }

    public java.lang.String getBreakwater_cross_time() {
        return breakwater_cross_time;
    }

    public void setBreakwater_cross_time(java.lang.String breakwater_cross_time) {
        this.breakwater_cross_time = breakwater_cross_time;
    }

    public java.lang.String getFl_time() {
        return fl_time;
    }

    public void setFl_time(java.lang.String fl_time) {
        this.fl_time = fl_time;
    }

    public java.lang.String getLl_time() {
        return ll_time;
    }

    public void setLl_time(java.lang.String ll_time) {
        this.ll_time = ll_time;
    }

    public java.lang.Integer getIs_detained() {
        return is_detained;
    }

    public void setIs_detained(java.lang.Integer is_detained) {
        this.is_detained = is_detained;
    }

    public java.lang.String getDetention_from_date() {
        return detention_from_date;
    }

    public void setDetention_from_date(java.lang.String detention_from_date) {
        this.detention_from_date = detention_from_date;
    }

    public java.lang.String getDetention_to_date() {
        return detention_to_date;
    }

    public void setDetention_to_date(java.lang.String detention_to_date) {
        this.detention_to_date = detention_to_date;
    }

    public java.lang.Integer getIs_dead_ship() {
        return is_dead_ship;
    }

    public void setIs_dead_ship(java.lang.Integer is_dead_ship) {
        this.is_dead_ship = is_dead_ship;
    }

    public java.lang.String getRemarks() {
        return remarks;
    }

    public void setRemarks(java.lang.String remarks) {
        this.remarks = remarks;
    }

    public java.lang.String getVessel_master_name() {
        return vessel_master_name;
    }

    public void setVessel_master_name(java.lang.String vessel_master_name) {
        this.vessel_master_name = vessel_master_name;
    }

    public java.lang.String getVessel_master_sign_date() {
        return vessel_master_sign_date;
    }

    public void setVessel_master_sign_date(java.lang.String vessel_master_sign_date) {
        this.vessel_master_sign_date = vessel_master_sign_date;
    }

    public java.lang.Integer getIs_job_complete() {
        return is_job_complete;
    }

    public void setIs_job_complete(java.lang.Integer is_job_complete) {
        this.is_job_complete = is_job_complete;
    }

    public java.lang.Integer getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(java.lang.Integer is_valid) {
        this.is_valid = is_valid;
    }

    public java.lang.String getCrt_mod_by() {
        return crt_mod_by;
    }

    public void setCrt_mod_by(java.lang.String crt_mod_by) {
        this.crt_mod_by = crt_mod_by;
    }

    public java.lang.String getCrt_mod_passwd() {
        return crt_mod_passwd;
    }

    public void setCrt_mod_passwd(java.lang.String crt_mod_passwd) {
        this.crt_mod_passwd = crt_mod_passwd;
    }

    public java.lang.String getCrt_mod_device() {
        return crt_mod_device;
    }

    public void setCrt_mod_device(java.lang.String crt_mod_device) {
        this.crt_mod_device = crt_mod_device;
    }

    public java.lang.String getCrt_mod_date() {
        return crt_mod_date;
    }

    public void setCrt_mod_date(java.lang.String crt_mod_date) {
        this.crt_mod_date = crt_mod_date;
    }

    public java.lang.String getAnchoragetime() {
        return anchoragetime;
    }

    public void setAnchoragetime(java.lang.String anchoragetime) {
        this.anchoragetime = anchoragetime;
    }

    public java.lang.Integer getAnchoragereason() {
        return anchoragereason;
    }

    public void setAnchoragereason(java.lang.Integer anchoragereason) {
        this.anchoragereason = anchoragereason;
    }

    public java.lang.String getAnchorageremarks() {
        return anchorageremarks;
    }

    public void setAnchorageremarks(java.lang.String anchorageremarks) {
        this.anchorageremarks = anchorageremarks;
    }
}
