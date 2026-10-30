package com.dpw.gasws.service;

import com.dpw.gasws.type.ContainerDetailsRequestType;
import com.dpw.gasws.type.ContainerDetailsResponseType;
import com.dpw.gasws.type.EirLocDetailsRequestType;
import com.dpw.gasws.type.EirLocDetailsResponseType;
import com.dpw.gasws.type.ExceptionDataRequestType;
import com.dpw.gasws.type.ExceptionDataResponseType;
import com.dpw.gasws.type.GetTokenRequestType;
import com.dpw.gasws.type.GetTokenResponseType;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GateAutomationService extends Remote {
    public ContainerDetailsResponseType getContainerDetails(ContainerDetailsRequestType contrDtlsReqType) throws RemoteException;

    public EirLocDetailsResponseType getEirLocationDetails(EirLocDetailsRequestType eirLocReqType) throws RemoteException;

    public GetTokenResponseType getTokenDetails(GetTokenRequestType tokenReqType) throws RemoteException;

    public ExceptionDataResponseType postExceptionData(ExceptionDataRequestType exceptionDataReqType) throws RemoteException;
}
