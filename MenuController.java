package com.example.esalaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToDash1(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private Button btnAcceuil;

    @FXML
    private Button btnClients;

    @FXML
    private Button btnProduit;

    @FXML
    private Button btnComm;

    @FXML
    private Pane client;

    @FXML
    private Button parametres;

    @FXML
    private Label text;

    @FXML
    private Label minitext;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    // code du menu
    @FXML
    private void Cliquer(ActionEvent event) throws IOException {


        if (event.getSource() == btnClients) {
            // execute quand on va cliquer sur le bouton
            root = FXMLLoader.load(getClass().getResource("client.fxml"));
            stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        if (event.getSource() == btnProduit) {
            root = FXMLLoader.load(getClass().getResource("produit.fxml"));
            stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        if (event.getSource() == btnComm) {
            root = FXMLLoader.load(getClass().getResource("commande.fxml"));
            stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        if (event.getSource() == btnAcceuil) {

            root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource() == parametres) {
            root = FXMLLoader.load(getClass().getResource("credit.fxml"));
            stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
