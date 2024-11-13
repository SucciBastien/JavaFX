package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

    public static void setEmployeToModify(Employe employe) {
        employeToModify = employe;
        idEmploye = employe.getId();
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
            try {
                JDBC.modifyEmploye(idEmploye, nomText.getText(), prenomText.getText(), dateEmbaucheText.getText(), fonctionText.getText(), Float.valueOf(salaireBrutText.getText()), serviceText.getText(), agenceText.getText(), Integer.valueOf(enfant0_10Text.getText()), Integer.valueOf(enfant11_15Text.getText()), Integer.valueOf(enfant16_18Text.getText()));
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
            }
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
