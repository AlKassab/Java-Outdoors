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
public class Actualites {
   private int id_ac;
   private String titre;
    private String conseil;

    public Actualites(int id_ac, String titre, String conseil) {
        this.id_ac = id_ac;
        this.titre = titre;
        this.conseil = conseil;
    }

    public String getConseil() {
        return conseil;
    }
    public String getTitre() {
        return titre;
    }

    
    public int getId_ac() {
        return id_ac;
    }

    public void setId_ac(int id_ac) {
        this.id_ac = id_ac;
    }

    public void setConseil(String conseil) {
        this.conseil = conseil;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    
}
