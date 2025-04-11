package com.example.orm.service;

import com.example.orm.service.custom.impl.AdminServiceImpl;

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
        
            default:
                return null;
        }
    }

    public enum serviceType{
        ADMIN
    }
}
