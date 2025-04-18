package com.example.orm.controller;

import com.example.orm.utils.WindowUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class RoleController {
    @FXML
    private AnchorPane selectRolePane;

    @FXML
    void backLandingPage(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("LandingView",selectRolePane);
    }

    @FXML
    void gotoAdminAuth(ActionEvent event) {
        
    }

    @FXML
    void gotoRicieptionAuth(ActionEvent event) {

    }

}
