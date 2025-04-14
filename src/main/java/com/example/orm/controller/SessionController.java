package com.example.orm.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.example.orm.dto.SessionDto;
import com.example.orm.dto.TherepistDto;
import com.example.orm.service.ServiceFactory;
import com.example.orm.service.ServiceFactory.serviceType;
import com.example.orm.service.custom.SessionService;
import com.example.orm.service.custom.TherepisService;

import com.example.orm.tm.SessionTM;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SessionController implements Initializable{

    SessionService sessionService = (SessionService) ServiceFactory.getServiceFactory().getService(serviceType.SESSIONS);
    TherepisService therepisService = (TherepisService) ServiceFactory.getServiceFactory().getService(serviceType.THEREPIST);

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TextField endTxt;

    @FXML
    private TableColumn<SessionTM, Integer> endtimeCol;

    @FXML
    private TableColumn<SessionTM, Integer> idCol;

    @FXML
    private Label idLbl;

    @FXML
    private TableColumn<SessionTM, String> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private TableView<SessionTM> sessionTbl;

    @FXML
    private TableColumn<SessionTM, Integer> startTimeCol;

    @FXML
    private TextField startTxt;

    @FXML
    private TableColumn<SessionTM, Integer> therepyIdCol;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private Label sesionIdLbl;

    @FXML
    void deleteSession(ActionEvent event) throws Exception {
        boolean resp = sessionService.deleteSession(Integer.parseInt(sesionIdLbl.getText()));
        if (resp) {
            new Alert(Alert.AlertType.INFORMATION, "Deleted Session").show();
            getAllSessions();
            clearFields();
            getAllTherepistNames();
        }else {
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
        }
    }

    @FXML
    void saveSession(ActionEvent event) throws Exception{
        boolean resp = sessionService.saveSession(new SessionDto(
                nameTxt.getText(),
                Integer.parseInt(startTxt.getText()),
                Integer.parseInt(endTxt.getText()),
                Integer.parseInt(idLbl.getText())
        ));

        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Saved").show();
            getAllSessions();
            clearFields();
            getAllTherepistNames();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void searchSession(MouseEvent event) {
        SessionTM sessionTM = sessionTbl.getSelectionModel().getSelectedItem();
        if (sessionTM != null) {
            idLbl.setText(String.valueOf(sessionTM.getTherepistId()));
            nameTxt.setText(sessionTM.getName());
            startTxt.setText(String.valueOf(sessionTM.getStart()));
            endTxt.setText(String.valueOf(sessionTM.getEnd()));
            sesionIdLbl.setText(String.valueOf(sessionTM.getId()));
        }
    }

    @FXML
    void updateSession(ActionEvent event) {
        boolean resp = sessionService.updateService(new SessionDto(
                Integer.parseInt(sesionIdLbl.getText()),
                nameTxt.getText(),
                Integer.parseInt(startTxt.getText()),
                Integer.parseInt(endTxt.getText()),
                Integer.parseInt(idLbl.getText())
        ));

        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Updated").show();
            getAllSessions();
            clearFields();
            getAllTherepistNames();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong").show();
        }
    }


    @FXML
    private ComboBox<String> therepistCmb;
    private Map<String, TherepistDto> therepistMap = new HashMap<>();

    public void getAllTherepistNames(){
        ArrayList<TherepistDto>therepistDtos = therepisService.getAllTherepists();
        for (TherepistDto dto : therepistDtos ) {
            therepistMap.put(dto.getName(), dto);  // Save mapping
            therepistCmb.getItems().add(dto.getName());
        }
    }

    @FXML
    void selectTherepist(ActionEvent event) {
        String selectedName = therepistCmb.getSelectionModel().getSelectedItem();
        TherepistDto selectedDto = therepistMap.get(selectedName);

        if (selectedDto != null) {
            idLbl.setText(String.valueOf(selectedDto.getId()));
        } else {
            System.out.println("Therapist not found.");
        }
    }

    public void getAllSessions(){
        ArrayList<SessionDto>sessionDtos = sessionService.getAllSessions();
        ObservableList<SessionTM> sessionTMObservableList = FXCollections.observableArrayList();

        for (SessionDto dto : sessionDtos) {
            SessionTM sessionTM = new SessionTM(
                    dto.getId(),
                    dto.getName(),
                    dto.getStart(),
                    dto.getEnd(),
                    dto.getTherepistId()
            );
            sessionTMObservableList.add(sessionTM);
        }
        sessionTbl.setItems(sessionTMObservableList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            startTimeCol.setCellValueFactory(new PropertyValueFactory<>("start"));
            endtimeCol.setCellValueFactory(new PropertyValueFactory<>("end"));
            therepyIdCol.setCellValueFactory(new PropertyValueFactory<>("therepistId"));

            clearFields();
            getAllTherepistNames();
            getAllSessions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearFields(){
        idLbl.setText("");
        nameTxt.setText("");
        startTxt.setText("");
        endTxt.setText("");
        sesionIdLbl.setText("");
        therepistCmb.getItems().clear();
    }

}
