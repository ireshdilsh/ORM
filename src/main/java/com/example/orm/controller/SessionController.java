package com.example.orm.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.orm.dto.TherepistDto;
import com.example.orm.service.ServiceFactory;
import com.example.orm.service.ServiceFactory.serviceType;
import com.example.orm.service.custom.SessionService;
import com.example.orm.service.custom.TherepisService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class SessionController implements Initializable{

    SessionService sessionService = (SessionService) ServiceFactory.getServiceFactory().getService(serviceType.SESSIONS);
    TherepisService therepisService = (TherepisService) ServiceFactory.getServiceFactory().getService(serviceType.THEREPIST);

    @FXML
    private ComboBox<String> therepistCmb;

    @FXML
    void selectTherepist(ActionEvent event) {
        String name = therepistCmb.getSelectionModel().getSelectedItem();
        if (name != null) {
            //System.out.println(therepistTM.getId());
        }
    }

    public void getAllTherepistNames(){
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllTherepistNames();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
