package com.example.esalaf;

import java.time.LocalDate; //pour la date

public class Commande {
    private int id;
   package com.example.essalaf;

public class Commande {
    private int id;
 private int produits;
    private String nomClient;
    private float montantTotal;

    public Commande(int id, int  produits, String nomClient, float montantTotal) { //constructeur
        this.id = id;
        this. produits =  produits;
        this.nomClient = nomClient;
        this.montantTotal = montantTotal;
    }
    //getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return  produits;
    }

    public void setDate(int  produits) {
        this. produits =  produits;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public float getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(float montantTotal) {
        this.montantTotal = montantTotal;
    }
}
