package com.example.orm.controller;

import com.example.orm.dto.ProgrammeDto;
import com.example.orm.dto.SessionDto;
import com.example.orm.dto.TherepistDto;
import com.example.orm.service.ServiceFactory;
import com.example.orm.service.custom.ProgrammeService;
import com.example.orm.service.custom.SessionService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PattcientController implements Initializable {


    @FXML
    private ComboBox<String> programmeCmb;

    @FXML
    private ComboBox<String> sesssonCmb;

    ProgrammeService programmeService = (ProgrammeService) ServiceFactory.getServiceFactory().getService(ServiceFactory.serviceType.PROGRAMME);
    SessionService sessionService = (SessionService) ServiceFactory.getServiceFactory().getService(ServiceFactory.serviceType.SESSIONS);

    private Map<String, ProgrammeDto> programmeDtoMap = new HashMap<>();
    private Map<String, SessionDto> sessionDtoMap = new HashMap<>();
    public void getAllSessions(){
        ArrayList<SessionDto> sessionDtos = sessionService.getAllSessions();
        for (SessionDto sessionDto : sessionDtos) {
            sessionDtoMap.put(sessionDto.getName(), sessionDto);
            sesssonCmb.getItems().add(sessionDto.getName());
        }
    }
    public void getAllProgrammes(){
        ArrayList<ProgrammeDto>programmeDtos = programmeService.getAllProgrammes();
        for (ProgrammeDto programmeDto : programmeDtos) {
            programmeDtoMap.put(programmeDto.getName(), programmeDto);
            programmeCmb.getItems().add(programmeDto.getName());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            getAllProgrammes();
            getAllSessions();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void selectProgramme(ActionEvent event) {

    }

    @FXML
    void selectSession(ActionEvent event) {

    }

}
