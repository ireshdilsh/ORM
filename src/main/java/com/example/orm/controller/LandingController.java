package com.example.orm.controller;

import com.example.orm.utils.WindowUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class LandingController {

    @FXML
    private AnchorPane LandingPane;
    @FXML
    void gotoSigInView(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("/view/LandingView", LandingPane);
    }
    @FXML
    void gotoSignUpView(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("/view/SignUpView", LandingPane);
    }

}
