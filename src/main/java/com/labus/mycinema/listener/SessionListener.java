package com.labus.mycinema.listener;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private final static Logger logger = Logger.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
            logger.log(Level.INFO, "Session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        logger.log(Level.INFO, "Session destroyed");}
}
