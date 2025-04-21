package com.example.orm.service.custom;

import com.example.orm.dto.RicieptionDto;
import com.example.orm.service.SuperService;

public interface RicieptionServce extends SuperService{

    boolean saveRicieption(RicieptionDto ricieptionDto) throws Exception;

    boolean authLogin(String email, String password);

}
