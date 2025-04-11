package com.example.orm.controller;

import com.example.orm.service.ServiceFactory;
import com.example.orm.service.ServiceFactory.serviceType;
import com.example.orm.service.custom.AdminService;

public class AdminController {

    AdminService adminService = (AdminService) ServiceFactory.getServiceFactory().getService(serviceType.ADMIN);

    

}
