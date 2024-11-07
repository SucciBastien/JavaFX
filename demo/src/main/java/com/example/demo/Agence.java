package com.example.demo;

public class Agence{

    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private Boolean resto;

    public Agence(String nom, String adresse, String codePostal, String ville, Boolean resto) {
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.resto = resto;
    }
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public Boolean getResto() {
        return resto;
    }
    public void setResto(Boolean resto) {
        this.resto = resto;
    }
    
}