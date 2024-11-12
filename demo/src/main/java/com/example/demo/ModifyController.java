package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ModifyController implements Initializable{

    @FXML
    private Button closeButton;
    @FXML
    private TextField nomText;
    @FXML
    private TextField prenomText;
    @FXML
    private TextField dateEmbaucheText;
    @FXML
    private TextField fonctionText;
    @FXML
    private TextField salaireBrutText;
    @FXML
    private TextField serviceText;
    @FXML
    private TextField agenceText;
    @FXML
    private TextField enfant0_10Text;
    @FXML
    private TextField enfant11_15Text;
    @FXML
    private TextField enfant16_18Text;
    @FXML
    private Button submitButton;

    public static Employe employeToModify;

    public static int idEmploye;

    public static void setEmployeToModify(Employe employe, int id) {
        employeToModify = employe;
        idEmploye = id;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        nomText.setText(employeToModify.getNom());
        prenomText.setText(employeToModify.getPrenom());
        dateEmbaucheText.setText(employeToModify.getDateEmbauche());
        fonctionText.setText(employeToModify.getFonction());
        salaireBrutText.setText(employeToModify.getSalaireBrut().toString());
        serviceText.setText(employeToModify.getService());
        agenceText.setText(employeToModify.getAgence());
        enfant0_10Text.setText(String.valueOf(employeToModify.getEnfant0_10()));
        enfant11_15Text.setText(String.valueOf(employeToModify.getEnfant11_15()));
        enfant16_18Text.setText(String.valueOf(employeToModify.getEnfant16_18()));

        submitButton.setOnAction(event -> {
            if(employeToModify.getNom() != nomText.getText()){
                TableViewController.employeData.get(idEmploye).setNom(nomText.getText());
            }
            if(employeToModify.getPrenom() != prenomText.getText()){
                TableViewController.employeData.get(idEmploye).setPrenom(prenomText.getText());
            };
            if(employeToModify.getDateEmbauche() != dateEmbaucheText.getText()){
                TableViewController.employeData.get(idEmploye).setDateEmbauche(dateEmbaucheText.getText());
            };
            if(employeToModify.getFonction() != fonctionText.getText()){
                TableViewController.employeData.get(idEmploye).setFonction(fonctionText.getText());
            };
            if(employeToModify.getSalaireBrut() != Float.valueOf(salaireBrutText.getText())){
                TableViewController.employeData.get(idEmploye).setSalaireBrut(Float.valueOf(salaireBrutText.getText()));
            };
            if(employeToModify.getService() != serviceText.getText()){
                TableViewController.employeData.get(idEmploye).setService(serviceText.getText());
            };
            if(employeToModify.getAgence() != agenceText.getText()){
                TableViewController.employeData.get(idEmploye).setAgence(agenceText.getText());
            };
            if(employeToModify.getEnfant0_10() != Integer.valueOf(enfant0_10Text.getText())){
                TableViewController.employeData.get(idEmploye).setEnfant0_10(Integer.valueOf(enfant0_10Text.getText()));
            };
            if(employeToModify.getEnfant11_15() != Integer.valueOf(enfant11_15Text.getText())){
                TableViewController.employeData.get(idEmploye).setEnfant11_15(Integer.valueOf(enfant11_15Text.getText()));
            };
            if(employeToModify.getEnfant16_18() != Integer.valueOf(enfant16_18Text.getText())){
                TableViewController.employeData.get(idEmploye).setEnfant16_18(Integer.valueOf(enfant16_18Text.getText()));
            };
            try {
                App.setRoot("primary");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        closeButton.setOnAction(event -> {
            try {
                App.setRoot("primary");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    
    
}
