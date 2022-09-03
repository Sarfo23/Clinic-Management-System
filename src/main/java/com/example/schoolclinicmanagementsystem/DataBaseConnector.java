package com.example.schoolclinicmanagementsystem;

import com.example.schoolclinicmanagementsystem.patientobj.PatientObj;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DataBaseConnector {

    public static void RegisterUser(ActionEvent event, String firstname, String lastname, String email, String telephone_number, String password) {
        Connection connect = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUserExist = null;
        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ktu_school_clinic_management_system", "root", "");

            psUserExist = connect.prepareStatement("SELECT * FROM users WHERE email = ?");
            psUserExist.setString(1, email);
            resultSet = psUserExist.executeQuery();


            if (resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Already Exist");
                alert.show();
            } else {
                String sql = "INSERT INTO users (firstname, lastname, email, telephone_number, password) VALUES(?,?,?,?, ?)";
                psInsert = connect.prepareStatement(sql);
                psInsert.setString(1, firstname);
                psInsert.setString(2, lastname);
                psInsert.setString(3, email);
                psInsert.setString(4, telephone_number);
                psInsert.setString(5, password);

                int row = psInsert.executeUpdate();
                if (row > 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("New User Registered");
                    alert.show();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void changeScene(ActionEvent event, String fxmlFile, String title) {
        Parent root = null;
        try {
            root = FXMLLoader.load(DataBaseConnector.class.getResource(fxmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 1000, 700));
        stage.show();
    }


    public static void AddNewPatient(ActionEvent event, String patientname, String patientinfo, String patientage, String patientgender, String patientemail) {
        Connection connect = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUserExist = null;
        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ktu_school_clinic_management_system", "root", "");

            psUserExist = connect.prepareStatement("SELECT * FROM new_patient WHERE address = ?");
            psUserExist.setString(1, patientemail);
            resultSet = psUserExist.executeQuery();


            if (resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Patient Already Exist");
                alert.show();
            } else {
                String sql = "INSERT INTO new_patient (patient_name, contact_number, age, gender, address) VALUES(?,?,?,?, ?)";
                psInsert = connect.prepareStatement(sql);
                psInsert.setString(1, patientname);
                psInsert.setString(2, patientinfo);
                psInsert.setString(3, patientage);
                psInsert.setString(4, patientgender);
                psInsert.setString(5, patientemail);

                int row = psInsert.executeUpdate();
                if (row > 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("New Patient Registered");
                    alert.show();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void Diagnosis(ActionEvent event, String patient_name, String blood_group, String body_temperature, String sick_of, String any_previous_diseases_suffered, String drugs_administered) {
        Connection connect = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUserExist = null;
        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ktu_school_clinic_management_system", "root", "");

            psUserExist = connect.prepareStatement("SELECT * FROM new_patient WHERE patient_name = ?");
            psUserExist.setString(1, patient_name);
            resultSet = psUserExist.executeQuery();


            if (resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Already Exist");
                alert.show();
            } else {
                String sql = "INSERT INTO diagnosis (patient_name, blood_group, body_temperature, sick_of, any_previous_diseases_suffered, drugs_administered) VALUES (?,?,?,?,?, ?)";
                psInsert = connect.prepareStatement(sql);
                psInsert.setString(1, patient_name);
                psInsert.setString(2, blood_group);
                psInsert.setString(3, body_temperature);
                psInsert.setString(4, sick_of);
                psInsert.setString(5, any_previous_diseases_suffered);
                psInsert.setString(6, drugs_administered);

                int row = psInsert.executeUpdate();
                if (row > 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Patient Diagnosis Updated");
                    alert.show();


                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void login(ActionEvent event, String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ktu_school_clinic_management_system", "root", "");

            preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect Username or Password");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievePassword = resultSet.getString("password");

                    if (retrievePassword.equals(password)) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("Login Successful");
                        alert.show();
                        changeScene(event, "homepage.fxml", "Homepage");

                    } else {
                        System.out.println("Password did not match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("provided information do not match! Don't have an account, Signup");
                        alert.show();
                    }

                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static PatientObj selectSinglePatient( int ID){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ktu_school_clinic_management_system", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement( "SELECT * FROM diagnosis WHERE patient_id = ?");
            preparedStatement.setInt(1, ID);
            ResultSet result = preparedStatement.executeQuery();

            PatientObj patientObj = new PatientObj();
            if (result.next()) {
                patientObj.name = result.getString( "patient_name");
                patientObj.blood = result.getString("blood_group");
                patientObj.temp = result.getString("body_temperature");
                patientObj.sick = result.getString("sick_of");
                patientObj.disease = result.getString("any_previous_diseases_suffered");
                patientObj.drugs = result.getString("drugs_administered");
            }
            return patientObj;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}