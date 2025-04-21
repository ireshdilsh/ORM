package com.example.orm.service.custom.impl;

import com.example.orm.dao.DaoFactory;
import com.example.orm.dao.DaoFactory.daoType;
import com.example.orm.dao.custom.RicieptionDao;
import com.example.orm.dto.RicieptionDto;
import com.example.orm.entity.Ricieption;
import com.example.orm.service.custom.RicieptionServce;

public class RicieptionServiceImpl implements RicieptionServce {

    RicieptionDao ricieptionDao = (RicieptionDao) DaoFactory.getDaoFactory().getDao(daoType.RICIEPTION);

    @Override
    public boolean saveRicieption(RicieptionDto ricieptionDto) throws Exception {
        return ricieptionDao.save(new Ricieption(ricieptionDto.getName(), ricieptionDto.getEmail(),
                ricieptionDto.getPassword(), ricieptionDto.getContact()));
    }

    @Override
    public boolean authLogin(String email, String password) {
        return ricieptionDao.authLogin(email,password);
    }

}
