/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;


import edu.esprit.outdoors.services.AnnonceService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import edu.esprit.outdoors.models.Annonce;
import edu.esprit.outdoors.models.Feed;
import edu.esprit.outdoors.technique.HTTPXML;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Callback;
import javax.mail.FetchProfile;
/**
 * FXML Controller class
 *
 * @author ASUS I7
 */
public class MesAnnoncesController implements Initializable {

    @FXML
    private ListView<Annonce> listview;
    AnnonceService AS = new AnnonceService();
    @FXML
    private AnchorPane m1;
   static int i; 
  static int idAnSelected;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     listview.setItems(AS.selcetMesAnnonce(AuthentificationController.user.getId_user()));
    
        listview.setCellFactory(new Callback<ListView<Annonce>, ListCell<Annonce>>() {
            
            

                             @Override
                             public ListCell<Annonce> call(ListView<Annonce> listPub ) {
                                
                             return new ListCell<Annonce>(){
                             
                                 @Override
                    protected void updateItem(Annonce item, boolean bln) {
 
                           super.updateItem(item, bln);
                        if (item != null) {
                            
                            
                          
                             File f = new File(item.getImage());
                            Image img = new Image(f.toURI().toString());
                            ImageView imgprf  = new ImageView(img);
                            imgprf.setFitHeight(200);
                            imgprf.setFitWidth(200);
                          
                           
                            
                            
                            
                         
                           
                            Hyperlink name= new Hyperlink(item.getNom());
                            name.setStyle(" -fx-text-fill: #81aa2a;" +
                                          " -fx-font-size: 17px;" +
                                          " -fx-font-weight: bold;");
                            name.setPrefSize(140, USE_PREF_SIZE);
                            Region space =  new Region();
                            Button supprimer = new Button("supprimer");
                            supprimer.setPrefSize(100, 30);
                            Button modifier = new Button( "modifier ");
                            modifier.setPrefSize(100, 30);
                            supprimer.setStyle(" -fx-text-fill: white;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-background-color:#81aa2a;");
                            modifier.setStyle(" -fx-text-fill: white;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-background-color:#81aa2a;");
                            VBox containerButton = new VBox(supprimer,modifier);
                            containerButton.setSpacing(10.0);
                            
                         
                          
                          
                           HBox container = new HBox(imgprf,name,space,containerButton);

                            setGraphic(container);
                            
                            
                 supprimer.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    
                        Alert dialogC = new Alert(AlertType.CONFIRMATION);
                        dialogC.setTitle("Confirmer la suppression");
                        dialogC.setHeaderText(null);
                        dialogC.setContentText("Vous les vous supprimer votre annonce");
                        Optional<ButtonType> answer = dialogC.showAndWait();
                         if (answer.get() == ButtonType.OK) {
                             
                              int idAn= item.getIdAnnonce();
                  AS.delete(idAn); 
                   try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/MesAnnonces.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                           
                            }
                            else {
                            System.out.println("User chose Cancel or closed the dialog-box");
                            }
                   
                  
                  
                    
                }
            });
                            
                   modifier.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    
                      try {
                       
                   i=item.getIdAnnonce();
                    FXMLLoader fxmlLoader = new FXMLLoader();
Pane p = fxmlLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/modifierAnnonce.fxml").openStream());
ModifierAnnonceController ModC = (ModifierAnnonceController) fxmlLoader.getController();
                   m1.getChildren().add(p);
                  
                   ModC.setDesc(item.getDescription());
                    File f = new File(item.getImage());
                            Image imgA = new Image(f.toURI().toString());
                   ModC.setNewImg(imgA);
                   ModC.setNom(item.getNom());
                   ModC.setPrix(String.valueOf(item.getPrix()));
                   ModC.setUrl(item.getImage());
                   
                  
                   
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
                 
                    
                }
                
            });
                            
                            
  }
                    }
                             
                             };
                             }
                         });
        
         listview.setOnMousePressed(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent event) {
            if (event.isPrimaryButtonDown() && event.getClickCount()==2){
                idAnSelected= listview.getSelectionModel().getSelectedItem().getIdAnnonce();
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/InfoMonAnnonce.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
         }
     }
     
     );
       
     
        
    }    
    
}
