package com.dpw.ports.promis.hht.domain;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class MarineHeaderSqlType implements SQLData {
    private Integer twsid;
    private Integer txn_id;
    private Integer rotn;
    private String move_type;
    private String from_location;
    private String to_location;
    private String vessel_board_time;
    private String vessel_leave_time;
    private String launch_boat_code;
    private Integer modified_vessel_draft;
    private String channel_entry_time;
    private String channel_exit_time;
    private String buoy_no;
    private String buoy_cross_time;
    private String breakwater_cross_time;
    private String fl_time;
    private String ll_time;
    private Integer is_detained;
    private String detention_from_date;
    private String detention_to_date;
    private Integer is_dead_ship;
    private String remarks;
    private String vessel_master_name;
    private String vessel_master_sign_date;
    private Integer is_job_complete;
    private Integer is_valid;
    private String crt_mod_by;
    private String crt_mod_passwd;
    private String crt_mod_device;
    private String crt_mod_date;
    private String anchoragetime;
    private Integer anchoragereason;
    private String anchorageremarks;
    private String sqlTypeName;

    public MarineHeaderSqlType() {
    }

    public String getSQLTypeName() {
        return sqlTypeName;
    }

    public void readSQL(SQLInput stream, String typeName) throws SQLException{
        txn_id= stream.readInt();
        rotn= stream.readInt();
        move_type = stream.readString();
        from_location= stream.readString();
        to_location= stream.readString();
        vessel_board_time= stream.readString();
        vessel_leave_time= stream.readString();
        launch_boat_code= stream.readString();
        modified_vessel_draft= stream.readInt();
        channel_entry_time= stream.readString();
        channel_exit_time= stream.readString();
        buoy_no= stream.readString();
        buoy_cross_time= stream.readString();
        breakwater_cross_time= stream.readString();
        fl_time= stream.readString();
        ll_time= stream.readString();
        is_detained= stream.readInt();
        detention_from_date= stream.readString();
        detention_to_date= stream.readString();
        is_dead_ship= stream.readInt();
        remarks= stream.readString();
        vessel_master_name= stream.readString();
        vessel_master_sign_date= stream.readString();
        is_job_complete= stream.readInt();
        is_valid= stream.readInt();
        crt_mod_by= stream.readString();
        crt_mod_passwd= stream.readString();
        crt_mod_device= stream.readString();
        crt_mod_date= stream.readString();
        twsid = stream.readInt();
        anchoragetime = stream.readString();
        anchoragereason = stream.readInt();
        anchoragetime = stream.readString();
        anchorageremarks = stream.readString();
    }

    public void writeSQL(SQLOutput stream) throws SQLException{
        stream.writeInt(txn_id);
        stream.writeInt(rotn);
        stream.writeString(move_type);
        stream.writeString(from_location);
        stream.writeString(to_location);
        stream.writeString(vessel_board_time);
        stream.writeString(vessel_leave_time);
        stream.writeString(launch_boat_code);
        stream.writeInt(modified_vessel_draft);
        stream.writeString(channel_entry_time);
        stream.writeString(channel_exit_time);
        stream.writeString(buoy_no);
        stream.writeString(buoy_cross_time);
        stream.writeString(breakwater_cross_time);
        stream.writeString(fl_time);
        stream.writeString(ll_time);
        stream.writeInt(is_detained);
        stream.writeString(detention_from_date);
        stream.writeString(detention_to_date);
        stream.writeInt(is_dead_ship);
        stream.writeString(remarks);
        stream.writeString(vessel_master_name);
        stream.writeString(vessel_master_sign_date);
        stream.writeInt(is_job_complete);
        stream.writeInt(is_valid);
        stream.writeString(crt_mod_by);
        stream.writeString(crt_mod_passwd);
        stream.writeString(crt_mod_device);
        stream.writeString(crt_mod_date);
        stream.writeInt(twsid);
        stream.writeString(anchoragetime);
        stream.writeInt(anchoragereason);
        stream.writeString(anchorageremarks);
    }

    public void setTxn_id(Integer txn_id) {
        this.txn_id = txn_id;
    }

    public Integer getTxn_id() {
        return txn_id;
    }

    public void setRotn(Integer rotn) {
        this.rotn = rotn;
    }

    public Integer getRotn() {
        return rotn;
    }

    public void setMove_type(String move_type) {
        this.move_type = move_type;
    }

    public String getMove_type() {
        return move_type;
    }

    public void setFrom_location(String from_location) {
        this.from_location = from_location;
    }

    public String getFrom_location() {
        return from_location;
    }

    public void setTo_location(String to_location) {
        this.to_location = to_location;
    }

    public String getTo_location() {
        return to_location;
    }

    public void setVessel_board_time(String vessel_board_time) {
        this.vessel_board_time = vessel_board_time;
    }

    public String getVessel_board_time() {
        return vessel_board_time;
    }

    public void setVessel_leave_time(String vessel_leave_time) {
        this.vessel_leave_time = vessel_leave_time;
    }

    public String getVessel_leave_time() {
        return vessel_leave_time;
    }

    public void setLaunch_boat_code(String launch_boat_id) {
        this.launch_boat_code = launch_boat_id;
    }

    public String getLaunch_boat_code() {
        return launch_boat_code;
    }

    public void setModified_vessel_draft(Integer modified_vessel_draft) {
        this.modified_vessel_draft = modified_vessel_draft;
    }

    public Integer getModified_vessel_draft() {
        return modified_vessel_draft;
    }

    public void setChannel_entry_time(String channel_entry_time) {
        this.channel_entry_time = channel_entry_time;
    }

    public String getChannel_entry_time() {
        return channel_entry_time;
    }

    public void setChannel_exit_time(String channel_exit_time) {
        this.channel_exit_time = channel_exit_time;
    }

    public String getChannel_exit_time() {
        return channel_exit_time;
    }

    public void setBuoy_no(String buoy_no) {
        this.buoy_no = buoy_no;
    }

    public String getBuoy_no() {
        return buoy_no;
    }

    public void setBuoy_cross_time(String buoy_cross_time) {
        this.buoy_cross_time = buoy_cross_time;
    }

    public String getBuoy_cross_time() {
        return buoy_cross_time;
    }

    public void setBreakwater_cross_time(String breakwater_cross_time) {
        this.breakwater_cross_time = breakwater_cross_time;
    }

    public String getBreakwater_cross_time() {
        return breakwater_cross_time;
    }

    public void setFl_time(String fl_time) {
        this.fl_time = fl_time;
    }

    public String getFl_time() {
        return fl_time;
    }

    public void setLl_time(String ll_time) {
        this.ll_time = ll_time;
    }

    public String getLl_time() {
        return ll_time;
    }

    public void setIs_detained(Integer is_detained) {
        this.is_detained = is_detained;
    }

    public Integer getIs_detained() {
        return is_detained;
    }

    public void setDetention_from_date(String detention_from_date) {
        this.detention_from_date = detention_from_date;
    }

    public String getDetention_from_date() {
        return detention_from_date;
    }

    public void setDetention_to_date(String detention_to_date) {
        this.detention_to_date = detention_to_date;
    }

    public String getDetention_to_date() {
        return detention_to_date;
    }

    public void setIs_dead_ship(Integer is_dead_ship) {
        this.is_dead_ship = is_dead_ship;
    }

    public Integer getIs_dead_ship() {
        return is_dead_ship;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setVessel_master_name(String vessel_master_name) {
        this.vessel_master_name = vessel_master_name;
    }

    public String getVessel_master_name() {
        return vessel_master_name;
    }

    public void setVessel_master_sign_date(String vessel_master_sign_date) {
        this.vessel_master_sign_date = vessel_master_sign_date;
    }

    public String getVessel_master_sign_date() {
        return vessel_master_sign_date;
    }

    public void setIs_job_complete(Integer is_job_complete) {
        this.is_job_complete = is_job_complete;
    }

    public Integer getIs_job_complete() {
        return is_job_complete;
    }

    public void setIs_valid(Integer is_valid) {
        this.is_valid = is_valid;
    }

    public Integer getIs_valid() {
        return is_valid;
    }

    public void setCrt_mod_by(String crt_mod_by) {
        this.crt_mod_by = crt_mod_by;
    }

    public String getCrt_mod_by() {
        return crt_mod_by;
    }

    public void setCrt_mod_passwd(String crt_mod_passwd) {
        this.crt_mod_passwd = crt_mod_passwd;
    }

    public String getCrt_mod_passwd() {
        return crt_mod_passwd;
    }

    public void setCrt_mod_device(String crt_mod_device) {
        this.crt_mod_device = crt_mod_device;
    }

    public String getCrt_mod_device() {
        return crt_mod_device;
    }

    public void setCrt_mod_date(String crt_mod_date) {
        this.crt_mod_date = crt_mod_date;
    }

    public String getCrt_mod_date() {
        return crt_mod_date;
    }

    public void setSqlTypeName(String sqlTypeName) {
        this.sqlTypeName = sqlTypeName;
    }

    public String getSqlTypeName() {
        return sqlTypeName;
    }

    public void setTwsid(Integer twsid) {
        this.twsid = twsid;
    }

    public Integer getTwsid() {
        return twsid;
    }

    public void setAnchoragetime(String anchoragetime) {
        this.anchoragetime = anchoragetime;
    }

    public String getAnchoragetime() {
        return anchoragetime;
    }

    public void setAnchoragereason(Integer anchoragereason) {
        this.anchoragereason = anchoragereason;
    }

    public Integer getAnchoragereason() {
        return anchoragereason;
    }

    public void setAnchorageremarks(String anchorageremarks) {
        this.anchorageremarks = anchorageremarks;
    }

    public String getAnchorageremarks() {
        return anchorageremarks;
    }

 public Object[] attributes(){return new Object[]{txn_id,rotn,move_type,from_location,to_location,vessel_board_time,vessel_leave_time,launch_boat_code,modified_vessel_draft,channel_entry_time,channel_exit_time,buoy_no,buoy_cross_time,breakwater_cross_time,fl_time,ll_time,is_detained,detention_from_date,detention_to_date,is_dead_ship,remarks,vessel_master_name,vessel_master_sign_date,is_job_complete,is_valid,crt_mod_by,crt_mod_passwd,crt_mod_device,crt_mod_date,twsid,anchoragetime,anchoragereason,anchorageremarks};}
}
