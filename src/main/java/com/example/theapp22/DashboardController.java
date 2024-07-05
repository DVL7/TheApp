package com.example.theapp22;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML
    private Label welcomeLabel;

    public void setUserWelcomeText(String username) {
        welcomeLabel.setText("Witaj, " + username + "!");
    }
}