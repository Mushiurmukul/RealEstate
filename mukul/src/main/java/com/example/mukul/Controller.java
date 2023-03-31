package com.example.mukul;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Data> tableView;
    @FXML
    private TableColumn<Data, Double> priceCol;
    @FXML
    private TableColumn<Data, String> countryCol;
    @FXML
    private TableColumn<Data, String> districtCol;
    @FXML
    private TableColumn<Data, String> phoneCol;
    @FXML
    private TableColumn<Data, String> propertyTypeCol;
    @FXML
    private TableColumn<Data, String> locationCol;
    @FXML
    private TableColumn<Data, String> radioButtonValueCol;
    @FXML
    private Button updateListButton;
    @FXML
    private Button post;


    private String filename = "property.txt";

    @FXML
    private void initialize() {
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        districtCol.setCellValueFactory(new PropertyValueFactory<>("district"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        propertyTypeCol.setCellValueFactory(new PropertyValueFactory<>("propertyType"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        radioButtonValueCol.setCellValueFactory(new PropertyValueFactory<>("radioButtonValue"));
    }
    @FXML
    private void handleUpdateListButton() {
        // Clear previous data in the table
        tableView.getItems().clear();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String price = parts[0];
                String country = parts[1];
                String district = parts[2];
                String phone = parts[3];
                String propertyType = parts[4];
                String location = parts[5];
                String radioButtonValue = parts[6];
                Data data = new Data(price, country, district, phone, propertyType, location, radioButtonValue);
                tableView.getItems().add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void post(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Sell.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}