package com.example.orm.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.orm.dto.TherepistDto;
import com.example.orm.service.ServiceFactory;
import com.example.orm.service.ServiceFactory.serviceType;
import com.example.orm.service.custom.TherepisService;
import com.example.orm.tm.TherepistTM;
import com.example.orm.utils.WindowUtils;
import com.jfoenix.controls.JFXButton;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class TherepsiController implements Initializable{

    TherepisService therepisService = (TherepisService) ServiceFactory.getServiceFactory().getService(serviceType.THEREPIST); 

    @FXML
    private TableColumn<TherepistTM, Integer> contactCol;

    @FXML
    private TextField contactTxt;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<TherepistTM, String> emailCol;

    @FXML
    private TextField emailTxt;

    @FXML
    private TableColumn<TherepistTM, Integer> idCol;

    @FXML
    private Label idLbl;

    @FXML
    private TableColumn<TherepistTM, String> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private TableView<TherepistTM> threTbl;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private AnchorPane pane;

    @FXML
    void gotoBack(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("AdminChoicesView", pane);
    }

    @FXML
    void deleteTherepist(ActionEvent event) throws Exception {
        boolean resp = therepisService.deleteTherepist(Integer.parseInt(idLbl.getText()));
        if (resp) {
            new Alert(AlertType.INFORMATION,"Therepy Delete Success !").show();
            getAllTherepists();
        }else{
            new Alert(AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void saveTherepist(ActionEvent event) throws Exception { 

        String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String conReg = "^[0-9]{10}$";

        if (nameTxt.getText().isEmpty() || emailTxt.getText().isEmpty() || contactTxt.getText().isEmpty()) {
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

        boolean resp = therepisService.saveTherepist(new TherepistDto(nameTxt.getText(), emailTxt.getText(),Integer.parseInt(contactTxt.getText())));
        if (resp) {
            new Alert(AlertType.INFORMATION,"Therepy Added Success !").show();
            getAllTherepists();
        }else{
            new Alert(AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void searchTherepist(MouseEvent event) {
        TherepistTM therepistTM = threTbl.getSelectionModel().getSelectedItem();

        if (therepistTM != null) {
            idLbl.setText(String.valueOf(therepistTM.getId()));
            nameTxt.setText(therepistTM.getName());
            emailTxt.setText(therepistTM.getEmail());
            contactTxt.setText(String.valueOf(therepistTM.getPhone()));
        } else {
            new Alert(AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void updateTherepist(ActionEvent event) {

        String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String conReg = "^[0-9]{10}$";

        if (!emailTxt.getText().matches(emailReg)) {
            new Alert(AlertType.ERROR, "Invalid Email Address").show();
            return;
        }

        if (!contactTxt.getText().matches(conReg)) {
            new Alert(AlertType.ERROR, "Invalid Contact Number").show();
            return;
        }

        boolean resp = therepisService.updateTherepist(new TherepistDto(Integer.parseInt(idLbl.getText()),nameTxt.getText(), emailTxt.getText(),Integer.parseInt(contactTxt.getText())));
        if (resp) {
            new Alert(AlertType.INFORMATION,"Therepy Update Success !").show();
            getAllTherepists();
        }else{
            new Alert(AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            contactCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

            idLbl.setText("");

            getAllTherepists();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllTherepists(){
        ArrayList<TherepistDto> therepistDtos = therepisService.getAllTherepists();
        ObservableList<TherepistTM>therepistTMs = FXCollections.observableArrayList();

        for (TherepistDto dto : therepistDtos) {
            TherepistTM therepistTM = new TherepistTM(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getPhone()
            );
            therepistTMs.add(therepistTM);
        }
        threTbl.setItems(therepistTMs);
    }
    
}
