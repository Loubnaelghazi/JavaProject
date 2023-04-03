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
public class CommandeController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
     Commande commande;

    @FXML
    private TableColumn<Commande, Integer> colId;

    @FXML
    private TableColumn<Commande, Float> colMon;

    @FXML
    private TableColumn<Commande, Integer> colProd;

    @FXML
    private TableColumn<Commande, String> colnom;

    @FXML
    private TableView<Commande> table;

    @FXML
    private TextField tclient;
    @FXML
    private TextField tid;

    @FXML
    private TextField tmont;

    @FXML
    private TextField tpro;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showcommandes();
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


    public ObservableList<Commande> getcommandesListe() {
        ObservableList<Commande> commandesList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String req = "SELECT * FROM commande";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(req);
            Commande commandes;
            while (rs.next()) {
                commandes = new Commande(rs.getInt("Id")
                        , rs.getInt("Nom_client")
                        , rs.getString("Produits")
                        , rs.getFloat("Montant") );
                commandesList.add(commandes);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return commandesList;
    }

    public void showcommandes() {
        ObservableList<Commande> Liste = getcommandesListe();
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Commande, String>("Nom_client"));
        colProd.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("Produits"));
        colMon.setCellValueFactory(new PropertyValueFactory<Commande, Float>("Montant"));
        table.setItems(Liste);
    }

    public void onsupButtClick2() { // b id
        String req = "DELETE FROM commande WHERE Id =" + tid.getText() + "";
        executeQuery(req);
        showcommandes();
    }


    public void onmodButClick2(){
        String req = "UPDATE commande SET Montant = '" + tmont.getText() + "', Produits = " + tpro.getText() + " WHERE Id = " + tid.getText() + "";
        executeQuery(req);
        showcommandes();
    }

    public void onAjouterButClick2(){
        String req = "INSERT INTO commande VALUES ("+ tclient.getText() + "','"
                + tmont.getText() + "'," + tpro.getText() + "'," + tid.getText() + ")";
        executeQuery(req);
        showcommandes();
    }
////////////////////////////////////////////////////////////////

    public void switchToMenu5(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToDash5(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToProduc5(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("produit.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToCommande5(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("commande.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToClient5(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("client.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToCredit5(ActionEvent event)throws IOException{

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
