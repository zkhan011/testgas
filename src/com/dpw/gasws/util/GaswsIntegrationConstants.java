package com.dpw.gasws.util;


public interface GaswsIntegrationConstants { 

    String DATE_FORMAT = "dd/MM/yyyy HH:mm";
    String DATE_FORMAT_SHORT = "ddMMyyyyHHmm";
   
    String EMPTY_STRING = "";   
    String YES = "Y";
    
    String ENCRYPT_KEY = ConfigurationLoader.getStringProperty("ws.encryption.key");   
    boolean DB_REDIRECT = ConfigurationLoader.getBooleanProperty("db.conn.redirect");   
    
}

