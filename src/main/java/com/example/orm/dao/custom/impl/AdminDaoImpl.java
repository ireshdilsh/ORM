package com.example.orm.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.orm.config.FactoryConfiguration;
import com.example.orm.dao.custom.AdminDao;
import com.example.orm.entity.Admin;

public class AdminDaoImpl implements AdminDao {

    FactoryConfiguration configuration = FactoryConfiguration.getFactoryConfiguration();

    @Override
    public boolean save(Admin entity) throws Exception {
        Session session = configuration.getSessionFactory();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
