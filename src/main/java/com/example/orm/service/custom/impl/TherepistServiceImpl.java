package com.example.orm.service.custom.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.orm.dao.DaoFactory;
import com.example.orm.dao.DaoFactory.daoType;
import com.example.orm.dao.custom.TherepistDao;
import com.example.orm.dto.TherepistDto;
import com.example.orm.entity.Therepists;
import com.example.orm.service.custom.TherepisService;

public class TherepistServiceImpl implements TherepisService{

    TherepistDao therepistDao = (TherepistDao) DaoFactory.getDaoFactory().getDao(daoType.THEREPIST);

    @Override
    public ArrayList<TherepistDto> getAllTherepists() {
        ArrayList<TherepistDto>therepistDtos = new ArrayList<>();
        List<Therepists>therepists = therepistDao.getAll();

        for (Therepists therepist : therepists) {
            TherepistDto dto = new TherepistDto(
                therepist.getId(),
                therepist.getName(),
                therepist.getEmail(),
                therepist.getPhone()
            );
            therepistDtos.add(dto);
        }
        return therepistDtos;
    }

    @Override
    public boolean saveTherepist(TherepistDto therepistDto) throws Exception {
        return therepistDao.save(new Therepists(
            therepistDto.getId(),
            therepistDto.getName(),
            therepistDto.getEmail(),
            therepistDto.getPhone()
        ));
    }

    @Override
    public boolean updateTherepist(TherepistDto therepistDto) {
        Therepists therepists = therepistDao.findByPK(therepistDto.getId());

        if (therepists != null) {
            return therepistDao.update(new Therepists(
                therepistDto.getId(),
                therepistDto.getName(),
                therepistDto.getEmail(),
                therepistDto.getPhone()
            ));
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteTherepist(int int1) throws Exception {
        return therepistDao.deleteByPK(int1);
    }

    @Override
    public TherepistDto findByID(int i) {
        Therepists therepists = therepistDao.findByPK(i);
        if (therepists != null) {
            return new TherepistDto(
                therepists.getId(), therepists.getName(), therepists.getEmail(), therepists.getPhone()
            );
        };
        return null;
    }

}
