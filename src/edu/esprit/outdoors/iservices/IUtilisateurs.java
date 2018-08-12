/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.iservices;

import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Utilisateurs;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author WILLIAM
 */
public interface IUtilisateurs<T, P> {

    void add(T t, P p);

    Utilisateurs Authentication(String login, String password);

    ObservableList<T> DisplayAll();

    void DeleteAccount(int id);
    
    void updateEmail(String newEmail ,Utilisateurs u);
    
    void updatepass(String newPass ,Utilisateurs u);
    
    void addwithfcb(Utilisateurs t,Profil p,String link);
    
    Utilisateurs Authenticationwithfacebook(String email);
    
    boolean checkforemail(String mail) throws SQLException;
    
    boolean checkforusername(String username) throws SQLException;
    
    Utilisateurs getById(Integer id);
    
    void findbyemail(String email);
    
    ObservableList<Utilisateurs> findbyusernameAndEmail(String username,String email);
    
    ObservableList<Utilisateurs> findbyname(String name);
}
