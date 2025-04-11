package com.example.orm.dao;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getDaoFactory(){
        return daoFactory != null ? daoFactory : new DaoFactory();
    }

    public SuperDao getDao(daoType type){
        switch (type) {
            case ADMIN:
                return null;
        
            default:
                return null;
        }
    }

    public enum daoType{
        ADMIN
    }
}
