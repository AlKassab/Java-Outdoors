/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.models;

import java.sql.Date;
import java.util.Objects;
import javafx.scene.image.Image;

/**
 *
 * @author WILLIAM
 */
public class Photo extends Publication{
    
    private Image  photo;
    private int id_abum;


    public Photo() {
    }

    public Photo(String text, Profil creator) {
        super(text, creator);
    }
    
    

    public Photo(Image photo, int id_abum) {
        this.photo = photo;
        this.id_abum = id_abum;
    }

    public Photo(Image photo, int id_abum, int id) {
        super(id);
        this.photo = photo;
        this.id_abum = id_abum;
    }

    public Photo(Image photo, int id_abum, int id, String text, Date date_creation, Date date_modification, Profil creator) {
        super(id, text, date_creation, date_modification, creator);
        this.photo = photo;
        this.id_abum = id_abum;
    }

    public Photo(Image photo, int id, String text, Date date_creation, Date date_modification, Profil creator) {
        super(id, text, date_creation, date_modification, creator);
        this.photo = photo;
    }



    
   

    public Image getPhoto() {
        return photo;
    }

    public int getId_abum() {
        return id_abum;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public void setId_abum(int id_abum) {
        this.id_abum = id_abum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Photo other = (Photo) obj;
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        if (this.id_abum != other.id_abum) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Photo{" + "photo=" + photo + ", id_abum=" + id_abum + '}';
    }

   
    
    
}
