package com.yevhenio.blackjack.repository;


import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by eugene on 05.10.15.
 */
//Hibernate connection singleton
public class HibSingle {

    private static SessionFactory ourSessionFactory;
    private static HibSingle hibSingle;


    HibSingle() {

    }

    public static HibSingle getInstance() {
        if (hibSingle == null) {
            try {
                hibSingle = new HibSingle();
                Configuration configuration = new Configuration();
                configuration.configure(Hibernate.class.getResource("/hibernate.cfg.xml"));
                ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
                ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return hibSingle;
    }

    public Session getSession() throws HibernateException {
        Session session = null;
        try {
            session = ourSessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }


}

