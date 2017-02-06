/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.iservices;

import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Utilisateurs;
import java.util.List;

/**
 *
 * @author WILLIAM
 */
public interface IUtilisateurs <T> {
    
    void add(T t,Profil p);
    Utilisateurs Authentication(String login, String password);
    List<T> DisplayAll();
    void HomeView(T u);
}
