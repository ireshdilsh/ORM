package com.example.orm.config;

import com.example.orm.entity.Admin;
import com.example.orm.entity.Patcients;
import com.example.orm.entity.Payment;
import com.example.orm.entity.Programme;
import com.example.orm.entity.Ricieption;
import com.example.orm.entity.Sessions;
import com.example.orm.entity.Therepists;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration config = new Configuration();
        config.configure();
        // has call entity classes.
        config.addAnnotatedClass(Admin.class)
        .addAnnotatedClass(Programme.class)
        .addAnnotatedClass(Ricieption.class)
        .addAnnotatedClass(Patcients.class)
        .addAnnotatedClass(Sessions.class)
        .addAnnotatedClass(Therepists.class)
        .addAnnotatedClass(Payment.class);
        sessionFactory = config.buildSessionFactory();
    }

    public static FactoryConfiguration getFactoryConfiguration() {
        return factoryConfiguration != null ? factoryConfiguration : new FactoryConfiguration();
       // return factoryConfiguration == null ? new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSessionFactory() {
        return sessionFactory.openSession();
    }
}
