/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Entities.Employee;
import Services.gererEmpolyee;
import Services.gererEquipe;
import Services.gererTache;
import static Services.gererTache.ajouterTache;
import Utils.DBConnexion;
import Services.gererEquipe;
import static Services.gererEquipe.ajouterEquipe;



/**
 *
 * @author Moemen
 */
public class MainClass {
    public static void main(String[] args) {
        DBConnexion DBC;
        DBC = new DBConnexion();
        Employee emp1 = new Employee("zaghbib", "moemen", "moemen.zaghbib@esprit.tn", "11410515", "moemen1");
        ajouterTache(1, "hoho", "hehe", "huhu");
        gererTache.modifiertache(1, "DONE");
       /* gererTache.supprimerdemande(1);*/
        ajouterEquipe(1, "hihihahaha");
        
        gererEmpolyee.ajouterEmployee(12345, "moemen", "hcin", "ull", "null");
    
    }

}
