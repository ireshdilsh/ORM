package com.example.orm.dao;

import com.example.orm.dao.custom.impl.AdminDaoImpl;
import com.example.orm.dao.custom.impl.ProgrammeDaoImpl;
import com.example.orm.dao.custom.impl.RicieptionDaoImpl;

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
            case RICIEPTION:
                return new RicieptionDaoImpl();
            case PROGRAMME:
                return new ProgrammeDaoImpl();
            default:
                return null;
        }
    }

    public enum daoType{
        ADMIN,RICIEPTION,PROGRAMME
    }
}
