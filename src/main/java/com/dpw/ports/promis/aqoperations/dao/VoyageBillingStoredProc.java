package com.dpw.ports.promis.aqoperations.dao;

import com.dpw.ports.promis.aqoperations.ProcedureConstants;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

@com.dpw.ports.promis.common.annotations.ClassPreamble(
    author ="Kamesh Rao",
    description = "Class that maps to stored procedure ctms_marine_int_pkg.send_billing_update",
    reviewers = {"Kamesh Rao"})
public class VoyageBillingStoredProc extends StoredProcedure{
    private static final String SPROC_NAME =
        "ctms_msg_intf_pkg.send_billing_update";

    public VoyageBillingStoredProc(DataSource ds) {
        super.setDataSource(ds);
        super.setFunction(Boolean.FALSE);
        super.setSql(SPROC_NAME);
        declareParameter(new SqlParameter(ProcedureConstants.VOY_BILLING_PROC_PARAM_TWS_ID,
                                          Types.NUMERIC));
        declareParameter(new SqlOutParameter(ProcedureConstants.VOY_BILLING_PROC_PARAM_ERR_DESC,
                                             Types.VARCHAR));
    }

    public Map execute(Long twsId) {
        Map paramMap = new HashMap();
        paramMap.put(ProcedureConstants.VOY_BILLING_PROC_PARAM_TWS_ID, twsId);
        return super.execute(paramMap);
    }
}
