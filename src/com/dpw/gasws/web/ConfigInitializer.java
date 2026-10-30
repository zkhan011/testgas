package com.dpw.gasws.web;

import com.dpw.gasws.web.SpringBeanLocator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class ConfigInitializer implements ServletContextListener{
    private Log logger = LogFactory.getLog(ConfigInitializer.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.debug("Begin ConfigInitializer.contextInitialized()...");
        ServletContext servletContext = servletContextEvent.getServletContext();
        WebApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        SpringBeanLocator.getInstance().setAppContext(appContext);
        logger.debug("End ConfigInitializer.contextInitialized()");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
