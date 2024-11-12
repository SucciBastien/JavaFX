package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddController implements Initializable{

    @FXML
    private Button closeButton;
    @FXML
    private Button submitButton;
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
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        submitButton.setOnAction(event -> {
            String nom = nomText.getText();
            String prenom = prenomText.getText();
            String dateEmbauche = dateEmbaucheText.getText();
            String fonction = fonctionText.getText();
            Float salaireBrut = Float.valueOf(salaireBrutText.getText());
            String service = serviceText.getText();
            String agence = agenceText.getText();
            int enfant0_10 = Integer.valueOf(enfant0_10Text.getText());
            int enfant11_15 = Integer.valueOf(enfant11_15Text.getText());
            int enfant16_18 = Integer.valueOf(enfant16_18Text.getText());
            TableViewController.employeData.add(new Employe(nom, prenom, dateEmbauche, fonction, salaireBrut, service, agence, enfant0_10, enfant11_15, enfant16_18));
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

        enfant0_10Text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    enfant0_10Text.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        enfant11_15Text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    enfant11_15Text.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        enfant16_18Text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    enfant16_18Text.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    
    
}
