package com.chj.listener;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 工程启动监听
 */
public class ConfigListener implements ServletContextListener {

    private static Logger logger = Logger.getLogger(ConfigListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("ConfigListener started!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("ConfigListener destroyed!");
    }
}
