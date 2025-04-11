package com.example.orm.service.custom.impl;

import com.example.orm.dao.DaoFactory;
import com.example.orm.dao.DaoFactory.daoType;
import com.example.orm.dao.custom.AdminDao;
import com.example.orm.dto.AdminDto;
import com.example.orm.entity.Admin;
import com.example.orm.service.custom.AdminService;

public class AdminServiceImpl implements AdminService{

    AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao(daoType.ADMIN);

    @Override
    public boolean saveAdmin(AdminDto adminDto) throws Exception{
        return adminDao.save(new Admin(
            adminDto.getName(),
            adminDto.getEmail(),
            adminDto.getPassword(),
            adminDto.getContact()
        ));
    }

}
