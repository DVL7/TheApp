package com.example.theapp22;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class HelloController {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label Welcome;
    @FXML
    private Button myButton;

    @FXML
    protected void onHelloButtonClick() {
        String loginText = loginField.getText();
        String passwordText = passwordField.getText();

        // Example credentials, replace with your actual method of verification
        String correctLogin = "user";
        String correctPassword = "pass";

        if (loginText.equals(correctLogin) && passwordText.equals(correctPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

    }
}