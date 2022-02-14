/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.DBConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Moemen
 */
public class gererEquipe {


    public gererEquipe() {
    }
    
   public static void ajouterEquipe(int num_equipe,String role_equipe)
    {
        PreparedStatement select;
         ResultSet resultat;
         PreparedStatement insert;
         try {
            select= new DBConnexion().getCnx().prepareStatement("Select * from equipe where num_equipe="+num_equipe+"");
            resultat=select.executeQuery();
            if(!resultat.isBeforeFirst())
            {
                insert=new DBConnexion().getCnx().prepareStatement("INSERT INTO equipe (num_equipe,role_equipe) values (?,?)");
                insert.setInt(1, num_equipe);
                insert.setString(2, role_equipe);
                
                insert.executeUpdate();
                System.out.println("equipe ajoutee");
            }
            else
                 System.err.println("equipe existe");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        
    }
   
    
   public static void modifierEquipe(int num_equipe,String role_equipe)
    {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement update;
        try {
             select= new DBConnexion().getCnx().prepareStatement("Select * from tache where num_tache="+num_equipe+"");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
                update=new DBConnexion().getCnx().prepareStatement("Update tache set role_equipe=? where num_equipe=?" );
                
                update.setString(1, role_equipe);
                update.setInt(2, num_equipe);
           
                update.executeUpdate();
                System.out.println("modification d'equipe effectué");
            }
            else
                System.err.println("erreur ");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
   
   
   
     public static void supprimerEquipe(int num_equipe)
    {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement delete;
         try {
            select= new DBConnexion().getCnx().prepareStatement("Select * from equipe where num_equipe="+num_equipe+"");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
                delete=new DBConnexion().getCnx().prepareStatement("Delete from equipe where num_equipe='"+num_equipe+"'");
                delete.executeUpdate();
                System.out.println("equipe supprimee");
            }
            else
                 System.err.println("failed");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        
    }
}
    
    
    
    

