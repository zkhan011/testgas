package com.dpw.gen.util;

  
import javax.crypto.Cipher;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptDecryptUtil {
    private static Log logger = LogFactory.getLog(EncryptDecryptUtil.class);
    
    private static Cipher cipher;  
    private static Key key;    
    
    static {                 
            EncryptDecryptUtil encrypter = new EncryptDecryptUtil();   
    }
    
    EncryptDecryptUtil() {
        try {
            cipher = Cipher.getInstance("DES/ECB/NoPadding");
        } catch (Exception e) {
            logger.error(e);
        }
    }

        public static void main(String[] args) {
            try {                   
                   String password = EncryptDecryptUtil.encrypt("gateuser","gatetest");
                   System.out.println("Encrypted:"+password);          
                   System.out.println("Decrypted:"+EncryptDecryptUtil.decrypt(password,"gatetest"));                 
            } catch (Throwable e) {
                    e.printStackTrace();
            }
        }   
    
        public static String encrypt(String user, String keyString) throws Exception {  
            key = new SecretKeySpec(keyString.getBytes(), "DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte encryptString[] = cipher.doFinal(user.getBytes("UTF8"));  
            String encodedString = new BASE64Encoder().encode(encryptString);
            return new String(encodedString);
        }

        public static String decrypt(String password, String keyString) throws Exception {   
            key = new SecretKeySpec(keyString.getBytes(), "DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte decodedString[] = (new BASE64Decoder()).decodeBuffer(password);
            byte decrptString[] = cipher.doFinal(decodedString);         
            return new String(decrptString,"UTF8");
        }         

}
