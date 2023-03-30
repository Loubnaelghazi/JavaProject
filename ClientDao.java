package com.example.esalaf;

import java.sql.*;
import java.util.ArrayList;

public class ClientDao {
    private Connection connexion;

    public ClientDao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/esalaf";
        String utilisateur = "root";
        String motDePasse = "";
        connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
    }

    public void ajouterClient(Client client) throws SQLException {
        String sql = "INSERT INTO client (id_client, nom, telephone) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connexion.prepareStatement(sql);
        preparedStatement.setString(1, client.getNom());
        preparedStatement.setInt(2, client.getId());
        preparedStatement.setInt(3, client.getPhone());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Client> listerClients() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client";
        Statement statement = connexion.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            int id = result.getInt("id_client");
            String nom = result.getString("nom");
            int tel = result.getInt("telephone");
            clients.add(new Client(id, nom, tel));
        }
        return clients;
    }

    public void updateClient(Client client) throws SQLException {
        String sql = "UPDATE client SET nom=?, telephone=? WHERE id_client=?";
        PreparedStatement preparedStatement = connexion.prepareStatement(sql);
        preparedStatement.setString(1, client.getNom());
        preparedStatement.setInt(2, client.getPhone());
        preparedStatement.setInt(3, client.getId());
        preparedStatement.executeUpdate();
    }

    public void supprimerClient(Client client) throws SQLException {
        String sql = "DELETE FROM client WHERE id_client=?";
        PreparedStatement preparedStatement = connexion.prepareStatement(sql);
        preparedStatement.setInt(1, client.getId());
        preparedStatement.executeUpdate();
    }
}
