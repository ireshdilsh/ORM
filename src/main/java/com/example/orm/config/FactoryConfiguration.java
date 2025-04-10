package com.example.orm.config;

import com.example.orm.entity.Admin;
import com.example.orm.entity.Programme;
import com.example.orm.entity.Ricieption;
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
        config.addAnnotatedClass(Admin.class);
        config.addAnnotatedClass(Ricieption.class);
        config.addAnnotatedClass(Programme.class);
        sessionFactory = config.buildSessionFactory();
    }

    public static FactoryConfiguration getFactoryConfiguration() {
        return factoryConfiguration == null ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSessionFactory() {
        return sessionFactory.openSession();
    }
}
