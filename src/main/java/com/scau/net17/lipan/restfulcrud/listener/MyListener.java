package com.scau.net17.lipan.restfulcrud.listener;

import org.apache.tomcat.util.digester.SetPropertiesRule;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
