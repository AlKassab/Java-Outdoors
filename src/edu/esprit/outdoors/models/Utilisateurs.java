/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.models;

import edu.esprit.outdoors.utils.Enum.Gouvernorat;

/**
 *
 * @author Admin
 */
public class Utilisateurs {
    
     private int id_user;
     private String email;
     private String mot_passe;
     private String id_Ut;
     private Profil profil;

    public Utilisateurs(int id_user, String email, String mot_passe, String id_Ut, Profil profil) {
        this.id_user = id_user;
        this.email = email;
        this.mot_passe = mot_passe;
        this.id_Ut = id_Ut;
        this.profil = profil;
    }

    public Utilisateurs(String id_Ut, Profil profil) {
        this.id_Ut = id_Ut;
        this.profil = profil;
    }

    public int getId_user() {
        return id_user;
    }

    public Profil getProfil() {
        return profil;
    }
     
    
     public Utilisateurs(){
         
         this.profil = new Profil();         
    }
     
    public String getEmail() {
        return email;
    }

    public String getMot_passe() {
        return mot_passe;
    }

    public String getId_Ut() {
        return id_Ut;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }

    public void setId_Ut(String id_Ut) {
        this.id_Ut = id_Ut;
    }
     
     
     
     
    
}
