package com.example.schoolclinicmanagementsystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPatientController implements Initializable {
    @FXML
    private TextField txtpatient;
    @FXML
    private TextField txtcontact;
    @FXML
    private TextField txtage;
    @FXML
    private TextField txtgender;
    @FXML
    private TextField txtemail;
    @FXML
    private Button butregister1;
    @FXML
    private Button buthompage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        buthompage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseConnector.changeScene(event, "homepage.fxml", "Home Page");
            }
        });

        butregister1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!txtpatient.getText().trim().isEmpty() && !txtcontact.getText().trim().isEmpty() && !txtage.getText().trim().isEmpty()
                && !txtemail.getText().trim().isEmpty() && !txtgender.getText().trim().isEmpty()){
                    DataBaseConnector.AddNewPatient(event, txtpatient.getText(), txtcontact.getText(), txtage.getText(), txtgender.getText(), txtemail.getText());
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Enter all inform..........");
                    alert.show();
                }
            }
        });

    }
}
