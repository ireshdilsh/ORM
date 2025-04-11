package com.example.orm.controller;

import com.example.orm.dto.AdminDto;
import com.example.orm.service.ServiceFactory;
import com.example.orm.service.ServiceFactory.serviceType;
import com.example.orm.service.custom.AdminService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AdminController {

    AdminService adminService = (AdminService) ServiceFactory.getServiceFactory().getService(serviceType.ADMIN);

      @FXML
    private TextField contactTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField paddwordTxt;

    @FXML
    void deleteAdmin(ActionEvent event) {

    }

    @FXML
    void saveAdmin(ActionEvent event) {
        boolean resp = adminService.saveAdmin(new AdminDto(
            nameTxt.getText(),emailTxt.getText(),paddwordTxt.getText(),Integer.parseInt(contactTxt.getText())
        ));

        if (resp) {
            new Alert(AlertType.INFORMATION,"New Admin Added Success!").show();
        } else {
            new Alert(AlertType.ERROR,"Something Went Wrong!").show();
        }
    }

    @FXML
    void updateAdmin(ActionEvent event) {

    }

}
