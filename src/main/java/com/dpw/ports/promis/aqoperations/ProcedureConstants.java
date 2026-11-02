package com.dpw.ports.promis.aqoperations;

@com.dpw.ports.promis.common.annotations.ClassPreamble(
    author ="Kamesh Rao",
    description = "Constants to hold DB procedure params and names",
    reviewers = {"Kamesh Rao"})
public interface ProcedureConstants {
    /*
     * Procedure CTMS_MARINE_INT_PKG.RECEIVE_VOYAGE_CREATE
     */
    public String ROT_GEN_PROC_PARAM_VOY = "pi_marine_voyage_msg_obj";
    public String ROT_GEN_PROC_PARAM_REPROCESS = "pi_reprocess_flg";
    public String ROT_GEN_PROC_PARAM_ROTN_NO = "po_rotn";
    public String ROT_GEN_PROC_PARAM_ERROR_CODE = "po_error_code";
    public String ROT_GEN_PROC_PARAM_ERROR_DESC = "po_error_desc";

    /*
     * Procedure CTMS_MARINE_INT_PKG.SEND_VOYAGE_UPDATE
     */
    public String VOY_UPDATE_PROC_PARAM_TWS_ID = "pi_tws_id";
    public String VOY_UPDATE_PROC_PARAM_USER_NAME = "pi_user_name";
    public String VOY_UPDATE_PROC_PARAM_ERR_DESC = "po_error_desc";

    /*
     * Procedure CTMS_MARINE_INT_PKG.SEND_VOYAGE_CANCEL
     */
    public String VOY_CANCEL_PROC_PARAM_TWS_ID = "pi_tws_id";
    public String VOY_CANCEL_PROC_PARAM_USER_NAME = "pi_user_name";
    public String VOY_CANCEL_PROC_PARAM_ERR_DESC = "po_error_desc";

    /*
     * Procedure CTMS_MARINE_INT_PKG.SEND_VOYAGE_CANCEL
     */
    public String VOY_BILLING_PROC_PARAM_TWS_ID = "pi_tws_id";
    public String VOY_BILLING_PROC_PARAM_ERR_DESC = "po_error_desc";

    /*
     * Procedure CTMS_QUEUE_INTF_PKG.start_dbms_sch_in_voy
     */
    public String START_VOY_SCH_PROC_PARAM_ERR_DESC = "po_error_str";

    /*
     * Procedure CTMS_QUEUE_INTF_PKG.stop_dbms_sch_in_voy
     */
    public String STOP_VOY_SCH_PROC_PARAM_ERR_DESC = "po_error_str";

    /*
     * Procedure CTMS_QUEUE_INTF_PKG.start_dbms_sch_in_tws
     */
    public String START_TWS_SCH_PROC_PARAM_ERR_DESC = "po_error_str";

    /*
     * Procedure CTMS_QUEUE_INTF_PKG.stop_dbms_sch_in_tws
     */
    public String STOP_TWS_SCH_PROC_PARAM_ERR_DESC = "po_error_str";

    /*
     * Query to return the next sequence value for the message header.
     */
    public String NEXT_MSG_HDR_SEQ_QUERY =
        "select marineout_srno_seq.nextval from dual";

    /*
     * Query to retrieve all Queues
     */
    public String GET_ALL_MARINEAQ_JOBS_QUERY =
        "select JOB_NAME from USER_SCHEDULER_JOBS where JOB_CREATOR=?";
}
