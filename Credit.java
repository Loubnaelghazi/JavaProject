package com.example.esalaf;


public class Credit {
    private double montant;
    private double tauxInteret;
    private int duree;
    private String nom;


    public Credit(String nom, double montant, double tauxInteret, int duree) {
        this.nom = nom;
        this.montant = montant;
        this.tauxInteret = tauxInteret;
        this.duree = duree;
    }
    //getters et setters de la classe client pour pouvoir les utiliser par le dao


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

}


