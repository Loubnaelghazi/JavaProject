package com.example.esalaf;

import java.util.ArrayList;
import java.util.List;

public class CommandeDao {




    private List<Produit> produits = new ArrayList<>();

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void modifierProduit(Produit produit) {
        int index = produits.indexOf(produit);
        if (index >= 0) {
            produits.set(index, produit);
        }
    }

    public void supprimerProduit(Produit produit) {
        produits.remove(produit);
    }

    public List<Produit> recupererTousLesProduits() {
        return new ArrayList<>(produits);
    }


    public List<Produit> recupererProduitsParNom(String nom) {
        List<Produit> produitsTrouves = new ArrayList<>();
        for (Produit produit : produits) {
            if (produit.getNom().equals(nom)) {
                produitsTrouves.add(produit);
            }
        }
        return produitsTrouves;
    }


    /*
    *recupererTousLesProduits : retourne une copie de la liste de produits.
recupererProduitsParNom : parcourt la liste de produits pour trouver tous les produits dont le nom correspond à celui fourni en paramètre.

   */
}
