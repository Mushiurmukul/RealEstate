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

public class SearchList {
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
    private Button Search;


    private String filename = "property.txt";
    private String filename1 = "Searching.txt";
    public String price1;
    public String district1;
    public String propertyType1;
    public String radioButtonValue1;

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
    private void SearchListButton() {
        // Clear previous data in the table
        tableView.getItems().clear();
        try (BufferedReader br1 = new BufferedReader(new FileReader(filename1))) {
            String line1;
            while ((line1 = br1.readLine()) != null) {
                String[] parts1 = line1.split(",");
                price1 = parts1[0];
                district1 = parts1[1];
                propertyType1 = parts1[2];
                radioButtonValue1 = parts1[3];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                if(price.compareTo(price1)==0 && district.compareTo(district1)==0 && propertyType.compareTo(propertyType1)==0 && radioButtonValue.compareTo(radioButtonValue1)==0) {
                    Data data = new Data(price, country, district, phone, propertyType, location, radioButtonValue);
                    tableView.getItems().add(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void back(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Sell.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}