/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import edu.esprit.outdoors.models.Camping;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.services.CampingService;
import edu.esprit.outdoors.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author Ahmed Samti
 */
public class AjoutCampingController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public AjoutCampingController() {
    }
    
    @FXML
    private TextField nom;

    

    @FXML
    private TextField lieu;

    @FXML
    private DatePicker date;

    @FXML
    private TextArea description;

    @FXML
    private AnchorPane IDAnchorpane;

    
    CampingService cs = new CampingService();
    static Camping camping;
    
   
    
    @FXML
    void Enregistrement(ActionEvent event) {
         LocalDate ld= date.getValue();        
        Date dateCamp =Date.valueOf(ld);
        
        
        java.util.Date daa= new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
        java.sql.Date sDate1 = new java.sql.Date(daa.getTime());
        Camping c = new Camping();
       
        c.setNom(nom.getText());
        c.setDescription(description.getText());
        c.setLieu(lieu.getText());
        c.setDate(dateCamp);
        c.setOrganisateur(AuthentificationController.user);
        //c.setInvités(selected);
        
        cs.add(c);
       // cs.getidcamp();
        System.out.println(cs.getidcamp());
        camping = c;
        
        tray.notification.TrayNotification tr = new tray.notification.TrayNotification();
                tr.setTitle("Terminé");
                tr.setMessage("Ajouté avec succées" );
                tr.setNotificationType(NotificationType.SUCCESS);
                tr.setAnimationType(AnimationType.SLIDE);
                tr.showAndDismiss(Duration.seconds(2));
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/AjoutInvités.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    void Next(ActionEvent event) throws IOException {
        
//        // System.out.println(cs.getcampingbyId(camping.getId_camp()).getNom());
//         Utilisateurs potential = listU.getSelectionModel()
//          .getSelectedItem();
//      if (potential != null) {
//        listU.getSelectionModel().clearSelection();
//        UserS.DisplayAll().remove(potential);
//        selected.add(potential);
//        cs.addCamper(camping, potential);
//        listI.refresh();
//        listU.refresh();
//        
//      }
AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/MapApi.fxml")); 
        IDAnchorpane.getChildren().setAll(pane);
    }


    @FXML
    void dragDrop(DragEvent event) {

    }

    @FXML
    void dragOver(DragEvent event) {

    }

    @FXML
    void dragdetect(MouseEvent event) {

    }

    @FXML
    void dragdetect2(MouseEvent event) {

    }

    @FXML
    void dragdrop2(DragEvent event) {

    }

    @FXML
    void dragover2(DragEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        
//        listU.setItems(UserS.DisplayAll());
//      
//        listU.setCellFactory(new Callback<ListView<Utilisateurs>, ListCell<Utilisateurs>>() {
//            @Override
//            public ListCell<Utilisateurs> call(ListView<Utilisateurs> param) {
//           
//            return new ListCell<Utilisateurs>(){
//            
//                @Override
//                protected void updateItem(Utilisateurs item, boolean bln){
//                super.updateItem(item,bln);
//                
//                if(item!=null){
//                
//                   /* ImageView photprofl = new ImageView(item.getProfil().getPhoto_profil());
//                    photprofl.setFitWidth(45.0);
//                    photprofl.setFitHeight(45.0);*/
//                    Label nom = new Label(item.getId_Ut());
//                    
//                HBox hbox = new HBox (nom);
//                hbox.setSpacing(10);
//                
//                    setGraphic(hbox);
//                }
//                
//                }
//            
//            };
//            
//            }
//        });
//        
//       
//        listI.setItems(selected);
//        listI.setCellFactory(new Callback<ListView<Utilisateurs>, ListCell<Utilisateurs>>() {
//            @Override
//            public ListCell<Utilisateurs> call(ListView<Utilisateurs> param) {
//           
//            return new ListCell<Utilisateurs>(){
//            
//                @Override
//                protected void updateItem(Utilisateurs item, boolean bln){
//                super.updateItem(item,bln);
//              
//                if(item!=null){
//                
//                   /* ImageView photprofl = new ImageView(item.getProfil().getPhoto_profil());
//                    photprofl.setFitWidth(45.0);
//                    photprofl.setFitHeight(45.0);*/
//                   Label nom = new Label(item.getId_Ut());
//                    
//                HBox hbox = new HBox (nom);
//                hbox.setSpacing(10);
//                
//                    setGraphic(hbox);
//                }
//                
//                }
//            
//            };
//            
//            }
//        });
//       
        
        
    }    
    
}
