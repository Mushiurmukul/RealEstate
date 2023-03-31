package com.example.mukul;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class Start {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label messageLabel;
    private void loginHandler(ActionEvent e) throws IOException {
        String password = passwordField.getText();
        if (password.equals("mukul098")) {
            Sell(e);
            messageLabel.setText("Login successful!");
            return;
            // Perform necessary actions after successful login
        } else {
            messageLabel.setText("Incorrect password!");
        }
    }
    @FXML
    void Sell(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sell.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
