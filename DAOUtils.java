package com.example.esalaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
//la classe qui controle la communication entre la base de donnes et notre application !!

//daruriya
public class DAOUtils {


    //bach n9dru n switchiw bin les scennes :
    public static  void changeScene(ActionEvent event , String fxmlFile , String title , String username, String password ) throws IOException {
        Parent root =null ;
//
        if (username != null && password != null){
            try {
                FXMLLoader loader  = new FXMLLoader(DAOUtils.class.getResource(fxmlFile));
                root=loader.load();
                LoginController loginController=loader.getController(); // hadi c la scene qu on veut y acceder
               // loginController.setUserInformation(username,fxmlFile);
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            try {
                root=FXMLLoader.load(DAOUtils.class.getResource(fxmlFile));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        Stage stage=(Stage) ((Node) event.getSource().getScene().getWindow());
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

///////verifier la  validie des noms dans la page login

    public static void login(ActionEvent event ,String username,String password){ //interfcae dde login
Connection connection=null;
PreparedStatement preparedStatement =null;
ResultSet resultSet=null;
try {
    connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/esalaf","root","");
    preparedStatement=connection.prepareStatement("SELECT  password FROM utilisateurs WHERE user=?");
    preparedStatement.setString(1,username);
    resultSet=preparedStatement.executeQuery();

    if(!resultSet.isBeforeFirst()){ //si l utlisateur n existe pas dans la notre bse de donnes
System.out.println("Ces informations n'existent pas !");
Alert alert =new Alert(Alert.AlertType.ERROR);
alert.setContentText("Nom d'utilisateur ou mot de passe incorrects !");
alert.show();
    }else {
        while (resultSet.next()){
            String pswrd=resultSet.getString("password"); //password dans la base de donnes est de type string
if(pswrd.equals(password)){
    changeScene(event,"login.fxml","Welcome!",username,password);
}else{  //si le mot de passe est faux
    System.out.println("Mot de passe incorrect!");
    Alert alert =new Alert(Alert.AlertType.Error);
    alert.setContentText("Mot de passe inconvenable");
    alert.show();

}
        }
    }
}catch(SQLException e){
e.printStackTrace();
}finally {
    if (resultSet!=null){
        try {
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }if (connection !=null){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
    }










/////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection : " + e.getMessage());
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("Error closing statement : " + e.getMessage());
            }
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.err.println("Error closing prepared statement : " + e.getMessage());
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.err.println("Error closing result set : " + e.getMessage());
            }
        }
    }
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Impossible de fermer le Statement : " + e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Impossible de fermer le ResultSet : " + e.getMessage());
            }
        }
    }
}





