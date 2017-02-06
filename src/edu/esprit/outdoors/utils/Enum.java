/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.utils;



/**
 *
 * @author ISLEM
 */
public class Enum {

   
    public static enum Gouvernorat {
            
            Ariana("Ariana"),
            Beja("Beja"),
            Ben_Arous("Ben Arous"),
            Bizerte("Bizerte"),
            Gabès("Gabès"),
            Gafsa("Gafsa"),
            Jendouba("Jendouba"),
            Kairouan("Kairouan"),
            Kasserine("Kasserine"),
            Kébili("Kébili"),
            Le_Kef("Le Kef"),
            Mahdia("Mahdia"),
            La_Manouba("La Manouba"),
            Medenine("Medenine"),
            Monastir("Monastir"),
            Nabeul("Nabeul"),
            Sfax("Sfax"),
           Sidi_Bouzid("Sidi Bouzid"),
           Siliana("Siliana"),
           Sousse("Sousse"),
           Tataouine("Tataouine"),
           Tozeur("Tozeur"),
           Tunis("Tunis"),
           Zaghouan("Zaghouan");

    private String displayName;

    Gouvernorat(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override 
    public String toString() { return displayName; }
}
        

    
}
