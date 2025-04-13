package com.example.orm.service;

import com.example.orm.service.custom.impl.AdminServiceImpl;
import com.example.orm.service.custom.impl.ProgrammeServiceImpl;
import com.example.orm.service.custom.impl.RicieptionServiceImpl;
import com.example.orm.service.custom.impl.SessionServiceImpl;
import com.example.orm.service.custom.impl.TherepistServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getServiceFactory(){
        return serviceFactory != null ? serviceFactory : new ServiceFactory();
    }

    public SuperService getService(serviceType type){
        switch (type) {
            case ADMIN:
                return new AdminServiceImpl();
            case RICIEPTION:
                return new RicieptionServiceImpl();
            case PROGRAMME:
                return new ProgrammeServiceImpl();
            case THEREPIST:
                return new TherepistServiceImpl();
            case SESSIONS:
                return new SessionServiceImpl();
            default:
                return null;
        }
    }

    public enum serviceType{
        ADMIN,RICIEPTION,PROGRAMME,THEREPIST,SESSIONS
    }
}
