/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Moemen
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Utils.DBConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Moemen
 */
public class gererEmpolyee {

        
    public gererEmpolyee() {
    }
    
   public static void ajouterEmployee(int cin, String nom, String prenom, String email, String mot_de_pass)
    {
        PreparedStatement select;
         ResultSet resultat;
         PreparedStatement insert;
         try {
            select= new DBConnexion().getCnx().prepareStatement("Select * from Empolyee where cin="+cin+"");
            resultat=select.executeQuery();
            if(!resultat.isBeforeFirst())
            {
                insert=new DBConnexion().getCnx().prepareStatement("INSERT INTO Empolyee (nom,prenom,email,cin,mot_de_pass) values (?,?,?,?,?)");
                insert.setString(1, nom);
                insert.setString(2, prenom);
                insert.setString(3, email);
                insert.setInt(4, cin);
                insert.setString(5,mot_de_pass);
                  
                
                insert.executeUpdate();
                System.out.println("Empolyee ajoutee");
            }
            else
                 System.err.println("Empolyee existe");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        
    }
   
    
   public static void modifiertache(int cin,String mot_de_pass)
    {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement update;
        try {
             select= new DBConnexion().getCnx().prepareStatement("Select * from Employee where cin="+cin+"");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
                update=new DBConnexion().getCnx().prepareStatement("Update Employee set mot_de_pass=? where cin=?" );
                
                update.setString(1, mot_de_pass);
                update.setInt(2, cin);
           
                update.executeUpdate();
                System.out.println("modification du Employee effectué");
            }
            else
                System.err.println("erreur ");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
   
   
   
     public static void supprimerdemande(int num_tache)
    {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement delete;
         try {
            select= new DBConnexion().getCnx().prepareStatement("Select * from tache where num_tache="+num_tache+"");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
                delete=new DBConnexion().getCnx().prepareStatement("Delete from tache where num_tache='"+num_tache+"'");
                delete.executeUpdate();
                System.out.println("tache supprimee");
            }
            else
                 System.err.println("failed");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        
    }
   
    
    
    
    
}

