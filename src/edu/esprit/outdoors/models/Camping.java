/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;

/**
 *
 * @author Ahmed Samti
 */
public class Camping {
    private int id_camp;
    private String nom;
    private String lieu;
    private java.sql.Date date;
    private String description;
    private Utilisateurs organisateur;
    private List<Utilisateurs> Invités;
    private Etat etat;

    public Camping(String nom, String lieu, String description, Utilisateurs organisateur, List<Utilisateurs> Invités, Etat etat) {
        this.nom = nom;
        this.lieu = lieu;
        this.description = description;
        this.organisateur = organisateur;
        this.Invités = Invités;
        this.etat = etat;
    }

    public Camping(String nom, String lieu, java.sql.Date date, String description, Utilisateurs organisateur, List<Utilisateurs> Invités, Etat etat) {
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.description = description;
        this.organisateur = organisateur;
        this.Invités = Invités;
        this.etat = etat;
    }

    public Camping(String nom) {
        this.nom = nom;
    }

   
    public Camping() {
    }

    public Camping(int id_camp, String nom, String lieu, java.sql.Date date, String description, Utilisateurs organisateur, List<Utilisateurs> Invités, Etat etat) {
        this.id_camp = id_camp;
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.description = description;
        this.organisateur = organisateur;
        this.Invités = Invités;
        this.etat = etat;
    }

    public Camping(int id_camp, String nom, String lieu, java.sql.Date date, String description, Utilisateurs organisateur, List<Utilisateurs> Invités) {
        this.id_camp = id_camp;
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.description = description;
        this.organisateur = organisateur;
        this.Invités = Invités;
    }

    public Camping(String nom, String lieu, java.sql.Date date, String description, Utilisateurs organisateur, List<Utilisateurs> Invités) {
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.description = description;
        this.organisateur = organisateur;
        this.Invités = Invités;
    }

    public int getId_camp() {
        return id_camp;
    }

    public String getNom() {
        return nom;
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

    public Utilisateurs getOrganisateur() {
        return organisateur;
    }

    public List<Utilisateurs> getInvités() {
        return Invités;
    }
     public Etat getEtat() {
        return etat;
    }



    public void setId_camp(int id_camp) {
        this.id_camp = id_camp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrganisateur(Utilisateurs organisateur) {
        this.organisateur = organisateur;
    }

    public void setInvités(List<Utilisateurs> Invités) {
        this.Invités = Invités;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
    

    @Override
    public String toString() {
        return "Camping{" + "id_camp=" + id_camp + ", nom=" + nom + ", lieu=" + lieu + ", date=" + date + ", description=" + description + ", organisateur=" + organisateur + ", Invit\u00e9s=" + Invités + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id_camp;
        hash = 67 * hash + Objects.hashCode(this.nom);
        hash = 67 * hash + Objects.hashCode(this.lieu);
        hash = 67 * hash + Objects.hashCode(this.date);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.organisateur);
        hash = 67 * hash + Objects.hashCode(this.Invités);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Camping other = (Camping) obj;
        if (this.id_camp != other.id_camp) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.organisateur, other.organisateur)) {
            return false;
        }
        if (!Objects.equals(this.Invités, other.Invités)) {
            return false;
        }
        return true;
    }

   
}
