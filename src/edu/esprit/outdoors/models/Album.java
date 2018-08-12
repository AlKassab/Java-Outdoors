/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.models;

import java.sql.Date;
import javafx.scene.image.Image;

/**
 *
 * @author WILLIAM
 */
public class Album {
    
    private int id;
    private String titre;
    private String description;
    private Photo  photo;
    private Date date_creation;
    private int id_pr;

    public Album() {
    }

    public Album(Photo photo, int id_pr) {
        this.photo = photo;
        this.id_pr = id_pr;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Photo getPhoto() {
        return photo;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public int getId_pr() {
        return id_pr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setId_pr(int id_pr) {
        this.id_pr = id_pr;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_pr;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Album other = (Album) obj;
        if (this.id_pr != other.id_pr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Album{" + "titre=" + titre + ", description=" + description + ", date_creation=" + date_creation + '}';
    }
    
    
    
}
