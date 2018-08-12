/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.models;

import java.sql.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author WILLIAM
 */
public class Publication {
    
    private int id ;
    //private int id_profil;
    private String text;
    private Date date_creation;
    private Date date_modification;
    private Profil creator;

    public Publication(String text, Date date_creation, Profil creator) {
        this.text = text;
        this.date_creation = date_creation;
        this.creator = creator;
    }

    public Publication(String text, Profil creator) {
        this.text = text;
        this.creator = creator;
    }

    public Publication(int id, String text, Date date_creation, Date date_modification, Profil creator) {
        this.id = id;
        this.text = text;
        this.date_creation = date_creation;
        this.date_modification = date_modification;
        this.creator = creator;
    }


    public Publication() {
    }

    public Publication(int id) {
        this.id = id;
    }
    private final StringProperty string = new SimpleStringProperty();

    public String getString() {
        return string.get();
    }

    public void setString(String value) {
        string.set(value);
    }

    public StringProperty stringProperty() {
        return string;
    }

    public Profil getCreator() {
        return creator;
    }

    public void setCreator(Profil creator) {
        this.creator = creator;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", text=" + text + ", date_creation=" + date_creation + ", date_modification=" + date_modification + ", creator=" + creator + '}';
    }


   

    public Date getDate_creation() {
        return date_creation;
    }

    public Date getDate_modification() {
        return date_modification;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setDate_modification(Date date_modification) {
        this.date_modification = date_modification;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

  
   
    
    
}
