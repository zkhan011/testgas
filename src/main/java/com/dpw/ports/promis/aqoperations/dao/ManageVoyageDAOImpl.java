package com.dpw.ports.promis.aqoperations.dao;

import com.dpw.ports.promis.aqoperations.ProcedureConstants;
import com.dpw.ports.promis.common.Utilities;
import com.dpw.ports.promis.common.integration.IntegrationConstants;
import com.dpw.ports.promis.common.integration.domain.Voyage;
import com.dpw.ports.promis.common.service.BusinessConstants;
import com.dpw.services.exception.ApplicationException;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


@com.dpw.ports.promis.common.annotations.ClassPreamble(
    author ="Kamesh Rao",
    description = "DAO implementation for Managing Voyage services",
    reviewers = {"Kamesh Rao"})
public class ManageVoyageDAOImpl implements ManageVoyageDAO {

    private Log logger = LogFactory.getLog(ManageVoyageDAOImpl.class);


    private VoyageCreationStoredProc voyCreateJAStoredProc;

    private VoyageCreationStoredProc voyCreatePRStoredProc;

    private VoyageUpdatedStoredProc voyUpdatedStoredProc;

    private VoyageCancellationStoredProc voyCancelStoredProc;

    private VoyageBillingStoredProc voyBillingStoreProc;

    private JdbcTemplate jdbcTemplate;

    public ManageVoyageDAOImpl(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public void setVoyUpdatedStoredProc(VoyageUpdatedStoredProc voyUpdatedStoredProc) {
        this.voyUpdatedStoredProc = voyUpdatedStoredProc;
    }

    public void setVoyCreateJAStoredProc(VoyageCreationStoredProc rotGenStoredProc) {
        this.voyCreateJAStoredProc = rotGenStoredProc;
    }

    public VoyageCreationStoredProc getVoyCreateJAStoredProc() {
        return voyCreateJAStoredProc;
    }

    public VoyageUpdatedStoredProc getVoyUpdatedStoredProc() {
        return voyUpdatedStoredProc;
    }

    public void setVoyCancelStoredProc(VoyageCancellationStoredProc voyCancelStoredProc) {
        this.voyCancelStoredProc = voyCancelStoredProc;
    }

    public VoyageCancellationStoredProc getVoyCancelStoredProc() {
        return voyCancelStoredProc;
    }

    public void setVoyBillingStoreProc(VoyageBillingStoredProc voyBillingStoreProc) {
        this.voyBillingStoreProc = voyBillingStoreProc;
    }

    public VoyageBillingStoredProc getVoyBillingStoreProc() {
        return voyBillingStoreProc;
    }

    /**
     * @see {@link com.dpw.ports.promis.aqoperations.dao.ManageVoyageDAO#generateRotationNo(Voyage)}
     */
    public Long generateRotationNo(Voyage voyage) {
        try {

            /*
             * Apply all the business rules required
             */
            voyage.performBusinessRules();
            /*
             * Perform all integration specific changes.
             */
            voyage.applyIntegrationSpecificChangesOnFields();

            Map outputMap = null;
            /*
             * Based on the port code, request rotation generation services from
             * either CTMS_JA or CTMS_PR databases.
             */
            if(voyage.getPortCode().equalsIgnoreCase(BusinessConstants.JABEL_ALI_PORT_CODE)){
                outputMap = getVoyCreateJAStoredProc().execute(voyage,getSerialNumber().toString());
            }else{
                outputMap = getVoyCreatePRStoredProc().execute(voyage,getSerialNumber().toString());
            }
            String errorCode =
                (String)outputMap.get(ProcedureConstants.ROT_GEN_PROC_PARAM_ERROR_CODE);

            if (Utilities.isNullOrEmpty(errorCode)) {
                return ((BigDecimal)outputMap.get(ProcedureConstants.ROT_GEN_PROC_PARAM_ROTN_NO)).longValue();
            } else {
                String errorDesc =
                    (String)outputMap.get(ProcedureConstants.ROT_GEN_PROC_PARAM_ERROR_DESC);
                logger.error("Could not generate Rotation no. ErrorDesc:" +
                             errorDesc);
                throw new ApplicationException(errorDesc);
            }
        } catch (DataAccessException dax) {
            logger.error(dax);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,dax.getMessage());
        } catch (SQLException sqlex) {
            logger.error(sqlex);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,sqlex.getMessage());
        } catch (Exception ex) {
            logger.error(ex);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,ex.getMessage());
        }
    }

    /**
     * @see {@link com.dpw.ports.promis.aqoperations.dao.ManageVoyageDAO#adviceVoyage(Long,String)}
     */
    public String adviceVoyage(Long twsId, String username) {
        try{
            Map outputMap = getVoyUpdatedStoredProc().execute(twsId,username);
            return (String)outputMap.get(ProcedureConstants.VOY_UPDATE_PROC_PARAM_ERR_DESC);
        }catch(DataAccessException dax){
            logger.error(new StringBuilder("Exception processing voyage update for TWSID").append(twsId).toString());
            logger.error(dax);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,dax.getMessage());
        }catch(Exception ex){
            logger.error(new StringBuilder("Exception processing voyage update for TWSID").append(twsId).toString());
            logger.error(ex);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,ex.getMessage());
        }
    }

    /**
     * @see {@link com.dpw.ports.promis.aqoperations.dao.ManageVoyageDAO#cancelVoyage(Long,String)}
     */
    public String cancelVoyage(Long twsId,String username){
        try{
            Map outputMap = getVoyCancelStoredProc().execute(twsId,username);
            return (String)outputMap.get(ProcedureConstants.VOY_CANCEL_PROC_PARAM_ERR_DESC);
        }catch(DataAccessException dax){
            logger.error(new StringBuilder("Exception processing voyage cancellation for TWSID").append(twsId).toString());
            logger.error(dax);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,dax.getMessage());
        }catch(Exception ex){
            logger.error(new StringBuilder("Exception processing voyage cancellation for TWSID").append(twsId).toString());
            logger.error(ex);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,ex.getMessage());
        }
    }

    /**
     * @see {@link com.dpw.ports.promis.aqoperations.dao.ManageVoyageDAO#billVoyage(Long)}
     */
    public String billVoyage(Long twsId){
        try{
            Map outputMap = getVoyBillingStoreProc().execute(twsId);
            return (String)outputMap.get(ProcedureConstants.VOY_BILLING_PROC_PARAM_ERR_DESC);
        }catch(DataAccessException dax){
            logger.error(new StringBuilder("Exception sending voyage billing for TWSID").append(twsId).toString());
            logger.error(dax);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,dax.getMessage());
        }catch(Exception ex){
            logger.error(new StringBuilder("Exception sending voyage billing for TWSID").append(twsId).toString());
            logger.error(ex);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,ex.getMessage());
        }
    }

    /**
     *
     * @return
     */
    private Integer getSerialNumber() {
        return jdbcTemplate.queryForObject(ProcedureConstants.NEXT_MSG_HDR_SEQ_QUERY,Integer.class);
    }


    public void setVoyCreatePRStoredProc(VoyageCreationStoredProc voyCreatePRStoredProc) {
        this.voyCreatePRStoredProc = voyCreatePRStoredProc;
    }

    public VoyageCreationStoredProc getVoyCreatePRStoredProc() {
        return voyCreatePRStoredProc;
    }

}
