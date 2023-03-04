package org.example;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class IdCarsServletSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        String id = session.getId();
        boolean aNew = session.isNew();
        long lastAccessedTime = session.getLastAccessedTime();
        long creationTime = session.getCreationTime();
        System.out.println("Создана новая Сессия: { " + session + " }");
        System.out.println("ID = " + id + "\nlastAccessedTime" + lastAccessedTime + "\ncreationTime" + creationTime);


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.invalidate();
    }
}
