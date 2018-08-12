/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.models;



/**
 *
 * @author Admin
 */
public class Utilisateurs {
    
     private int id_user;
     private String email;
     private String mot_passe;
     private String id_Ut;
     private String nom;
     private String prenom;
     private Profil profil;
     private int money;

   
    public Utilisateurs(int id_user, String email, String mot_passe,String nom, String prenom, String id_Ut, Profil profil) {
        this.id_user = id_user;
        this.email = email;
        this.mot_passe = mot_passe;
        this.id_Ut = id_Ut;
        this.profil = profil;
         this.nom = nom;
        this.prenom = prenom;
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
 public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Utilisateurs{" + "id_user=" + id_user + ", email=" + email + ", mot_passe=" + mot_passe + ", id_Ut=" + id_Ut + ", profil=" + profil + '}';
    }
     
     public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
     
     
    
}
