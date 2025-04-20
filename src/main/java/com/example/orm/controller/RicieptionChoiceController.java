package com.example.orm.controller;

import com.example.orm.utils.WindowUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class RicieptionChoiceController {
    
    @FXML
    private AnchorPane pane;

    @FXML
    void gotoBack(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("Landing", pane);
    }

    @FXML
    void gotoPayment(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("PaymentView", pane);
    }

    @FXML
    void gotoSession(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("SessionView", pane);
    }

    @FXML
    void gotopatcient(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("PatcientView", pane);
    }

}
