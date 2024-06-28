module com.example.theapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.theapp to javafx.fxml;
    exports com.example.theapp;
}