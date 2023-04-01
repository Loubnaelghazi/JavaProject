package com.example.esalaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//controlleur de  interface login
//controller les boutons.....
public class HelloController  {
    //on va recuperer les id deja donne aux boutons

    private Stage stage;
    private Scene scene;
    private Parent root;



    public void switchToInscri(ActionEvent event ) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Inscription.fxml")); //ouvrir hello.fxml
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
scene=new Scene(root);
stage.setScene(scene);
stage.show();

    }
    public void switchToMenu(ActionEvent event )throws IOException{
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
 public void switchToDash(ActionEvent event )throws IOException{
     root = FXMLLoader.load(getClass().getResource("menu.fxml"));
     stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
     scene=new Scene(root);
     stage.setScene(scene);
     stage.show();

 }



}
