
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
public class Profil {
   private String nom;
   private String prenom;
   private String path_Photo;
   private String detail;
   private String sexe;
   private Gouvernorat gouvernorat;
   private long tel;
   private int id_pr;

    public Profil() {
        
    }
   

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPath_Photo() {
        return path_Photo;
    }

    public String getDetail() {
        return detail;
    }

    public String getSexe() {
        return sexe;
    }

    public Gouvernorat getGouvernorat() {
        return gouvernorat;
    }

    public long getTel() {
        return tel;
    }

    public int getId_pr() {
        return id_pr;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPath_Photo(String path_Photo) {
        this.path_Photo = path_Photo;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setGouvernorat(Gouvernorat gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public void setId_pr(int id_pr) {
        this.id_pr = id_pr;
    }

   
   
           
}
