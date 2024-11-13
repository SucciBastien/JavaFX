package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
    

    public static ResultSet getRsSelectAllEmploye() throws SQLException{
        String sqlSelectAllEmployes = "SELECT * FROM employes";
        String connectionUrl = "jdbc:mysql://localhost:3306/bdemployes?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(connectionUrl, "root", ""); 
        PreparedStatement ps = conn.prepareStatement(sqlSelectAllEmployes); 
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public static void deleteEmploye(int id) throws SQLException{
        String sqlDelEmploye = "DELETE FROM employes WHERE id=" + id ;
        String connectionUrl = "jdbc:mysql://localhost:3306/bdemployes?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(connectionUrl, "root", ""); 
        PreparedStatement ps = conn.prepareStatement(sqlDelEmploye); 
        ps.executeUpdate();
    }

    public static void addEmploye(String nom, String prenom, String dateEmbauche, String fonction, Float salaireBrut, String service, String agence, int enfant0_10, int enfant11_15, int enfant16_18) throws SQLException{
        String sqlAddEmploye = "INSERT INTO employes (nom, prenom, dateEmbauche, fonction, salaireBrut, service, agence, nbEnfant0_10, nbEnfant11_15, nbEnfant16_18) VALUES (\"" + nom + "\", \"" + prenom + "\", \"" + dateEmbauche + "\", \"" + fonction + "\", \"" + salaireBrut + "\", \"" + service + "\", \"" + agence + "\", " + enfant0_10 + ", " + enfant11_15 + ", " + enfant16_18 + ")"  ;
        String connectionUrl = "jdbc:mysql://localhost:3306/bdemployes?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(connectionUrl, "root", ""); 
        PreparedStatement ps = conn.prepareStatement(sqlAddEmploye); 
        ps.executeUpdate();
    }

    public static void modifyEmploye(int id, String nom, String prenom, String dateEmbauche, String fonction, Float salaireBrut, String service, String agence, int enfant0_10, int enfant11_15, int enfant16_18) throws SQLException{
        String sqlModEmploye = "UPDATE employes SET nom = \"" + nom + "\", prenom = \"" + prenom + "\", dateEmbauche = \"" + dateEmbauche + "\", fonction = \"" + fonction + "\", salaireBrut = \"" + salaireBrut + "\", service = \"" + service + "\", agence = \"" + agence + "\", nbEnfant0_10 = \"" + enfant0_10 + "\", nbEnfant11_15 = \"" + enfant11_15 + "\", nbEnfant16_18 = \"" + enfant16_18 + "\" WHERE id = " + id;
        String connectionUrl = "jdbc:mysql://localhost:3306/bdemployes?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(connectionUrl, "root", ""); 
        PreparedStatement ps = conn.prepareStatement(sqlModEmploye); 
        ps.executeUpdate();
    }


    
}
