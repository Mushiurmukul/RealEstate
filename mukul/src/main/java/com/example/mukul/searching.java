package com.example.mukul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class searching {
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
    private Button Search;
    @FXML
    private Button SearchList;
    private String district;
    private String price;
    private String rentOrSale;
    private String sellerContact;
    @FXML
    void Searching(ActionEvent event) {
        String radioBtnValue = rentRadioBtn.isSelected() ? "Rent" : "Sale";
        String propertyType = landRadioBtn.isSelected() ? "Land" : "Flat";

        String price = priceField.getText();
        String district = districtField.getText();

        String data = price +","+ district +
                "," + propertyType +
                "," + radioBtnValue+"\n";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Searching.txt"));
            writer.write(data);
            writer.close();
            messageLabel.setText("Searching Boss");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Property(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("SearchList.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
