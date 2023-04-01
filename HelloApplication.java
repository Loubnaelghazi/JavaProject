package com.example.esalaf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//interfcae de log in
public class HelloApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml")); //ouvrir hello.fxml
        Scene scene = new Scene(root); //taille du screen
        stage.setTitle("ESSALAF"); //Nom d application
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
