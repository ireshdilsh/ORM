package com.example.orm.service.custom;

import com.example.orm.dto.PatcentDto;
import com.example.orm.service.SuperService;

import java.util.ArrayList;

public interface PatcientService extends SuperService {
    ArrayList<PatcentDto> getAllPatcients();

    boolean deletePatcient(int i) throws Exception;

    boolean updatePatcient(PatcentDto patcentDto);

    int savePatcien(PatcentDto patcentDto) throws Exception;
}
