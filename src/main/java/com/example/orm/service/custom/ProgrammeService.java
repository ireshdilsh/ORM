package com.example.orm.service.custom;

import java.util.ArrayList;

import com.example.orm.dto.ProgrammeDto;
import com.example.orm.service.SuperService;

public interface ProgrammeService extends SuperService{

    ArrayList<ProgrammeDto> getAllProgrammes();

    boolean saveProgramme(ProgrammeDto programmeDto) throws Exception;

    boolean updateProgramme(ProgrammeDto programmeDto);

    boolean deleteProgramme(int id) throws Exception;

}
