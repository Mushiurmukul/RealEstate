package com.example.mukul;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class sell {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private RadioButton rentRadioBtn;

    @FXML
    private RadioButton saleRadioBtn;

    @FXML
    private TextField priceField;

    @FXML
    private TextField countryField;

    @FXML
    private TextField districtField;

    @FXML
    private TextField phoneField;

    @FXML
    private RadioButton landRadioBtn;

    @FXML
    private RadioButton flatRadioBtn;

    @FXML
    private TextField locationField;
    @FXML
    private Label messageLabel;
    @FXML
    private Button post;
    @FXML
    private Button search;
    private String district;
    private String price;
    private String rentOrSale;
    private String sellerContact;
    @FXML
    void postProperty(ActionEvent event) {
        String radioBtnValue = rentRadioBtn.isSelected() ? "Rent" : "Sale";
        String propertyType = landRadioBtn.isSelected() ? "Land" : "Flat";

        String price = priceField.getText();
        String country = countryField.getText();
        String district = districtField.getText();
        String phone = phoneField.getText();
        String location = locationField.getText();

        String data = price +","+ country +"," + district +
                "," + phone +
                "," + propertyType +
                "," + location +
                "," + radioBtnValue+"\n";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("property.txt",true));
            writer.write(data);
            writer.close();
            messageLabel.setText("Post successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void list(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("list.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void Search(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Searching.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

