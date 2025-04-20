package com.example.orm.controller;

import com.example.orm.service.ServiceFactory;
import com.example.orm.service.custom.AdminService;
import com.example.orm.utils.WindowUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminAuthController {

    AdminService adminService = (AdminService) ServiceFactory.getServiceFactory().getService(ServiceFactory.serviceType.ADMIN);

    @FXML
    private AnchorPane adminLoginAuthPane;

    @FXML
    private TextField emailTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    void backLanding(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("RoleView", adminLoginAuthPane);
    }

    @FXML
    void gotoRegister(MouseEvent event) throws Exception{
        new WindowUtils().navigateTo("AdminView", adminLoginAuthPane);
    }

    @FXML
    void gotoChoicesView(ActionEvent event) throws Exception{
        String email = emailTxt.getText();
        String password = passwordTxt.getText();

        boolean resp = adminService.authAdmin(email, password);

        if (resp) {
            new WindowUtils().navigateTo("AdminChoicesView", adminLoginAuthPane);
        }else{
            new Alert(AlertType.ERROR, "Something Went Wrong!").show();
        }
    }
}
