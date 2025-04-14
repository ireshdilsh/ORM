package com.example.orm.dao;

import com.example.orm.dao.custom.impl.*;

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
            case THEREPIST:
                return new TherepistDaoImpl();
                case SESSIONS:
                    return new SessionDaoImpl();
            case PATCIENT:
                return new PatcientDaoImpl();
            case PAYMENT:
                return new PaymentDaoImpl();
            default:
                return null;
        }
    }

    public enum daoType{
        ADMIN,RICIEPTION,PROGRAMME,THEREPIST,SESSIONS,PATCIENT,PAYMENT
    }
}
