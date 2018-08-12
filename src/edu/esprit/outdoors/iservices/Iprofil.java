/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.iservices;

import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Publication;
import edu.esprit.outdoors.models.Utilisateurs;
import java.io.File;
import javafx.collections.ObservableList;

/**
 *
 * @author WILLIAM
 */
public interface Iprofil {
    
    Profil getInfoFormProfil (int id_user);
    void insertImageToDb(File file,Profil p );
    void insertcoverToDb(File file,Profil p );
    Profil getprofilByID(int idProfil);
    ObservableList<Profil> findbyname(String name);
    void updateTel(long newTel ,Profil p);
    void updateInfo(String newInfo ,Profil p);
    void updateGov(String newGov ,Profil p);
    void updatename(String newName ,Utilisateurs u);
    void updatefirstname(String newName ,Utilisateurs u);
    
}
