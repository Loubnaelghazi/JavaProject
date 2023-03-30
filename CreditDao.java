package com.example.esalaf;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import com.example.esalaf.DAOUtils;

public class CreditDao {
    private Connection connexion;

    public CreditDao(Connection connexion) {
        this.connexion = connexion;
    }

    public List<Credit> listerCredits() throws SQLException {
        List<Credit> credits = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT nom, montant, taux_interet, duree FROM credit";
            statement = connexion.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                double montant = resultSet.getDouble("montant");
                double tauxInteret = resultSet.getDouble("taux_interet");
                int duree = resultSet.getInt("duree");
                Credit credit = new Credit(nom, montant, tauxInteret, duree);
                credits.add(credit);
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la récupération des crédits dans la base de données : " + e.getMessage(), e);
        } finally {
            DAOUtils.closeResultSet(resultSet);
            DAOUtils.closeStatement(statement);
        }

        return credits;
    }

    public void ajouterCredit(Credit credit) throws SQLException {
        PreparedStatement statement = null;

        try {
            String sql = "INSERT INTO credit (nom, montant, taux_interet, duree) VALUES (?, ?, ?, ?)";
            statement = connexion.prepareStatement(sql);
            statement.setString(1, credit.getNom());
            statement.setDouble(2, credit.getMontant());
            statement.setDouble(3, credit.getTauxInteret());
            statement.setInt(4, credit.getDuree());
            int resultat = statement.executeUpdate();

            if (resultat == 0) {
                throw new SQLException("Échec de la création du crédit, aucune ligne ajoutée dans la table.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la création du crédit : " + e.getMessage(), e);
        } finally {
            DAOUtils.closeStatement(statement);
        }
    }

    public void supprimerCredit(Credit credit) throws SQLException {
        PreparedStatement statement = null;

        try {
            String sql = "DELETE FROM credit WHERE nom = ?";
            statement = connexion.prepareStatement(sql);
            statement.setString(1, credit.getNom());
            int resultat = statement.executeUpdate();

            if (resultat == 0) {
                throw new SQLException("Échec de la suppression du crédit, aucun enregistrement supprimé dans la table.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la suppression du crédit : " + e.getMessage(), e);
        } finally {
            DAOUtils.closeStatement(statement);
        }
    }

}