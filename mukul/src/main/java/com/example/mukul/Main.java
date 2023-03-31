package com.example.mukul;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load icon image
        Image icon = new Image("icon.png");

        // Set stage icon
        stage.getIcons().add(icon);
        stage.setTitle("REAL ESTATE MANAGEMENT SYSTEM");

        // Load FXML file and create scene
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Scene scene = new Scene(root);

        // Set stage scene
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
