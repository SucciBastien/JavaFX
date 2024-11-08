package com.example.demo;

import com.example.demo.Employe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MyTableView implements Initializable{

    private ObservableList<Employe> employeData = FXCollections.observableArrayList();

    @FXML
    private TableView<Employe> myTable = new TableView<Employe>();

    public TableView<Employe> myTable() {
        return myTable;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employeData.add(new Employe("Declerck", "Théo", "2020-12-01", "Dev",(float) 20, "Developpement", "agence3", 3, 3, 3));
        employeData.add(new Employe("Vance", "George", "2024-02-08", "Men",(float) 13, "Menage", "agence2", 3, 0, 0));
        employeData.add(new Employe("Marre", "Dylan", "2019-09-15", "Secrétaire",(float) 23, "Administratif", "agence2", 0, 2, 0));
        employeData.add(new Employe("Succi", "Bastien", "2015-05-19", "Patron",(float) 31, "Patron", "agence1", 0, 0, 0));
        employeData.add(new Employe("Safra-Dufossey", "Raph", "2017-07-22", "Dev",(float) 28, "Developpement", "agence3", 0, 0, 1));
        
        TableColumn<Employe, String> nomColumn = new TableColumn<Employe, String>("Nom");
        nomColumn.setMinWidth(100);
        nomColumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
 
        TableColumn<Employe, String> prenomColumn = new TableColumn<Employe, String>("Prénom");
        prenomColumn.setMinWidth(100);
        prenomColumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("prenom"));
 
        TableColumn<Employe, String> dateColumn = new TableColumn<Employe, String>("Date d'embauche");
        dateColumn.setMinWidth(200);
        dateColumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("dateEmbauche"));

        TableColumn<Employe, String> fonctionColumn = new TableColumn<Employe, String>("Fonction");
        fonctionColumn.setMinWidth(100);
        fonctionColumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("fonction"));

        TableColumn<Employe, Float> salaireColumn = new TableColumn<Employe, Float>("Salaire brut (K)");
        salaireColumn.setMinWidth(100);
        salaireColumn.setCellValueFactory(new PropertyValueFactory<Employe, Float>("salaireBrut"));

        TableColumn<Employe, String> serviceColumn = new TableColumn<Employe, String>("Service");
        serviceColumn.setMinWidth(100);
        serviceColumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("service"));

        TableColumn<Employe, String> agenceColumn = new TableColumn<Employe, String>("Agence");
        agenceColumn.setMinWidth(100);
        agenceColumn.setCellValueFactory(new PropertyValueFactory<Employe, String>("agence"));
        
        myTable.getItems().addAll(employeData);


    }

    Stage stage;
    void setStage(Stage stg){stage=stg;}
}
