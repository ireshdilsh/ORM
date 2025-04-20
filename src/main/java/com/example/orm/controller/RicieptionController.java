package com.example.orm.controller;

import com.example.orm.dto.RicieptionDto;
import com.example.orm.service.ServiceFactory;
import com.example.orm.service.ServiceFactory.serviceType;
import com.example.orm.service.custom.RicieptionServce;
import com.example.orm.utils.WindowUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RicieptionController {

    RicieptionServce ricieptionServce = (RicieptionServce) ServiceFactory.getServiceFactory()
            .getService(serviceType.RICIEPTION);

    @FXML
    private TextField contactTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField paddwordTxt;

    @FXML
    private AnchorPane pane;
    
    @FXML
    void deleteAdmin(ActionEvent event) {

    }

    @FXML
    void saveAdmin(ActionEvent event) throws Exception {
        boolean resp = ricieptionServce.saveRicieption(new RicieptionDto(
        nameTxt.getText(), emailTxt.getText(), paddwordTxt.getText(),
        Integer.parseInt(contactTxt.getText())));

        if (resp) {
        new Alert(AlertType.INFORMATION, "New Ricieptoin Added Success!").show();
        } else {
        new Alert(AlertType.ERROR, "Something Went Wrong!").show();
        }
    }

    @FXML
    void updateAdmin(ActionEvent event) {

    }

    @FXML
    void gotoLog(MouseEvent event) throws Exception{
        new WindowUtils().navigateTo("RicieptionAuthView", pane);
    }

    @FXML
    void gotoBack(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("RoleView", pane);
    }
}
