package com.quitomos.j2ee2.Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("add:" + event.getName() + ":" + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("delete:" + event.getName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("replace:" + event.getName());
    }
}
