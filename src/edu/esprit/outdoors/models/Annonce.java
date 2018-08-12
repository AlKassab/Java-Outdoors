/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.models;


import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author ASUS I7
 */
public class Annonce {
    private int idAnnonce;
    private String nom;
    private String type;
    private String description;
    private float prix;
    private String datePub;
    private String dateModif;
    private String etat;
    private String image;
    private int idCurrentUser;

    public Annonce(String nom, String type, String description, float prix, String datePub, String dateModif, String etat, String image, int idCurrentUser) {
        
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.prix = prix;
        this.datePub = datePub;
        this.dateModif = dateModif;
        this.etat = etat;
        this.image = image;
        this.idCurrentUser = idCurrentUser;
    }

    public Annonce(int idAnnonce, String nom, String type, String description, float prix, String datePub, String dateModif, String etat, String image, int idCurrentUser) {
        this.idAnnonce = idAnnonce;
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.prix = prix;
        this.datePub = datePub;
        this.dateModif = dateModif;
        this.etat = etat;
        this.image = image;
        this.idCurrentUser = idCurrentUser;
    }

    public Annonce(String nom, String type, String description, float prix, String dateModif, String etat, String image) {
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.prix = prix;
        this.dateModif = dateModif;
        this.etat = etat;
        this.image = image;
    }

   

    
   
    

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }

    public String getDatePub() {
        return datePub;
    }

    public String getDateModif() {
        return dateModif;
    }

    public String getEtat() {
        return etat;
    }

    public String getImage() {
        return image;
    }

    public int getIdCurrentUser() {
        return idCurrentUser;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDatePub(String datePub) {
        this.datePub = datePub;
    }

    public void setDateModif(String dateModif) {
        this.dateModif = dateModif;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIdCurrentUser(int idCurrentUser) {
        this.idCurrentUser = idCurrentUser;
    }

    @Override
    public String toString() {
        return "Annonce{" + "idAnnonce=" + idAnnonce + ", nom=" + nom + ", type=" + type + ", description=" + description + ", prix=" + prix + ", datePub=" + datePub + ", dateModif=" + dateModif + ", etat=" + etat + ", image=" + image + ", idCurrentUser=" + idCurrentUser + '}';
    }

    
    
    
}
