package com.example.schoolclinicmanagementsystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ClinicInfoController implements Initializable {

    @FXML
    private Button btnhome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnhome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseConnector.changeScene(event, "homepage.fxml", "HomePage");
            }
        });


    }
}
