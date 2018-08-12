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
public class Message {
    private int id_msg;
    private String contenu;
    private String destinataire;
    private String expediteur;
    

    public Message(String contenu, String destinataire, String expediteur) {
        this.contenu = contenu;
        this.destinataire = destinataire;
        this.expediteur = expediteur;
    }

    public int getId_msg() {
        return id_msg;
    }

    public String getContenu() {
        return contenu;
    }
    public String getDestinataire() {
        return destinataire;
    }
    
    public String getExpediteur() {
        return expediteur;
    }

    public void setId_msg(int id_msg) {
        this.id_msg = id_msg;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
    
    
}
