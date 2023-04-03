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

public class ProduitController implements Initializable {


    Produit produit;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField Tnom;

    @FXML
    private TextField Tprod;

    @FXML
    private TextField Tqu;

    @FXML
    private TableView<Produit> tab;

    @FXML
    private TableColumn<Produit, String> colN;

    @FXML
    private TableColumn<Produit, Float> colP;

    @FXML
    private TableColumn<Produit, Integer> colQ;


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

    public ObservableList<Produit> getproduitsListe() {
        ObservableList<Produit> ProduitsList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String req = "SELECT * FROM produit";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(req);
            Produit produits;
            while (rs.next()) {
                produits = new Produit(rs.getString("Nom")
                        , rs.getFloat("Prix")
                        , rs.getInt("Quantite"));
                ProduitsList.add(produits);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ProduitsList;
    }

    public void showproduits() {
        ObservableList<Produit> Liste = getproduitsListe() ;
        colQ.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
        colN.setCellValueFactory(new PropertyValueFactory<Produit, String>("Nom"));
        colP.setCellValueFactory(new PropertyValueFactory<Produit, Float>("Prix"));
        tab.setItems(Liste);
    }


    public void onsupButtClick1() {
        String req = "DELETE FROM produit WHERE Nom =" + Tnom.getText() + "";
        executeQuery(req);
        showproduits();
    }


    public void onmodButClick1(){
        String req = "UPDATE produit SET Quantite = '" + Tqu.getText() + "', Prix = " + Tprod.getText() + " WHERE Nom = " + Tnom.getText() + "";
        executeQuery(req);
        showproduits();
    }

    public void onAjouterButClick1(){
        String req = "INSERT INTO produit(Nom , Prix , Quantite) VALUES ("+ Tnom.getText() + "','"
                + Tprod.getText() + "'," + Tqu.getText() + ")";
        executeQuery(req);
        showproduits();
    }



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
////////////////////////////////////////














    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showproduits();
    }






}
