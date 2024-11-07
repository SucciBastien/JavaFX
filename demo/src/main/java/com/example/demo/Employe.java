package com.example.demo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;


public class Employe implements Comparable<Employe> {
    
    private String nom;
    private String prenom;
    private String dateEmbauche;
    private String fonction;
    protected Float salaireBrut;
    private String service;
    private String agence;
    private int enfant0_10;
    private int enfant11_15;
    private int enfant16_18;

    public Employe(String nom, String prenom, String dateEmbauche, String fonction, Float salaireBrut, String service, String agence, int enfant0_10, int enfant11_15, int enfant16_18) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
        this.fonction = fonction;
        this.salaireBrut = salaireBrut;
        this.service = service;
        this.agence = agence;
        this.enfant0_10 = enfant0_10;
        this.enfant11_15 = enfant11_15;
        this.enfant16_18 = enfant16_18;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getDateEmbauche() {
        return dateEmbauche;
    }
    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    public String getFonction() {
        return fonction;
    }
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    public Float getSalaireBrut() {
        return salaireBrut;
    }
    public void setSalaireBrut(Float salaireBrut) {
        this.salaireBrut = salaireBrut;
    }
    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }
    public String getAgence() {
        return agence;
    }
    public void setAgence(String agence) {
        this.agence = agence;
    }
    public int getEnfant0_10() {
        return enfant0_10;
    }
    public void setEnfant0_10(int enfant0_10) {
        this.enfant0_10 = enfant0_10;
    }
    public int getEnfant11_15() {
        return enfant11_15;
    }
    public void setEnfant11_15(int enfant11_15) {
        this.enfant11_15 = enfant11_15;
    }
    public int getEnfant16_18() {
        return enfant16_18;
    }
    public void setEnfant16_18(int enfant16_18) {
        this.enfant16_18 = enfant16_18;
    }

    public int AnneesDeService(){

        LocalDate startDate = LocalDate.of(Integer.parseInt(this.dateEmbauche.substring(0, 4)), Integer.parseInt(this.dateEmbauche.substring(5, 7)), Integer.parseInt(this.dateEmbauche.substring(8, 10)));

        LocalDate today = LocalDate.now();

        int diffInYears = Period.between(startDate, today).getYears();

        return diffInYears;

    }

    public Float Prime(){
        Float prime;

        prime = (float) (0.05 * this.salaireBrut + 0.02 * this.AnneesDeService() * this.salaireBrut);

        return prime;
    
    }

    @Override
    public String toString() {
        return "Employe [nom=" + nom + ", prenom=" + prenom + ", dateEmbauche=" + dateEmbauche + ", fonction="
                + fonction + ", salaireBrut=" + salaireBrut + ", service=" + service + "]";
    }

    @Override
    public int compareTo(Employe e) {

        int compareNom = this.getNom().compareTo(e.getNom());
        int comparePrenom = this.getPrenom().compareTo(e.getPrenom());

        if(compareNom == 0){
            return comparePrenom;
        }
        else{
            return compareNom;
        }
    }

    public Boolean chequeVac(){
        if(this.AnneesDeService() >= 1){
            return true;
        }
        else{
            return false;
        }
    }
    
}


        
    

