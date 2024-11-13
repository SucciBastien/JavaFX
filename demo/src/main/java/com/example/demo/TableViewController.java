package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
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

    public void fillTable(){
        try {
            employeData = Employe.listeEmployes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.fillTable();

        myTable.setItems(employeData);

        modifyButton.setOnAction(event -> {
            if(myTable.getSelectionModel().getSelectedItem() != null){
                ModifyController.setEmployeToModify(myTable.getSelectionModel().getSelectedItem());
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
                try {
                    JDBC.deleteEmploye(employe.getId());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
