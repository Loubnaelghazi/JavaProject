package com.example.essalaf;

public class ClientDao  {

private int Id_client ;
private String Nom ;
private String Telephone;

    public ClientDao(int id_client, String nom, String telephone) {
        Id_client = id_client;
        Nom = nom;
        Telephone = telephone;
    }

    public int getId_client() {
        return Id_client;
    }

    public String getNom() {
        return Nom;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setId_client(int id_client) {
        Id_client = id_client;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }



}
