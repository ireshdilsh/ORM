package com.example.orm.dao.custom.impl;

import com.example.orm.config.FactoryConfiguration;
import com.example.orm.dao.custom.PaymentDao;
import com.example.orm.entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PaymentDaoImpl implements PaymentDao {

    FactoryConfiguration factoryConfiguration = FactoryConfiguration.getFactoryConfiguration();

    @Override
    public boolean save(Payment entity)throws Exception {
        Session session = factoryConfiguration.getSessionFactory();
        Transaction transaction = session.beginTransaction();
        try{
            session.persist(entity);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public boolean update(Payment payment) {
        Session session = factoryConfiguration.getSessionFactory();
        Transaction transaction = session.beginTransaction();

        try{
            session.merge(payment);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public boolean deleteByPK(int id)throws Exception {
        return false;
    }

    @Override
    public List<Payment> getAll() {
        return List.of();
    }

    @Override
    public Payment findByPK(int id) {
        return null;
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
