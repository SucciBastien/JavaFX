package com.example.demo;

import com.example.demo.Employe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;

public class MyTableView {

    @FXML
    private TableView<Employe> myTable = new TableView<Employe>();
    
    final ObservableList<Employe> data = FXCollections.observableArrayList(
        new Employe("Declerck", "Théo", "2020-12-01", "Dev",(float) 20, "Developpement", "agence3", 3, 3, 3),
        new Employe("Vance", "George", "2024-02-08", "Men",(float) 13, "Menage", "agence2", 3, 0, 0),
        new Employe("Marre", "Dylan", "2019-09-15", "Secrétaire",(float) 23, "Administratif", "agence2", 0, 2, 0),
        new Employe("Succi", "Bastien", "2015-05-19", "Patron",(float) 31, "Patron", "agence1", 0, 0, 0),
        new Employe("Safra-Dufossey", "Raph", "2017-07-22", "Dev",(float) 28, "Developpement", "agence3", 0, 0, 1)
    );

    @SuppressWarnings("unchecked")
    @FXML
    public void MyEmployeeTableView() {
        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));
 
        myTable.setEditable(true);
 
        TableColumn<Employe, String> nomCol = new TableColumn<Employe, String>("Nom");
        nomCol.setMinWidth(100);
        nomCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
 
        TableColumn<Employe, String> prenomCol = new TableColumn<Employe, String>("Prénom");
        prenomCol.setMinWidth(100);
        prenomCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("prenom"));
 
        TableColumn<Employe, String> dateCol = new TableColumn<Employe, String>("Date d'embauche");
        dateCol.setMinWidth(200);
        dateCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("dateEmbauche"));

        TableColumn<Employe, String> fonctionCol = new TableColumn<Employe, String>("Fonction");
        fonctionCol.setMinWidth(100);
        fonctionCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("fonction"));

        TableColumn<Employe, Float> salaireCol = new TableColumn<Employe, Float>("Salaire brut (K)");
        salaireCol.setMinWidth(100);
        salaireCol.setCellValueFactory(new PropertyValueFactory<Employe, Float>("salaireBrut"));

        TableColumn<Employe, String> serviceCol = new TableColumn<Employe, String>("Service");
        serviceCol.setMinWidth(100);
        serviceCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("service"));

        TableColumn<Employe, String> agenceCol = new TableColumn<Employe, String>("Agence");
        agenceCol.setMinWidth(100);
        agenceCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("agence"));
 
        myTable.setItems(data);
        
        myTable.getColumns().addAll(nomCol, prenomCol, dateCol, fonctionCol, salaireCol, serviceCol, agenceCol);
    }

    public TableView<Employe> myTable() {
        return myTable;
    }
}
