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

public class SignUpController implements Initializable {

    @FXML
    private TextField txtfirstname;
    @FXML
    private TextField txtlastname;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtnumber;
    @FXML
    private TextField txtpassword;
    @FXML
    private Button butregister;
    @FXML
    private Button butclose;
    @FXML
    private Button butlogin;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        butregister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!txtfirstname.getText().trim().isEmpty() && !txtlastname.getText().trim().isEmpty() && !txtemail.getText().trim().isEmpty()
                        && !txtnumber.getText().trim().isEmpty() && !txtpassword.getText().trim().isEmpty()) {
                    DataBaseConnector.RegisterUser(event, txtfirstname.getText(), txtlastname.getText(), txtemail.getText(), txtnumber.getText(), txtpassword.getText());
                    DataBaseConnector.changeScene(event, "homepage.fxml", "Homepage");

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Enter all inform..........");
                    alert.show();
                }
            }
        });


        butlogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseConnector.changeScene(event, "login.fxml", "Log in");
            }
        });


    }
}
