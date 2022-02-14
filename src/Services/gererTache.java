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
public class gererTache {

        
    public gererTache() {
    }
    
   public static void ajouterTache(int num_tache,String nom_tache,String needed_time,String etat_tache)
    {
        PreparedStatement select;
         ResultSet resultat;
         PreparedStatement insert;
         try {
            select= new DBConnexion().getCnx().prepareStatement("Select * from tache where num_tache="+num_tache+"");
            resultat=select.executeQuery();
            if(!resultat.isBeforeFirst())
            {
                insert=new DBConnexion().getCnx().prepareStatement("INSERT INTO tache (num_tache,nom_tache,needed_time) values (?,?,?)");
                insert.setInt(1, num_tache);
                insert.setString(2, nom_tache);
                insert.setString(3, needed_time);
                
                insert.executeUpdate();
                System.out.println("tache ajoutee");
            }
            else
                 System.err.println("tache existe");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        
    }
   
    
   public static void modifiertache(int num_tache,String etat_tache)
    {
        PreparedStatement select;
        ResultSet resultat;
        PreparedStatement update;
        try {
             select= new DBConnexion().getCnx().prepareStatement("Select * from tache where num_tache="+num_tache+"");
            resultat=select.executeQuery();
            if(resultat.isBeforeFirst())
            {
                update=new DBConnexion().getCnx().prepareStatement("Update tache set etat_tache=? where num_tache=?" );
                
                update.setString(1, etat_tache);
                update.setInt(2, num_tache);
           
                update.executeUpdate();
                System.out.println("modification du tache effectué");
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
