package com.example.orm.controller;

import com.example.orm.dto.PatcentDto;
import com.example.orm.dto.PaymentDto;
import com.example.orm.dto.ProgrammeDto;
import com.example.orm.dto.SessionDto;
import com.example.orm.exception.PayException;
import com.example.orm.service.ServiceFactory;
import com.example.orm.service.custom.PatcientService;
import com.example.orm.service.custom.PaymentService;
import com.example.orm.service.custom.ProgrammeService;
import com.example.orm.service.custom.SessionService;
import com.example.orm.tm.PatcientTM;
import com.example.orm.utils.WindowUtils;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PattcientController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private ComboBox<String> programmeCmb;

    @FXML
    private ComboBox<String> sesssonCmb;

    @FXML
    private TableColumn<PatcientTM, Integer> contactCol;

    @FXML
    private TextField contactTxt;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<PatcientTM, String> emailCol;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField feesTxt;

    @FXML
    private TableColumn<PatcientTM, Integer> idCol;

    @FXML
    private Label idLbl;

    @FXML
    private TableColumn<PatcientTM, String> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableView<PatcientTM> patTbl;

    @FXML
    private Label proLbl;

    @FXML
    private TableColumn<PatcientTM, Integer> programmeCol;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private TableColumn<PatcientTM, Integer> sessionCol;

    @FXML
    private Label sessionLbl;

    @FXML
    private JFXButton updateBtn;

    ProgrammeService programmeService = (ProgrammeService) ServiceFactory.getServiceFactory()
            .getService(ServiceFactory.serviceType.PROGRAMME);
    SessionService sessionService = (SessionService) ServiceFactory.getServiceFactory()
            .getService(ServiceFactory.serviceType.SESSIONS);
    PatcientService patcientService = (PatcientService) ServiceFactory.getServiceFactory()
            .getService(ServiceFactory.serviceType.PATCIENT);
    PaymentService paymentService = (PaymentService) ServiceFactory.getServiceFactory()
            .getService(ServiceFactory.serviceType.PAYMENT);

    @FXML
    void deletePatcient(ActionEvent event) throws Exception {
        boolean resp = patcientService.deletePatcient(Integer.parseInt(idLbl.getText()));
        if (resp) {
            new Alert(Alert.AlertType.INFORMATION, "Patcient deleted").show();
            getAllPatcients();
            clearFields();
        } else {
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
        }
    }

    private void clearFields(){
        idLbl.setText("");
        nameTxt.setText("");
        emailTxt.setText("");
        contactTxt.setText("");
        sessionLbl.setText("");
        proLbl.setText("");
        programmeCmb.getSelectionModel().clearSelection();
        sesssonCmb.getSelectionModel().clearSelection();
    }

    @FXML
    void savePatcient(ActionEvent event) throws Exception {

        String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String conReg = "^[0-9]{10}$";

        if (emailTxt.getText().isEmpty() || contactTxt.getText().isEmpty() || nameTxt.getText().isEmpty()) {
            new Alert(AlertType.ERROR,"SomeThing Went Wrong").show();
            return;
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
            int newPatcientId = patcientService.savePatcien(new PatcentDto(
                    nameTxt.getText(),
                    emailTxt.getText(),
                    Integer.parseInt(contactTxt.getText()),
                    Integer.parseInt(proLbl.getText()),
                    Integer.parseInt(sessionLbl.getText())));

            try {
                boolean resp = paymentService.savePayment(new PaymentDto(
                        Double.parseDouble(feesTxt.getText()),
                        newPatcientId));

                if (resp) {
                    new Alert(Alert.AlertType.INFORMATION, "Patcient saved").show();
                    getAllPatcients();
                    clearFields();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
                }
            } catch (PayException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
        }
    }

    @FXML
    void searchPatcient(MouseEvent event) {
        PatcientTM patcientTM = patTbl.getSelectionModel().getSelectedItem();
        if (patcientTM != null) {
            idLbl.setText(String.valueOf(patcientTM.getId()));
            nameTxt.setText(patcientTM.getName());
            emailTxt.setText(patcientTM.getEmail());
            contactTxt.setText(String.valueOf(patcientTM.getPhone()));
            proLbl.setText(String.valueOf(patcientTM.getProgrammeId()));
            sessionLbl.setText(String.valueOf(patcientTM.getSessionId()));
        }
    }

    @FXML
    void updatePatcient(ActionEvent event) {

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

        boolean resp = patcientService.updatePatcient(new PatcentDto(
                Integer.parseInt(idLbl.getText()),
                nameTxt.getText(),
                emailTxt.getText(),
                Integer.parseInt(contactTxt.getText()),
                Integer.parseInt(proLbl.getText()),
                Integer.parseInt(sessionLbl.getText())));

        if (resp) {
            new Alert(Alert.AlertType.INFORMATION, "Patcient Updated").show();
            getAllPatcients();
            clearFields();
        } else {
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
        }
    }

    private Map<String, ProgrammeDto> programmeDtoMap = new HashMap<>();
    private Map<String, SessionDto> sessionDtoMap = new HashMap<>();

    public void getAllSessions() {
        ArrayList<SessionDto> sessionDtos = sessionService.getAllSessions();
        for (SessionDto sessionDto : sessionDtos) {
            sessionDtoMap.put(sessionDto.getName(), sessionDto);
            sesssonCmb.getItems().add(sessionDto.getName());
        }
    }

    public void getAllProgrammes() {
        ArrayList<ProgrammeDto> programmeDtos = programmeService.getAllProgrammes();
        for (ProgrammeDto programmeDto : programmeDtos) {
            programmeDtoMap.put(programmeDto.getName(), programmeDto);
            programmeCmb.getItems().add(programmeDto.getName());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            contactCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            programmeCol.setCellValueFactory(new PropertyValueFactory<>("programmeId"));
            sessionCol.setCellValueFactory(new PropertyValueFactory<>("sessionId"));

            sessionLbl.setText("");
            proLbl.setText("");
            idLbl.setText("");

            getAllProgrammes();
            getAllSessions();
            getAllPatcients();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAllPatcients() {
        ArrayList<PatcentDto> patcentDtos = patcientService.getAllPatcients();
        ObservableList<PatcientTM> patcientTMS = FXCollections.observableArrayList();

        for (PatcentDto dto : patcentDtos) {
            PatcientTM patcientTM = new PatcientTM(
                    dto.getId(),
                    dto.getName(),
                    dto.getEmail(),
                    dto.getPhone(),
                    dto.getProgrammeId(),
                    dto.getSessionId());
            patcientTMS.add(patcientTM);
        }
        patTbl.setItems(patcientTMS);
    }

    @FXML
    void selectProgramme(ActionEvent event) {
        String selectName = programmeCmb.getSelectionModel().getSelectedItem();
        ProgrammeDto programmeDto = programmeDtoMap.get(selectName);
        if (programmeDto != null) {
            proLbl.setText(String.valueOf(programmeDto.getId()));
        } else {
            System.out.println("Programme not found");
        }
    }

    @FXML
    void selectSession(ActionEvent event) {
        String selectName = sesssonCmb.getSelectionModel().getSelectedItem();
        SessionDto sessionDto = sessionDtoMap.get(selectName);
        if (sessionDto != null) {
            sessionLbl.setText(String.valueOf(sessionDto.getId()));
        } else {
            System.out.println("Session Not Found");
        }
    }

    @FXML
    void gotoBack(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("RicieptionChoiceView", pane);
    }
}
