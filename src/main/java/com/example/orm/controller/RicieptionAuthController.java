package com.example.orm.controller;

import com.example.orm.exception.LoginException;
import com.example.orm.service.ServiceFactory;
import com.example.orm.service.ServiceFactory.serviceType;
import com.example.orm.service.custom.RicieptionServce;
import com.example.orm.utils.WindowUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RicieptionAuthController {

    RicieptionServce ricieptionServce = (RicieptionServce) ServiceFactory.getServiceFactory().getService(serviceType.RICIEPTION);

    @FXML
    private TextField emailTxt;

    @FXML
    private PasswordField passwotdTxt;

    @FXML
    private AnchorPane riviewAuthPane;

    @FXML
    void authRicieption(ActionEvent event) throws Exception {

        try {
            String email = emailTxt.getText();
        String password = passwotdTxt.getText();

        boolean resp = ricieptionServce.authLogin(email,password);
        if (resp) {
            new WindowUtils().navigateTo("RicieptionChoiceView", riviewAuthPane);
        }else{
            new Alert(AlertType.ERROR,"Something Went Wrong!").show();
        }
        } catch (LoginException e) {
           e.printStackTrace();
        }
    }

    @FXML
    void backLanding(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("RoleView",riviewAuthPane);
    }

    @FXML
    void gotoRegister(MouseEvent event) throws Exception{
        new WindowUtils().navigateTo("RicieptionView", riviewAuthPane);
    }
}
