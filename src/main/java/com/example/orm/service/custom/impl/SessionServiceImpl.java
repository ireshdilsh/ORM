package com.example.orm.service.custom.impl;

import com.example.orm.dao.DaoFactory;
import com.example.orm.dao.custom.SessionDao;
import com.example.orm.dao.custom.TherepistDao;
import com.example.orm.dto.SessionDto;
import com.example.orm.dto.TherepistDto;
import com.example.orm.entity.Sessions;
import com.example.orm.entity.Therepists;
import com.example.orm.service.custom.SessionService;

import java.util.ArrayList;
import java.util.List;

public class SessionServiceImpl implements SessionService{

    SessionDao sessionDao = (SessionDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.SESSIONS);
    TherepistDao therepistDao = (TherepistDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.THEREPIST);

    @Override public ArrayList<SessionDto> getAllSessions() {
        ArrayList<SessionDto>sessionDtos = new ArrayList<>();
        List<Sessions> sessions = sessionDao.getAll();

        for (Sessions session : sessions) {
            Therepists therepists = session.getTherepists();
            if (therepists != null) {
                SessionDto sessionDto = new SessionDto(
                        session.getId(),
                        session.getName(),
                        session.getStart(),
                        session.getEnd(),
                         session.getTherepists().getId()
                );
                sessionDtos.add(sessionDto);
            }
        }
        return sessionDtos;
    }

    @Override
    public boolean saveSession(SessionDto sessionDto) throws Exception{

        Therepists therepist = therepistDao.findByPK(sessionDto.getTherepistId());

        return sessionDao.save(new Sessions(
                sessionDto.getId(),
                sessionDto.getName(),
                sessionDto.getStart(),
                sessionDto.getEnd(),
                therepist
        ));
    }

    @Override
    public boolean deleteSession(int i) throws  Exception{
        return sessionDao.deleteByPK(i);
    }

    @Override
    public boolean updateService(SessionDto sessionDto) {
        Sessions sessions = sessionDao.findByPK(sessionDto.getId());
        Therepists therepistDto = therepistDao.findByPK(sessionDto.getTherepistId());
        if (sessions != null) {
            return sessionDao.update(new Sessions(
                sessionDto.getId(),
                    sessionDto.getName(),
                    sessionDto.getStart(),
                    sessionDto.getEnd(),
                    therepistDto
            ));
        }else {
            return false;
        }
    }

}
