package com.example.orm.service.custom;

import java.util.ArrayList;

import com.example.orm.dto.TherepistDto;
import com.example.orm.service.SuperService;

public interface TherepisService extends SuperService{

    ArrayList<TherepistDto> getAllTherepists();

    boolean saveTherepist(TherepistDto therepistDto) throws Exception;

    boolean updateTherepist(TherepistDto therepistDto);

    boolean deleteTherepist(int int1) throws Exception;

}
