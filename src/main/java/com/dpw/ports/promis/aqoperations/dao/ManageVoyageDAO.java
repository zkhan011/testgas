package com.dpw.ports.promis.aqoperations.dao;

import com.dpw.ports.promis.common.integration.domain.Voyage;
import com.dpw.ports.promis.common.annotations.ClassPreamble;


@com.dpw.ports.promis.common.annotations.ClassPreamble(
    author ="Kamesh Rao",
    description = "DAO Class for Managing Voyage services",
    reviewers = {"Kamesh Rao"})
public interface ManageVoyageDAO {

    /**
     * Generates a rotation no for the given voyage details.
     * @param voyage
     * @return
     */
    public Long generateRotationNo(Voyage voyage);

    /**
     * Updates voyage details for the given TWSID.
     *
     * @param twsId
     * @param userName
     * @return
     */
    public String adviceVoyage(Long twsId, String userName);

    /**
     * Cancels voyage details for the given TWSID.
     *
     * @param twsId
     * @param username
     * @return
     */
    public String cancelVoyage(Long twsId, String username);

    /**
     * Method that sends a billing message to CTMS for the specified twsid.
     * @param twsId
     * @return
     */
    public String billVoyage(Long twsId);
}
