module com.example.theapp22 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.theapp22 to javafx.fxml;
    exports com.example.theapp22;
}