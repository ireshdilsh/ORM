package com.example.orm.controller;

import com.example.orm.dto.AdminDto;
import com.example.orm.service.ServiceFactory;
import com.example.orm.service.ServiceFactory.serviceType;
import com.example.orm.service.custom.AdminService;
import com.example.orm.utils.WindowUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminController {

    AdminService adminService = (AdminService) ServiceFactory.getServiceFactory().getService(serviceType.ADMIN);

    @FXML
    private TextField contactTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField paddwordTxt;

    @FXML
    void deleteAdmin(ActionEvent event) {
        
    }

    @FXML
    void gotoBack(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("RoleView", pane);
    }

    @FXML
    void saveAdmin(ActionEvent event) throws Exception {
        boolean resp = adminService.saveAdmin(new AdminDto(
                nameTxt.getText(), emailTxt.getText(), paddwordTxt.getText(), Integer.parseInt(contactTxt.getText())));

        if (resp) {
            new Alert(AlertType.INFORMATION, "New Admin Added Success!").show();
        } else {
            new Alert(AlertType.ERROR, "Something Went Wrong!").show();
        }
    }

    @FXML
    void gotoLog(MouseEvent event) throws Exception{
        new WindowUtils().navigateTo("AdminAuthView", pane);
    }

    @FXML
    void updateAdmin(ActionEvent event) {

    }

}
