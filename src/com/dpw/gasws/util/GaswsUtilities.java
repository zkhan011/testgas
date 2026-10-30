package com.dpw.gasws.util;

import com.pcfc.ports.promis.common.Utilities;
import com.pcfc.services.exception.SystemException;

import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;


public class GaswsUtilities {

    /**
     * 
     * @param date
     * @return
     */
    public static Timestamp convertDateToTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }
    
    /**
     * 
     * @param date   
     * @return
     */
    public static Date parseDate(String date) {
        if(Utilities.isNullOrEmpty(date)) {
            return null;
        }
        SimpleDateFormat parser = new SimpleDateFormat(GaswsIntegrationConstants.DATE_FORMAT);
        parser.setLenient(false);
        try {
            return parser.parse(date);
        } catch (ParseException e) {
            throw new SystemException(e);
        }
    }

   
}
