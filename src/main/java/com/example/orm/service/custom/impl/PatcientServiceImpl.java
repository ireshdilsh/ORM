package com.example.orm.service.custom.impl;

import com.example.orm.dao.DaoFactory;
import com.example.orm.dao.custom.PatcientDao;
import com.example.orm.dao.custom.ProgrammeDao;
import com.example.orm.dao.custom.SessionDao;
import com.example.orm.dto.PatcentDto;
import com.example.orm.entity.Patcients;
import com.example.orm.entity.Programme;
import com.example.orm.entity.Sessions;
import com.example.orm.service.custom.PatcientService;

import java.util.ArrayList;
import java.util.List;

public class PatcientServiceImpl implements PatcientService {

    PatcientDao patcientDao = (PatcientDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.PATCIENT);
    ProgrammeDao programmeDao = (ProgrammeDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.PROGRAMME);
    SessionDao sessionDao = (SessionDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.SESSIONS);
    @Override
    public ArrayList<PatcentDto> getAllPatcients() {
        ArrayList<PatcentDto>patcentDtos = new ArrayList<>();
        List<Patcients>patcients = patcientDao.getAll();
        
        for (Patcients patcient : patcients ) {
            Programme programme = patcient.getProgrammeID();
            Sessions sessions = patcient.getSessionID();

            if (programme != null && sessions != null) {
                PatcentDto patcentDto = new PatcentDto(
                        patcient.getId(),
                        patcient.getName(),
                        patcient.getEmail(),
                        patcient.getPhone(),
                        patcient.getProgrammeID().getId(),
                        patcient.getSessionID().getId()
                );
                patcentDtos.add(patcentDto);
            }
        }
        return patcentDtos;
    }
    @Override
    public boolean savePatcient(PatcentDto patcentDto) throws Exception{
        Programme programme = programmeDao.findByPK(patcentDto.getProgrammeId());
        Sessions sessions = sessionDao.findByPK(patcentDto.getSessionId());

        return patcientDao.save(new Patcients(
                patcentDto.getId(),
                patcentDto.getName(),
                patcentDto.getEmail(),
                patcentDto.getPhone(),
                programme,
                sessions
        ));
    }

    @Override
    public boolean deletePatcient(int i) throws Exception {
        return patcientDao.deleteByPK(i);
    }

    @Override
    public boolean updatePatcient(PatcentDto patcentDto) {
        Patcients patcients = patcientDao.findByPK(patcentDto.getId());
        Programme programme = programmeDao.findByPK(patcentDto.getProgrammeId());
        Sessions sessions = sessionDao.findByPK(patcentDto.getSessionId());

        if (patcients != null) {
            return patcientDao.update(new Patcients(
                    patcentDto.getId(),
                    patcentDto.getName(),
                    patcentDto.getEmail(),
                    patcentDto.getPhone(),
                    programme,
                    sessions
            ));
        }else {
            return false;
        }
    }
}
