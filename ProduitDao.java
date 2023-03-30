package com.example.esalaf;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDao {
    private Connection connexion;

    public ProduitDao(Connection connexion) { //constructeur.autre facon pour utiliation de connexion
        this.connexion = connexion;
    }

    public void ajouterProduit(Produit produit) {
        try {
            PreparedStatement statement = connexion.prepareStatement(
                    "INSERT INTO produit (nom, prix, quantite) VALUES (?, ?, ?)");
            statement.setString(1, produit.getNom());
            statement.setDouble(2, produit.getPrix());
            statement.setInt(3, produit.getQuantite());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierProduit(Produit produit) {
        try {
            PreparedStatement statement = connexion.prepareStatement(
                    "UPDATE produit SET nom=?, prix=?, quantite=? WHERE id=?");
            statement.setString(1, produit.getNom());
            statement.setDouble(2, produit.getPrix());
            statement.setInt(3, produit.getQuantite());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerProduit(Produit produit) {
        try {
            PreparedStatement statement = connexion.prepareStatement(
                    "DELETE FROM produit WHERE nom=?");
            statement.setString(1, produit.getNom());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produit> recupererTousLesProduits() {
        List<Produit> produits = new ArrayList<>();
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT * FROM produit");
            while (resultat.next()) {
                Produit produit = new Produit(
                        resultat.getString("nom"),
                        resultat.getDouble("prix"),
                        resultat.getInt("quantite")
                );
                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits; // récupère tous les produits de la table produit et les renvoie sous forme de liste.
    }

    public Produit recupererProduitParId(int id) {
        Produit produit = null;
        try {
            PreparedStatement statement = connexion.prepareStatement(
                    "SELECT *FROM produit WHERE id=?");
            statement.setInt(1, id);
            ResultSet resultat = statement.executeQuery();
            if (resultat.next()) {
                produit = new Produit(
                        resultat.getString("nom"),
                        resultat.getDouble("prix"),
                        resultat.getInt("quantite")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produit; //récupère un produit spécifique de la table produit en utilisant son ID.
    }
}
