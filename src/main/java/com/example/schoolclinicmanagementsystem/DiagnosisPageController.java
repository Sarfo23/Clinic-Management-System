package com.example.schoolclinicmanagementsystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class DiagnosisPageController implements Initializable {

    @FXML
    private TextField txtpatientname;
    @FXML
    private TextField txtblood;
    @FXML
    private TextField txttemp;
    @FXML
    private TextField txtsick;
    @FXML
    private TextField txtdisease;
    @FXML
    private TextField txtdrugs;
    @FXML
    private DatePicker date;
    @FXML
    private Button butsave;
    @FXML
    private Button buthome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        buthome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseConnector.changeScene(event, "homepage.fxml", "Home Page");
            }
        });

        butsave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!txtpatientname.getText().trim().isEmpty() && !txtblood.getText().trim().isEmpty() && !txttemp.getText().trim().isEmpty() && !txtsick.getText().trim().isEmpty()
                        && !txtdisease.getText().trim().isEmpty() && !txtdrugs.getText().trim().isEmpty()){
                    DataBaseConnector.Diagnosis(event, txtpatientname.getText(), txtblood.getText(), txttemp.getText(), txtsick.getText(), txtdisease.getText(), txtdrugs.getText());
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Enter all inform..........");
                    alert.show();
                }
            }

        });

    }





}
