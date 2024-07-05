package com.example.theapp22;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.io.IOException;

public class HelloController {
    private HelloApplication appInstance;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label Welcome;
    @FXML
    private Button myButton;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        String loginText = loginField.getText();
        String passwordText = passwordField.getText();


        Database db = new Database();
        db.getConnection();
        boolean loginResult = db.verifyLogin(loginText, passwordText);
        if (loginResult) {
            appInstance.switchToDashboardScene();
        }

        db.closeConnection();
    }
    public void setAppInstance(HelloApplication app) {
        this.appInstance = app;
    }
}