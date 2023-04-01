package com.example.esalaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CrudController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToMenu(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToDash2(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToProduct(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("produit.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToCommande(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("commande.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToClient(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("client.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToCredit(ActionEvent event)throws IOException{

        root = FXMLLoader.load(getClass().getResource("credit.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}
