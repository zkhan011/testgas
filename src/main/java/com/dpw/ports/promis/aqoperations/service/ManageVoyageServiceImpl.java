package com.dpw.ports.promis.aqoperations.service;

import com.dpw.ports.promis.common.integration.domain.Voyage;
import com.dpw.ports.promis.common.integration.service.ManageVoyageService;
import com.dpw.ports.promis.common.annotations.ClassPreamble;
import com.dpw.ports.promis.aqoperations.dao.ManageVoyageDAO;


@com.dpw.ports.promis.common.annotations.ClassPreamble(
    author ="Kamesh Rao",
    description = "Service class implementation for rotationgeneration services.",
    reviewers ={"Kamesh Rao"})
public class ManageVoyageServiceImpl implements ManageVoyageService {

    private ManageVoyageDAO voyagesDAO;

    public void setVoyagesDAO(ManageVoyageDAO rotationGenerationDAO) {
        this.voyagesDAO = rotationGenerationDAO;
    }

    public ManageVoyageDAO getVoyagesDAO() {
        return voyagesDAO;
    }

    /**
     * @see {@link com.dpw.ports.promis.common.integration.service.ManageVoyageService#generateRotationNo(Voyage)}
     */
    public Long generateRotationNo(Voyage voyage) {
        return getVoyagesDAO().generateRotationNo(voyage);
    }

    /**
     * @see {@link com.dpw.ports.promis.common.integration.service.ManageVoyageService#adviceVoyage(Long,String)}
     */
    public String adviceVoyage(Long twsId, String userName) {
        return getVoyagesDAO().adviceVoyage(twsId, userName);
    }

    /**
     * @see {@link com.dpw.ports.promis.common.integration.service.ManageVoyageService#cancelVoyage(Long,String)}
     */
    public String cancelVoyage(Long twsId, String username) {
        return getVoyagesDAO().cancelVoyage(twsId, username);
    }

    /**
     * @see {@link com.dpw.ports.promis.common.integration.service.ManageVoyageService#billVoyage(Long)}
     */
    public String billVoyage(Long twsId) {
        return getVoyagesDAO().billVoyage(twsId);
    }
}
