/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.iservices;

import edu.esprit.outdoors.models.Publication;
import edu.esprit.outdoors.models.Utilisateurs;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author WILLIAM
 */
public interface IPublication <PU> {
    
    void add(PU pu);

    String getPrenomByIDprf(int idProfil);
    
    String getNomByIDprf(int idProfil);
    
    ObservableList<PU> DisplayAll();
    
    ObservableList<PU> ListePubOfProfil(int idProfil);

    void update(String text,int id);

    void delete(int id);
    
    Publication getById(Integer id);
    
}
