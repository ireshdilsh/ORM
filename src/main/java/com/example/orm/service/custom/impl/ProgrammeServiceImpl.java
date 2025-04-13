package com.example.orm.service.custom.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.orm.dao.DaoFactory;
import com.example.orm.dao.DaoFactory.daoType;
import com.example.orm.dao.custom.ProgrammeDao;
import com.example.orm.dto.ProgrammeDto;
import com.example.orm.entity.Programme;
import com.example.orm.service.custom.ProgrammeService;

public class ProgrammeServiceImpl implements ProgrammeService {

    ProgrammeDao programmeDao = (ProgrammeDao) DaoFactory.getDaoFactory().getDao(daoType.PROGRAMME);

    @Override
    public ArrayList<ProgrammeDto> getAllProgrammes() {
        ArrayList<ProgrammeDto> programmeDtos = new ArrayList<>();
        List<Programme>programmes = programmeDao.getAll();

        for (Programme programme : programmes) {
            ProgrammeDto programmeDto = new ProgrammeDto(programme.getId(),programme.getName(),programme.getDuration(),programme.getFees());
            programmeDtos.add(programmeDto);
        }
        return programmeDtos;

    }

    @Override
    public boolean saveProgramme(ProgrammeDto programmeDto) throws Exception {
        return programmeDao.save(new Programme(
            programmeDto.getId(),
            programmeDto.getName(),
            programmeDto.getDuration(),
            programmeDto.getFees()
        ));
    }

    @Override
    public boolean updateProgramme(ProgrammeDto programmeDto) {

        Programme programme = programmeDao.findByPK(programmeDto.getId());
        if (programme != null) {
            return programmeDao.update(new Programme(
                programmeDto.getId(),
                programmeDto.getName(),
                programmeDto.getDuration(),
                programmeDto.getFees()
            ));   
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteProgramme(int id) throws Exception {
        return programmeDao.deleteByPK(id);
    }
    
}
