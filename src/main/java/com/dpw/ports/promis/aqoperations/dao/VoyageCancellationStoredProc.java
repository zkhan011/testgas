package com.dpw.ports.promis.aqoperations.dao;

import com.dpw.ports.promis.aqoperations.ProcedureConstants;
import com.dpw.ports.promis.common.annotations.ClassPreamble;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;


@com.dpw.ports.promis.common.annotations.ClassPreamble(
    author ="Kamesh Rao",
    description = "Class that maps stored procedure ctms_marine_int_pkg.send_voyage_cancel",
    reviewers = {"Kamesh Rao"})
public class VoyageCancellationStoredProc extends StoredProcedure {
    private static final String SPROC_NAME =
        "ctms_msg_intf_pkg.send_voyage_cancel";

    public VoyageCancellationStoredProc(DataSource ds) {
        super.setDataSource(ds);
        super.setFunction(Boolean.FALSE);
        super.setSql(SPROC_NAME);
        declareParameter(new SqlParameter(ProcedureConstants.VOY_CANCEL_PROC_PARAM_TWS_ID,
                                          Types.NUMERIC));
        declareParameter(new SqlParameter(ProcedureConstants.VOY_CANCEL_PROC_PARAM_USER_NAME,
                                          Types.VARCHAR));
        declareParameter(new SqlOutParameter(ProcedureConstants.VOY_CANCEL_PROC_PARAM_ERR_DESC,
                                             Types.VARCHAR));
    }

    public Map execute(Long twsId, String username) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put(ProcedureConstants.VOY_UPDATE_PROC_PARAM_TWS_ID, twsId);
        paramMap.put(ProcedureConstants.VOY_UPDATE_PROC_PARAM_USER_NAME,
                     username);
        return super.execute(paramMap);
    }
}
