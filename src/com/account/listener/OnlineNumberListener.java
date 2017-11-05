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
            // 没有则自动设置为1
            onlineNumber = 1;
        } else {
            // 有就自增
            onlineNumber++;
        }
        // 放回application
        application.setAttribute("onlineNumber", onlineNumber);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        // 当session被销毁时，在application中取出onlineNumber
        ServletContext application = httpSessionEvent.getSession().getServletContext();
        Integer onlineNumber = (Integer) application.getAttribute("onlineNumber");
        if (onlineNumber != null) {
            // 有就减少
            onlineNumber--;
        } else {
            // 空就自动设置为1
            onlineNumber = 1;
        }
        application.setAttribute("onlineNumber", onlineNumber);
    }
}
