package com.example.orm.dao.custom.impl;

import com.example.orm.config.FactoryConfiguration;
import com.example.orm.dao.custom.PatcientDao;
import com.example.orm.entity.Patcients;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PatcientDaoImpl implements PatcientDao {

    FactoryConfiguration factoryConfiguration = FactoryConfiguration.getFactoryConfiguration();

    @Override
    public boolean save(Patcients entity)throws Exception {
//        Session session = factoryConfiguration.getSessionFactory();
//        Transaction tx = session.beginTransaction();
//        try{
//            session.persist(entity);
//            tx.commit();
//            return true;
//        }catch (Exception e) {
//            e.printStackTrace();
//            tx.rollback();
//            return false;
//        }finally{
//            if (session != null){
//                session.close();
//            }
//        }
        return false;
    }

    @Override
    public boolean update(Patcients patcients) {
        Session session = factoryConfiguration.getSessionFactory();
        Transaction tx = session.beginTransaction();
        try{
            session.merge(patcients);
            tx.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }finally{
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public boolean deleteByPK(int id)throws Exception {
        Session session = factoryConfiguration.getSessionFactory();
        Transaction transaction = session.beginTransaction();
        Patcients patcients = session.get(Patcients.class, id);
        try{
            session.remove(patcients);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally{
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Patcients> getAll() {
        Session session = factoryConfiguration.getSessionFactory();
        return session.createQuery("from patcient").list();
    }

    @Override
    public Patcients findByPK(int id) {
        Session session = factoryConfiguration.getSessionFactory();
        return session.get(Patcients.class, id);
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
    @Override
    public int saves(Patcients patcient) {
        int generatedId;
        Session session = factoryConfiguration.getSessionFactory();
        Transaction tx = session.beginTransaction();
        try {
            generatedId = (int) session.save(patcient); // Hibernate assigns ID here
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        return generatedId;
    }
}
