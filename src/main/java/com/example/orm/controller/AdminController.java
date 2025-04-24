package com.example.orm.controller;

import com.example.orm.dto.AdminDto;
import com.example.orm.exception.RegisterException;
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

        String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String conReg = "^[0-9]{10}$";

        if (emailTxt.getText().isEmpty() || contactTxt.getText().isEmpty() || nameTxt.getText().isEmpty()) {
            new Alert(AlertType.ERROR,"Something Went Wrong").show();
        }

        if (!emailTxt.getText().matches(emailReg)) {
            new Alert(AlertType.ERROR, "Invalid Email Address").show();
            return;
        }

        if (!contactTxt.getText().matches(conReg)) {
            new Alert(AlertType.ERROR, "Invalid Contact Number").show();
            return;
        }

        try {
            boolean resp = adminService.saveAdmin(new AdminDto(
                nameTxt.getText(), emailTxt.getText(), paddwordTxt.getText(), Integer.parseInt(contactTxt.getText())));

        if (resp) {
            new Alert(AlertType.INFORMATION, "New Admin Added Success!").show();
            clearFields();
        } else {
            new Alert(AlertType.ERROR, "Something Went Wrong!").show();
        }
        } catch (RegisterException e) {
            e.printStackTrace();
        }
    }

    private void clearFields(){
        nameTxt.setText("");
        emailTxt.setText("");
        paddwordTxt.setText("");
        contactTxt.setText("");
    }

    @FXML
    void gotoLog(MouseEvent event) throws Exception{
        new WindowUtils().navigateTo("AdminAuthView", pane);
    }

    @FXML
    void updateAdmin(ActionEvent event) {

    }

}
