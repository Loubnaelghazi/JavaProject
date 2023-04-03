package com.example.essalaf;

public class Admin {
    private Long id;
    private String user;
    private String pwd;

    public Admin() {
    }

    public Admin( String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }



    public String getUser() {
        return this.user;
    }

    public String getPwd() {
        return this.pwd;
    }

    public String toString() {
        return " user='" + this.user + "', pwd='" + this.pwd + "'}";
    }
}