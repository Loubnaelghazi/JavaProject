package com.example.essalaf;

public class Produit {
    private String nom;
    private float prix;
    private int quantite;

    public Produit(String nom, float prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    /////////////////////////////////////////////////////
    public double getPrixTotal() {  //calcul de prix total si je peux l utiliser
        return prix * quantite;
    }


}
