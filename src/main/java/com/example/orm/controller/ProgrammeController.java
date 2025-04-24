package com.example.orm.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.orm.dto.ProgrammeDto;
import com.example.orm.service.ServiceFactory;
import com.example.orm.service.ServiceFactory.serviceType;
import com.example.orm.service.custom.ProgrammeService;
import com.example.orm.tm.ProgrammeTM;
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
import javafx.scene.layout.AnchorPane;

public class ProgrammeController implements Initializable{
    
    ProgrammeService programmeService = (ProgrammeService) ServiceFactory.getServiceFactory().getService(serviceType.PROGRAMME);

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<ProgrammeTM, String> durationCol;

    @FXML
    private TextField durationTxt;

    @FXML
    private TableColumn<ProgrammeTM, Double> feesCol;

    @FXML
    private TextField feesTxt;

    @FXML
    private TableColumn<ProgrammeTM, Integer> idCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableView<ProgrammeTM> programmeTbl;

    @FXML
    private TableColumn<ProgrammeTM, String> programmenameCol;

    @FXML
    private JFXButton savebtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label idLbl;

    @FXML
    void deleteProgramme(ActionEvent event) throws Exception {
        boolean resp = programmeService.deleteProgramme(Integer.parseInt(idLbl.getText()));
        if (resp) {
            new Alert(AlertType.INFORMATION,"Programme Deleted !").show();
            clearFields();
            getAllProgrammes();
        } else {
            new Alert(AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void saveProgramme(ActionEvent event) throws Exception {

        if (nameTxt.getText().isEmpty() || durationTxt.getText().isEmpty() || feesTxt.getText().isEmpty()) {
            new Alert(AlertType.ERROR,"Something Went Wrong !").show();
        }

        boolean resp = programmeService.saveProgramme(new ProgrammeDto(
            nameTxt.getText(), durationTxt.getText(), Double.parseDouble(feesTxt.getText())
        ));        
        if (resp) {
            new Alert(AlertType.INFORMATION, "New Programme Added Success!").show();
            clearFields();
            getAllProgrammes();
        }else{
            new Alert(AlertType.ERROR, "Something Went Wrong!").show();
        }
    }

    @FXML
    void updateProgramme(ActionEvent event) {
        boolean resp = programmeService.updateProgramme(new ProgrammeDto(
           Integer.parseInt(idLbl.getText()),nameTxt.getText(),durationTxt.getText(),Double.parseDouble(feesTxt.getText())
        ));

        if (resp) {
            new Alert(AlertType.INFORMATION,"Programme Updated !").show();
            clearFields();
            getAllProgrammes();
        } else {
            new Alert(AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {   
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        programmenameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        feesCol.setCellValueFactory(new PropertyValueFactory<>("fees"));

            idLbl.setText("");

            getAllProgrammes();
            serachProgramme();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllProgrammes(){ 
        ArrayList<ProgrammeDto> programmeDtos = programmeService.getAllProgrammes();
        ObservableList<ProgrammeTM> programmeTMS = FXCollections.observableArrayList();
        for (ProgrammeDto programmeDto : programmeDtos) {
            ProgrammeTM programmeTM = new ProgrammeTM(
                    programmeDto.getId(),
                    programmeDto.getName(),
                    programmeDto.getDuration(),
                    programmeDto.getFees());
            programmeTMS.add(programmeTM);
        }
        programmeTbl.setItems(programmeTMS);
    }

    public void serachProgramme(){
        programmeTbl.setOnMouseClicked((e)->{
            ProgrammeTM programmeTM = programmeTbl.getSelectionModel().getSelectedItem();
            if (programmeTM != null) {
                idLbl.setText(String.valueOf(programmeTM.getId()));
                nameTxt.setText(programmeTM.getName());
                durationTxt.setText(programmeTM.getDuration());
                feesTxt.setText(String.valueOf(programmeTM.getFees()));
            } else {
                new Alert(AlertType.ERROR,"Somrthing went Wrong !").show();
            }
        });
    }

    @FXML
    void gotoBack(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("AdminChoicesView", pane);
    }

    public void clearFields(){
        idLbl.setText("");
        nameTxt.setText("");
        durationTxt.setText("");
        feesTxt.setText("");
    }
}
