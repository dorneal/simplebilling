package com.account.listener;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计系统在线人数
 *
 * @author Neal
 */
public class OnlineNumberListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //从application中取出onlineNumber
        ServletContext application = httpSessionEvent.getSession().getServletContext();
        Integer onlineNumber = (Integer) application.getAttribute("onlineNumber");
        if (onlineNumber == null) {
            onlineNumber = 1;
        } else {
            onlineNumber++;
        }
        application.setAttribute("onlineNumber", onlineNumber);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext application = httpSessionEvent.getSession().getServletContext();
        Integer onlineNumber = (Integer) application.getAttribute("onlineNumber");
        if (onlineNumber != null) {
            onlineNumber--;
        } else {
            onlineNumber = 1;
        }
        application.setAttribute("onlineNumber", onlineNumber);

    }
}
