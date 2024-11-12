package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TableViewController implements Initializable{

    public static ObservableList<Employe> employeData = FXCollections.observableArrayList();

    @FXML
    private TableView<Employe> myTable ;

    @FXML
    private Button modifyButton;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;

    public TableView<Employe> getMyTable() {
        return myTable;
    }

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if (employeData.isEmpty()){
            employeData.add(new Employe("Declerck", "Théo", "2020-12-01", "Dev",(float) 20, "Developpement", "agence3", 3, 3, 3));
            employeData.add(new Employe("Vance", "George", "2024-02-08", "Men",(float) 13, "Menage", "agence2", 3, 0, 0));
            employeData.add(new Employe("Marre", "Dylan", "2019-09-15", "Secrétaire",(float) 23, "Administratif", "agence2", 0, 2, 0));
            employeData.add(new Employe("Succi", "Bastien", "2015-05-19", "Patron",(float) 31, "Patron", "agence1", 0, 0, 0));
            employeData.add(new Employe("Safra-Dufossey", "Raph", "2017-07-22", "Dev",(float) 28, "Developpement", "agence3", 0, 0, 1));
        }

        TableColumn<Employe, String> nomCol = new TableColumn<Employe, String>("Nom");
        nomCol.setMinWidth(100);
        nomCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
        myTable.getColumns().add(nomCol);
        TableColumn<Employe, String> prenomCol = new TableColumn<Employe, String>("Prénom");
        prenomCol.setMinWidth(100);
        prenomCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("prenom"));
        myTable.getColumns().add(prenomCol);
        TableColumn<Employe, String> dateCol = new TableColumn<Employe, String>("Date d'embauche");
        dateCol.setMinWidth(200);
        dateCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("dateEmbauche"));
        myTable.getColumns().add(dateCol);
        TableColumn<Employe, String> fonctionCol = new TableColumn<Employe, String>("Fonction");
        fonctionCol.setMinWidth(100);
        fonctionCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("fonction"));
        myTable.getColumns().add(fonctionCol);
        TableColumn<Employe, Float> salaireCol = new TableColumn<Employe, Float>("Salaire brut (K)");
        salaireCol.setMinWidth(100);
        salaireCol.setCellValueFactory(new PropertyValueFactory<Employe, Float>("salaireBrut"));
        myTable.getColumns().add(salaireCol);
        TableColumn<Employe, String> serviceCol = new TableColumn<Employe, String>("Service");
        serviceCol.setMinWidth(100);
        serviceCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("service"));
        myTable.getColumns().add(serviceCol);
        TableColumn<Employe, String> agenceCol = new TableColumn<Employe, String>("Agence");
        agenceCol.setMinWidth(100);
        agenceCol.setCellValueFactory(new PropertyValueFactory<Employe, String>("agence"));
        myTable.getColumns().add(agenceCol);
        myTable.getItems().addAll(employeData);

        modifyButton.setOnAction(event -> {
            if(myTable.getSelectionModel().getSelectedItem() != null){
                ModifyController.setEmployeToModify(myTable.getSelectionModel().getSelectedItem(), employeData.indexOf(myTable.getSelectionModel().getSelectedItem()));
                try {
                    App.setRoot("modify");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            
        });

        deleteButton.setOnAction(event -> {
            if(myTable.getSelectionModel().getSelectedItem() != null){
                Employe employe = myTable.getSelectionModel().getSelectedItem();
                myTable.getItems().remove(employe);
            };
        });
        
        addButton.setOnAction(event -> {
            try {
                App.setRoot("add");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        
    }

    Stage stage;
    void setStage(Stage stg){stage=stg;}
}
