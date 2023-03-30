package com.example.esalaf;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public  class InscriptionController implements Initializable {

    @FXML
    private Button inscrire;
    @FXML
    private TextField user;
    @FXML
    private  TextField password;
    @FXML
    private Button connexion;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /////1
 inscrire.setOnAction(new EventHandler<ActionEvent>() {
     @Override
     public void handle(ActionEvent actionEvent) {

         if(!user.getText().trim().isEmpty()&& password.getText().trim().isEmpty()){
             //ta tsawbi inscription udereha
         //    DAOUtils
         }

     }
 });

//fch nclikiw 3la deja inscrit irj3 l page luwlanya ga3
 connexion.setOnAction(new EventHandler<ActionEvent>() {
     @Override
     public void handle(ActionEvent event) {
         try {
             DAOUtils.changeScene(event,"hello-view.fxml","SE CONNECTER",null,null);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }

     }
 });
    }
}
