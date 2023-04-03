package com.example.essalaf;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    Admin admin;
    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



}
