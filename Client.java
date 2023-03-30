package com.example.esalaf;

public class Client {
    private int id;
    private String nom;
    private int tel;

    public Client(int id, String nom, int tel) { //constructeur
        this.id = id;
        this.nom = nom;
        this.tel = tel;
    }

    //getters et setters de la classe client pour pouvoir les utiliser par le dao
    public int getId() {
        return id;
    }

    public void settId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPhone() {
        return tel;
    }

    public void setPhone(int tel) {
        this.tel = tel;
    }
}
