package com.example.schoolclinicmanagementsystem;

import com.example.schoolclinicmanagementsystem.patientobj.PatientObj;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private Button bntSearch;

    @FXML
    private Button btnupdate;

    @FXML
    private Button buthome;

    @FXML
    private TextField txtBlood;

    @FXML
    private TextField txtDisease;

    @FXML
    private TextField txtDrugs;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtSick;

    @FXML
    private TextField txtTemp;

    @FXML
    public void search() {
        String filter = txtname.getText();
        if (filter.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter Patient Name");
            alert.show();
        } else {
            int patient_id = Integer.parseInt(filter);
            PatientObj pat = DataBaseConnector.selectSinglePatient(patient_id);
            if (pat != null) {
                txtName.setText(pat.name);
                txtBlood.setText(pat.blood);
                txtDisease.setText(pat.disease);
                txtDrugs.setText(pat.drugs);
                txtSick.setText(pat.sick);
                txtTemp.setText(pat.temp);
            }
        }
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        bntSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                search();
            }
        });

        buthome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseConnector.changeScene(event, "homepage.fxml", "Homepage");
            }
        });

    }
}
