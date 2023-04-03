package com.example.essalaf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CreditController  implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Credit credit;
    @FXML
    private TableColumn<Credit, String> colc;

    @FXML
    private TableColumn<Credit, Integer> cold;

    @FXML
    private TableColumn<Credit, Float> colm;

    @FXML
    private TableView<Credit> tabc;
    @FXML
    private TextField tmontant;
    @FXML
    private TextField tclient;

    @FXML
    private TextField tduree;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showcredits();
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/esalaf", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return null;
        }
    }


    public ObservableList<Credit> getcreditListe() {
        ObservableList<Credit> CreditsList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String req = "SELECT * FROM credit";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(req);
            Credit credits;
            while (rs.next()) {
                credits = new Credit(rs.getString("Nom_client")
                        , rs.getInt("Duree")
                        , rs.getFloat("Montant"));
                CreditsList.add(credits);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CreditsList;
    }

    public void showcredits() {
        ObservableList<Credit> Liste = getcreditListe();
        cold.setCellValueFactory(new PropertyValueFactory<>("Duree"));
        colc.setCellValueFactory(new PropertyValueFactory<Credit, String>("Nom_client"));
        colm.setCellValueFactory(new PropertyValueFactory<Credit, Float>("Montant"));
        tabc.setItems(Liste);
    }

    public void onsupButtClick() {
        String req = "DELETE FROM credit WHERE Montant =" + tmontant.getText() + "";
        executeQuery(req);
        showcredits();
    }


    public void onmodButClick(){
        String req = "UPDATE credit SET Nom_client = '" + tclient.getText() + "', Duree = " + tduree.getText() + " WHERE Montant = " + tmontant.getText() + "";
        executeQuery(req);
        showcredits();
    }

    public void onAjouterButClick(){
        String req = "INSERT INTO credit(Nom_client, Duree , Montant) VALUES ("+ tclient.getText() + "','"
                + tduree.getText() + "'," + tmontant.getText() + ")";
        executeQuery(req);
        showcredits();
    }

    public void switchToMenu4(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToDash4(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToProduc4(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("produit.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToCommande4(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("commande.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToClient4(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("client.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToCredit4(ActionEvent event)throws IOException{

        root = FXMLLoader.load(getClass().getResource("credit.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    public void executeQuery(String req) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(req);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
