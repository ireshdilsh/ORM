package com.example.orm.controller;

import com.example.orm.utils.WindowUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RicieptionAuthController {

    @FXML
    private TextField emailTxt;

    @FXML
    private PasswordField passwotdTxt;

    @FXML
    private AnchorPane riviewAuthPane;

    @FXML
    void authRicieption(ActionEvent event) throws Exception {

        // if (emailTxt.getText().isEmpty() || passwotdTxt.getText().isEmpty()) {
        //     new Alert(Alert.AlertType.ERROR,"Cannot be null user input fields").show();
        // }else {
        //     new WindowUtils().navigateTo("",riviewAuthPane);
        // }
        new WindowUtils().navigateTo("RicieptionChoiceView", riviewAuthPane);
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
