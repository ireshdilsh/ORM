package com.example.orm.dao.custom.impl;

import java.util.List;
import java.util.Optional;

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
    @Override
    public boolean update(Ricieption t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public boolean deleteByPK(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByPK'");
    }
    @Override
    public List<Ricieption> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    @Override
    public Optional<Ricieption> findByPK(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPK'");
    }
    @Override
    public Optional<String> getLastPK() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastPK'");
    }

}
