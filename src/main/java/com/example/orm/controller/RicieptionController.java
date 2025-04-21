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

    private void clearFields(){
        nameTxt.setText("");
        emailTxt.setText("");
        paddwordTxt.setText("");
    }
    
    @FXML
    void deleteAdmin(ActionEvent event) {

    }

    @FXML
    void saveAdmin(ActionEvent event) throws Exception {

        String emailReg = "/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$/";
        String conReg = "^[0-9]{10}$";

        if (!emailTxt.getText().matches(emailReg)) {
            new Alert(AlertType.ERROR, "Invalid Email Address").show();
            return;
        }

        if (!contactTxt.getText().matches(conReg)) {
            new Alert(AlertType.ERROR, "Invalid Contact Number").show();
            return;
        }

        boolean resp = ricieptionServce.saveRicieption(new RicieptionDto(
        nameTxt.getText(), emailTxt.getText(), paddwordTxt.getText(),
        Integer.parseInt(contactTxt.getText())));

        if (resp) {
        new Alert(AlertType.INFORMATION, "New Ricieptoin Added Success!").show();
        clearFields();
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
