package com.example.esalaf;

import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
//interfcae de log in
public class HelloApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml")); //ouvrir hello.fxml
        Scene scene = new Scene(fxmlLoader.load()); //taille du screen
        stage.setTitle("ESSALAF"); //Nom d application
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
