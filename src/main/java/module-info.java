module com.example.schoolclinicmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.schoolclinicmanagementsystem to javafx.fxml;
    exports com.example.schoolclinicmanagementsystem;
}