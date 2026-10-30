

package com.dpw.gasws.util;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.List;
import java.util.Properties;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ConfigurationLoader {
    private static ConfigurationLoader configurationLoader = null;
    private static Configuration _config = null;

    private static final Log log = 
        LogFactory.getLog(ConfigurationLoader.class);

    static {
        createInstance();
    }

    private ConfigurationLoader() {
        loadProperties();
    }

    private void loadProperties() {
        ConfigurationFactory _configFactory = new ConfigurationFactory();
        URL configURL = null;
        try {
            configURL = new File("config.xml").toURL();
            log.info("------ configURL-----" + configURL.toString());
            _configFactory.setConfigurationFileName(configURL.toString());
            _config = _configFactory.getConfiguration();
            log.info("------ Configuration Loader Initialized-----");
        } catch (MalformedURLException e) {
            log.error(e);
        } catch (ConfigurationException e) {
            log.error(e);
        }
    }

    private static synchronized ConfigurationLoader createInstance() {
        return new ConfigurationLoader();

    }

    public static Object getProperty(String property) {
        return _config.getProperty(property);
    }

    public static Properties getProperties(String property) {
        return _config.getProperties(property);
    }

    public static String getStringProperty(String property) {
        return _config.getString(property);
    }

    public static int getIntProperty(String property) {
        return _config.getInt(property);
    }

    public static List getPropertyList(String property) {
        return _config.getList(property);
    }

    public static String[] getPropertyArray(String property) {
        return _config.getStringArray(property);
    }
    
    public static boolean getBooleanProperty(String property) {
        return _config.getBoolean(property);
    }
}
