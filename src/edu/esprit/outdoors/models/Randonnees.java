/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author macbookpro
 */
public class Randonnees {
    private int id_ran;
    private String lieu;
    private Date date;
    private String description;
    private float prix;
    private String heure;
    private float kilometrage;
    private float altitude;
    private int nbr_randonneur;
    private String type;
    private String difficulte;
    private String organisateur;
    //private List<Avis> lst_avis;

    public Randonnees(int id_ran, String lieu, Date date, String description, float prix, String heure, float kilometrage, float altitude, int nbr_randonneur, String type, String difficulte, String organisateur) {
        this.id_ran = id_ran;
        this.lieu = lieu;
        this.date = date;
        this.description = description;
        this.prix = prix;
        this.heure = heure;
        this.kilometrage = kilometrage;
        this.altitude = altitude;
        this.nbr_randonneur = nbr_randonneur;
        this.type = type;
        this.difficulte = difficulte;
        this.organisateur=organisateur;
       // lst_avis=new ArrayList<Avis>();
    }

   

    public Randonnees() {
    }

   public Randonnees(String lieu, Date date, String description, float prix, String heure, float kilometrage, float altitude, int nbr_randonneur, String type, String difficulte, String organisateur) {
     
        this.lieu = lieu;
        this.date = date;
        this.description = description;
        this.prix = prix;
        this.heure = heure;
        this.kilometrage = kilometrage;
        this.altitude = altitude;
        this.nbr_randonneur = nbr_randonneur;
        this.type = type;
        this.difficulte = difficulte;
        this.organisateur=organisateur;
     
    }
   

    

    public Randonnees(int id_ran,String lieu, Date date, String description, float prix, String heure, float kilometrage, float altitude, int nbr_randonneur, String organisateur) {
        this.id_ran=id_ran;
        this.lieu = lieu;
        this.date = date;
        this.description = description;
        this.prix = prix;
        this.heure = heure;
        this.kilometrage = kilometrage;
        this.altitude = altitude;
        this.nbr_randonneur = nbr_randonneur;
        this.organisateur=organisateur;
    }

    public Randonnees(int i, String sfax) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Randonnees(int aInt, String string, java.sql.Date date, String string0, float aFloat, float aFloat0, float aFloat1, float aFloat2, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Randonnees(int id, String value, java.sql.Date valueOf, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

    /*public List<Avis> getLst_avis() {
        return lst_avis;
    }*/

    public int getNb_randonneur() {
        return nbr_randonneur;
    }

    public String getLieu() {
        return lieu;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }

    public String getHeure() {
        return heure;
    }

    public float getKilometrage() {
        return kilometrage;
    }

    public float getAltitude() {
        return altitude;
    }

    public String getType() {
        return type;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public int getId_ran() {
        return id_ran;
    }
     public String getOrganisateur() {
        return organisateur;
    }


    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setKilometrage(float kilometrage) {
        this.kilometrage = kilometrage;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public void setId_ran(int id_ran) {
        this.id_ran = id_ran;
    }

    public void setNb_randonneur(int nbr_randonneur) {
        this.nbr_randonneur = nbr_randonneur;
    }
     public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    @Override
    public String toString() {
        return "Randonnees{" + "id_ran=" + id_ran + ", lieu=" + lieu + ", date=" + date + ", description=" + description + ", prix=" + prix + ", heure=" +heure + ", kilometrage=" + kilometrage + ", altitude=" + altitude + ", nbr_randonneur=" + nbr_randonneur + ", type=" + type + ", difficulte=" + difficulte +", organisateur=" + organisateur +'}';
    }
    
    
}

