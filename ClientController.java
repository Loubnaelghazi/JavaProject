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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class ClientController  implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ClientDao clientDAO;
    @FXML
    private TableView<ClientDao> clientt;
    @FXML
    private Button btnajouter;

    @FXML
    private Button btnmodifier;

    @FXML
    private Button btnsupprimer;

    @FXML
    private Button btnupdate;

    @FXML
    private TextField IdClient;

    @FXML
    private TextField NomClient;

    @FXML
    private TextField Numtel;

    @FXML
    private TableColumn<ClientDao, Integer> colid;

    @FXML
    private TableColumn<ClientDao, String> colnom;

    @FXML
    private TableColumn<ClientDao, String> colphone;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showclients();
    }

    public Connection getConnection(){
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/esalaf","root","");
            return conn;
        }catch (Exception ex){
            System.out.println("Error "+ ex.getMessage());
            return null;
        }
    }

    public ObservableList<ClientDao> getclientsListe(){
        ObservableList<ClientDao> ClientsList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String req = "SELECT * FROM client";
        Statement st;
        ResultSet rs;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(req);
            ClientDao clients;
            while(rs.next()){
                clients = new ClientDao(rs.getInt("Id_client")
                        ,rs.getString("Nom")
                        ,rs.getString("Telephone"));
                ClientsList.add(clients);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ClientsList;
    }

    public void showclients(){
        ObservableList<ClientDao> Liste = getclientsListe();
        colid.setCellValueFactory(new PropertyValueFactory<>("Id_client"));
        colnom.setCellValueFactory(new PropertyValueFactory<ClientDao,String>("Nom"));
        colphone.setCellValueFactory(new PropertyValueFactory<ClientDao,String>("Telephone"));
        clientt.setItems(Liste);
    }

    public void onAjouterButtClick(){
        String req = "INSERT INTO client(Id_client , Nom , Telephone) VALUES ('" + IdClient.getText() + "','" + NomClient.getText() + "','" + Numtel.getText() + "')";

        executeQuery(req);
        showclients();
    }

    public void onsuppButtClick() {
        String req = "DELETE FROM client WHERE id_client =" + IdClient.getText() + "";
        executeQuery(req);
        showclients();
    }


    public void onmodButtClick(){
        String req = "UPDATE client SET nom = '" + NomClient.getText() + "', telephone = " + Numtel.getText() + " WHERE id_client = " + IdClient.getText() + "";
        executeQuery(req);
        showclients();
    }



    //////////////////////////////////////
    public void switchToMenu3(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToDash3(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToProduc3(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("produit.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToCommande3(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("commande.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToClient3(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("client.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToCredit3(ActionEvent event)throws IOException{

        root = FXMLLoader.load(getClass().getResource("credit.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    /////////////////////////////
    public void executeQuery(String req) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(req);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }











}
