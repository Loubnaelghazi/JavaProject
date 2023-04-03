package com.example.essalaf;

public class Credit {
    private float montant;

    private int duree;
    private String nom;


    public Credit(String nom, int duree, float montant) {
        this.nom = nom;
        this.montant = montant;

        this.duree = duree;
    }
    //getters et setters de la classe client pour pouvoir les utiliser par le dao


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }



    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

}

