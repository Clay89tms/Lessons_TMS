package org.example.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbstractDaoService {
    @Autowired
    private SessionFactory factory;

    public AbstractDaoService() {
    }

    public Session getSession(){
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public void close(Session session){
        Transaction transaction = session.getTransaction();
        transaction.commit();
        session.close();
    }


}
