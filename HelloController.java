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


//controlleur de  interface login
//controller les boutons.....
public class HelloController implements Initializable {
    //on va recuperer les id deja donne aux boutons
    @FXML
private Button tf_connecter; //recuperation du bouton  se connecter

    @FXML
private TextField tf_user; //recuperation du nom d utilisateur

    @FXML
    private TextField tf_password; //recuperation du mot de passe
    @FXML
    private Button insciption;








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //implementation
tf_connecter.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent actionevent) {  //comme om clique de javascript
        //appel de quelle methode ou precisement quelle scene
        DAOUtils.login(actionevent,tf_user.getText(),tf_password.getText());
    }
});

insciption.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            DAOUtils.changeScene(event, "inscription.fxml", "INSCRIPTION",null,null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
});

    }
}