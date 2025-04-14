package com.example.orm.service.custom;

import com.example.orm.dto.SessionDto;
import com.example.orm.service.SuperService;

import java.util.ArrayList;

public interface SessionService extends SuperService{

    ArrayList<SessionDto> getAllSessions();

    boolean saveSession(SessionDto sessionDto) throws Exception;

    boolean deleteSession(int i) throws Exception;

    boolean updateService(SessionDto sessionDto);
}
