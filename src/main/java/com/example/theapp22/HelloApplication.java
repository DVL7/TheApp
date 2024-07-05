// Main.java
package com.example.theapp22;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    private static Stage primaryStage;
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 680;
    private static final String WINDOW_TITLE = "TheApp";

    // W HelloApplication.java, w metodzie start
    @Override
    public void start(Stage primaryStage) throws Exception{
        HelloApplication.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        HelloController controller = loader.getController();
        controller.setAppInstance(this);

        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    // W HelloApplication.java
    public void switchToDashboardScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
        Parent dashboardRoot = loader.load();
        Scene dashboardScene = new Scene(dashboardRoot, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(dashboardScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}