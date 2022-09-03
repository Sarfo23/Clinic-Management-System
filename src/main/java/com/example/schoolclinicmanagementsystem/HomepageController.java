package com.example.schoolclinicmanagementsystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomepageController implements Initializable {
    @FXML
    private Button butnew;
    @FXML
    private Button butdiagnosis;
    @FXML
    private Button butinfo;
    @FXML
    private Button butnsearch;
    @FXML
    private Button butlogout;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        butnew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseConnector.changeScene(event, "addPatient.fxml", "New Patient");
            }
        });

        butdiagnosis.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseConnector.changeScene(event, "diagnosispage.fxml", "Patient Diagnosis");
            }
        });

        butlogout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseConnector.changeScene(event, "login.fxml", "login");
            }
        });

        butinfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseConnector.changeScene(event, "clinicInfo.fxml", "ClinicInfo");
            }
        });
        butnsearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseConnector.changeScene(event, "searchPane.fxml", "Search Panel");
            }
        });


    }


//   public void homepage() throws IOException {
//       Stage stage = new Stage();
//       FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("homepage.fxml"));
//       Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
//       stage.setTitle("Hello!");
//       stage.setScene(scene);
//       stage.show();
//   }



}
