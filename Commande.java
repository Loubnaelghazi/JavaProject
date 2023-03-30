package com.example.esalaf;

import java.time.LocalDate; //pour la date

public class Commande {
    private int id;
    private LocalDate date;
    private String nomClient;
    private double montantTotal;

    public Commande(int id, LocalDate date, String nomClient, double montantTotal) { //constructeur
        this.id = id;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }
}

