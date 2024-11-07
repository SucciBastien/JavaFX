package com.example.demo;

public class Directeur extends Employe {
    public Directeur(String nom, String prenom, String dateEmbauche, String fonction, Float salaireBrut, String service,
            Agence agence, int enfant0_10, int enfant11_15, int enfant16_18) {
        super(nom, prenom, dateEmbauche, fonction, salaireBrut, service, agence, enfant0_10, enfant11_15, enfant16_18);
    }

    @Override
    public Float Prime(){
        Float prime;

        prime = (float) (0.07 * this.salaireBrut + 0.03 * this.AnneesDeService() * this.salaireBrut);

        return prime;
    }
}
