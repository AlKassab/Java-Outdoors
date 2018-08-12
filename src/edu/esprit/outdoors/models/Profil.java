
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.models;


import java.util.List;
import java.util.Objects;
import javafx.scene.image.Image;

/**
 *
 * @author Admin
 */
public class Profil {
    
   private int id_pr; 
   private Image  photo_profil;
   private Image  photo_cover;
   private String detail;
   private String sexe;
   private String gouvernorat;
   private long tel;
   private Album album;
   List<Publication> publication;
   private int id_u;
   private Utilisateurs user;

    public Profil() {
    }

    public Utilisateurs getUser() {
        return user;
    }

    public void setUser(Utilisateurs user) {
        this.user = user;
    }

    public Profil(int id_pr, String nom_complet, String gouvernorat) {
        this.id_pr = id_pr;
        this.gouvernorat = gouvernorat;
    }

    public Profil(int id_pr, String nom_complet, Image photo_profil, Image photo_cover, String detail, String sexe, String gouvernorat, long tel, Album album, int id_u) {
        this.id_pr = id_pr;
        this.photo_profil = photo_profil;
        this.photo_cover = photo_cover;
        this.detail = detail;
        this.sexe = sexe;
        this.gouvernorat = gouvernorat;
        this.tel = tel;
        this.album = album;
        this.id_u = id_u;
    }

    public int getId_pr() {
        return id_pr;
    }


    public Image getPhoto_profil() {
        return photo_profil;
    }

    public Image getPhoto_cover() {
        return photo_cover;
    }

    public String getDetail() {
        return detail;
    }

    public String getSexe() {
        return sexe;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public long getTel() {
        return tel;
    }

    public Album getAlbum() {
        return album;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_pr(int id_pr) {
        this.id_pr = id_pr;
    }


    public void setPhoto_profil(Image photo_profil) {
        this.photo_profil = photo_profil;
    }

    public void setPhoto_cover(Image photo_cover) {
        this.photo_cover = photo_cover;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public void setPublication(List<Publication> publication) {
        this.publication = publication;
    }

    public List<Publication> getPublication() {
        return publication;
    }

    
    
   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profil other = (Profil) obj;
        if (this.id_pr != other.id_pr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profil{" + "id_pr=" + id_pr  + ", photo_profil=" + photo_profil + ", photo_cover=" + photo_cover + ", detail=" + detail + ", sexe=" + sexe + ", gouvernorat=" + gouvernorat + ", tel=" + tel + ", album=" + album + ", id_u=" + id_u + '}';
    }
   
   

    
   
           
}
