package com.example.theapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    public Label Welcome;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onHelloButtonClick() {
        String loginText = loginField.getText();
        String passwordText = passwordField.getText();

        // Example credentials, replace with your actual method of verification
        String correctLogin = "user";
        String correctPassword = "pass";

        if (loginText.equals(correctLogin) && passwordText.equals(correctPassword)) {
            welcomeText.setText("Login successful!");
        } else {
            welcomeText.setText("Login failed!");
        }
    }
}