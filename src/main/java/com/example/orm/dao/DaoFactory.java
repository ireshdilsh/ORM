package com.example.orm.dao;

import com.example.orm.dao.custom.impl.AdminDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getDaoFactory(){
        return daoFactory != null ? daoFactory : new DaoFactory();
    }

    public SuperDao getDao(daoType type){
        switch (type) {
            case ADMIN:
                return new AdminDaoImpl();
        
            default:
                return null;
        }
    }

    public enum daoType{
        ADMIN
    }
}
