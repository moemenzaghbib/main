/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Moemen
 */
public class Equipe {
    int id_equipe;
    int num_equipe;
    String role_equipe;
    int nbre_emp;

    public int getId_equipe() {
        return id_equipe;
    }


    public int getNom_equipe() {
        return num_equipe;
    }

    public void setNom_equipe(int num_equipe) {
        this.num_equipe = num_equipe;
    }

    public String getRole_equipe() {
        return role_equipe;
    }

    public void setRole_equipe(String role_equipe) {
        this.role_equipe = role_equipe;
    }

    public int getNbre_emp() {
        return nbre_emp;
    }

    public void setNbre_emp(int nbre_emp) {
        this.nbre_emp = nbre_emp;
    }

    @Override
    public String toString() {
        return "Equipe{" + "id_equipe=" + id_equipe + ", num_equipe=" + num_equipe + ", role_equipe=" + role_equipe + ", nbre_emp=" + nbre_emp + '}';
    }

    public Equipe(int num_equipe, String role_equipe, int nbre_emp) {
        this.num_equipe = num_equipe;
        this.role_equipe = role_equipe;
        this.nbre_emp = nbre_emp;
    }
    
    
    
    
    
}
