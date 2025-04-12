package com.example.orm.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.orm.config.FactoryConfiguration;
import com.example.orm.dao.custom.RicieptionDao;
import com.example.orm.entity.Ricieption;

public class RicieptionDaoImpl implements RicieptionDao{

    FactoryConfiguration configuration = FactoryConfiguration.getFactoryConfiguration();
    @Override
    public boolean save(Ricieption entity) throws Exception {
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
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

}
