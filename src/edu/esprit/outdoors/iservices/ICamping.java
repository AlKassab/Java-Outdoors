/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.iservices;

import edu.esprit.outdoors.models.Camping;
import edu.esprit.outdoors.models.Etat;
import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Utilisateurs;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.util.Pair;

/**
 *
 * @author Ahmed Samti
 */
public interface ICamping {
    void add(Camping c);
    void addCamper(Camping c,Utilisateurs u);
    void update(int id,Utilisateurs U);
    void delete(Integer n);
    public List<Profil> getListUtilisateurs(int id);
    public List<Camping> getInvitations(int id);
    public List<Camping> getParticipations(int id);
   ObservableList<Camping> DisplayAll();
   ObservableList<Camping> DisplayAllbyuser(int idUser);
    ObservableList<Camping> SearchByName(String nom,int idUser);
   public void changeEtat(Etat etat,int id, Camping camping);
   public Camping getcampingbyId (int idcam);
    
}
