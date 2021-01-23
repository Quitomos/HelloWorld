package com.quitomos.j2ee2.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("app destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("app init");
    }
}
