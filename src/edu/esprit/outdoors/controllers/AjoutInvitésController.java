/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXListView;
import edu.esprit.outdoors.models.Camping;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.services.CampingService;
import edu.esprit.outdoors.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Ahmed Samti
 */
public class AjoutInvitésController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXListView<Utilisateurs> listU;

    @FXML
    private JFXListView<Utilisateurs> listI;
    
     CampingService cs = new CampingService();
    UserService UserS = new UserService();
    final ObservableList<Utilisateurs> selected = FXCollections.observableArrayList();
     Utilisateurs utilisateurs= new Utilisateurs();
    public void setutilisateur(Utilisateurs u){
        
        u= utilisateurs;
    }
            
    public Utilisateurs getUtilisateurs() {
     return utilisateurs;
    }
   

    @FXML
    void Next(ActionEvent event) throws IOException {
      Utilisateurs potential = listU.getSelectionModel()
          .getSelectedItem();
      
       System.out.println(cs.getcampingbylastId());
      if (potential != null) {
        listU.getSelectionModel().clearSelection();
        UserS.DisplayAll().remove(potential);
        
        Camping c = cs.getcampingbyId(AjoutCampingController.camping.getId_camp());
       //  System.out.println(c.getNom());
        selected.add(potential);
        setutilisateur(potential);
        
        cs.addCamper(c, potential);
    
        //cs.addCamper(AjoutC.getCamping(), potential);
        listI.refresh();
        listU.refresh();
        
    }
    }
    @FXML
    void Precedent(ActionEvent event) {
try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/AjoutCamping.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    void Previous(ActionEvent event) {
    Utilisateurs s = listI.getSelectionModel().getSelectedItem();
      if (s != null) {
        listI.getSelectionModel().clearSelection();
        selected.remove(s);
        UserS.DisplayAll().add(s);
         listI.refresh();
        listU.refresh();
    }
    }
    @FXML
    void Suivant(ActionEvent event) {

                
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           listU.setItems(UserS.DisplayAll());
      
        listU.setCellFactory(new Callback<ListView<Utilisateurs>, ListCell<Utilisateurs>>() {
            @Override
            public ListCell<Utilisateurs> call(ListView<Utilisateurs> param) {
           
            return new ListCell<Utilisateurs>(){
            
                @Override
                protected void updateItem(Utilisateurs item, boolean bln){
                super.updateItem(item,bln);
                
                if(item!=null){
                
                   /* ImageView photprofl = new ImageView(item.getProfil().getPhoto_profil());
                    photprofl.setFitWidth(45.0);
                    photprofl.setFitHeight(45.0);*/
                    Label nom = new Label(item.getId_Ut());
                    
                HBox hbox = new HBox (nom);
                hbox.setSpacing(10);
                
                    setGraphic(hbox);
                }
                
                }
            
            };
            
            }
        });
        
       
        listI.setItems(selected);
        listI.setCellFactory(new Callback<ListView<Utilisateurs>, ListCell<Utilisateurs>>() {
            @Override
            public ListCell<Utilisateurs> call(ListView<Utilisateurs> param) {
           
            return new ListCell<Utilisateurs>(){
            
                @Override
                protected void updateItem(Utilisateurs item, boolean bln){
                super.updateItem(item,bln);
              
                if(item!=null){
                
                   /* ImageView photprofl = new ImageView(item.getProfil().getPhoto_profil());
                    photprofl.setFitWidth(45.0);
                    photprofl.setFitHeight(45.0);*/
                   Label nom = new Label(item.getId_Ut());
                    
                HBox hbox = new HBox (nom);
                hbox.setSpacing(10);
                
                    setGraphic(hbox);
                }
                
                }
            
            };
            
            }
        });
       
        
    }    
    
}
    
