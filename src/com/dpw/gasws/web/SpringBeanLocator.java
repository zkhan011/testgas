package com.dpw.gasws.web;

import org.springframework.web.context.WebApplicationContext;


public class SpringBeanLocator {
    
    private static WebApplicationContext appContext = null;
    /*
     * Eagerly loading the static instance so as to remove the synchronization
     * overhead.
     */
    private static SpringBeanLocator beanLocator = new SpringBeanLocator();
    
    private SpringBeanLocator() {
    }
    
    public static SpringBeanLocator getInstance(){
        return beanLocator;
    }

    public void setAppContext(WebApplicationContext appContext) {
        this.appContext = appContext;
    }

    private WebApplicationContext getAppContext() {
        return appContext;
    }
    
    public static Object getBean(String beanName){
        Object o  = getInstance().getAppContext().getBean(beanName);        
        return o;
    }
}
