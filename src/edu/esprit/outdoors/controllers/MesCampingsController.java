/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXListView;
import edu.esprit.outdoors.models.Camping;
import edu.esprit.outdoors.services.CampingService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Ahmed Samti
 */
public class MesCampingsController implements Initializable {

    /**
     * Initializes the controller class.
     */
         @FXML
    private Label nombreRslt;

    @FXML
    private TextField search;

    @FXML
    private JFXListView<Camping> listCamp;
    
    CampingService cs= new CampingService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
       
      nombreRslt.setText(String.valueOf(listCamp.getItems().size()));
        listCamp.setItems(cs.DisplayAllbyuser(AuthentificationController.user.getId_user()));
   
        listCamp.setCellFactory(new Callback<ListView<Camping>, ListCell<Camping>>() {

                             @Override
                             public ListCell<Camping> call(ListView<Camping> listC ) {
                                
                             return new ListCell<Camping>(){
                             
                                 @Override
                    protected void updateItem(Camping item, boolean bln) {
 
                           super.updateItem(item, bln);
                        if (item != null) {
                            
                            
                            
                            //---------------
                            Region space =  new Region();
                            space.setPrefSize(180.0, USE_PREF_SIZE);
                           
                           
                            //---------------
                            
                            ///------------------------
                           
                            Hyperlink name= new Hyperlink(item.getNom());
                            name.setStyle(" -fx-text-fill: #81aa2a;" +
                                          " -fx-font-size: 17px;" +
                                          " -fx-font-weight: bold;");
                            name.setPrefSize(140, USE_PREF_SIZE);
                            Label date= new Label(String.valueOf(item.getDate()));
                            date.setStyle(" -fx-text-fill: #aacc63;" +
                                          " -fx-font-size: 17px;");
                            date.setPrefSize(140.0, USE_PREF_SIZE);
                            Label lieu= new Label(item.getLieu());
                            lieu.setStyle(" -fx-text-fill: #aacc63;" +
                                          " -fx-font-size: 17px;");
                            lieu.setPrefSize(140.0, USE_PREF_SIZE);
                            //--------------------------
                          
                            //-------------------
                           
                            VBox part1= new VBox(name,lieu);
                            part1.setSpacing(10.0);
                   
                            //--------------
                            HBox container = new HBox(part1,space,date);
                            setGraphic(container);
                            
                            ////-----
                            listCamp.refresh();
                            
                            
  }
                    }
                             
                             };
                             }
                         });
        
        search.textProperty().addListener((observable, oldValue, newValue) -> {
           
          nombreRslt.setText(String.valueOf(listCamp.getItems().size()));
        listCamp.setItems(cs.SearchByName(newValue,AuthentificationController.user.getId_user()));
   
        listCamp.setCellFactory(new Callback<ListView<Camping>, ListCell<Camping>>() {

                             @Override
                             public ListCell<Camping> call(ListView<Camping> listC ) {
                                
                             return new ListCell<Camping>(){
                             
                                 @Override
                    protected void updateItem(Camping item, boolean bln) {
 
                           super.updateItem(item, bln);
                        if (item != null) {
                            
                            
                            
                            //---------------
                            Region space =  new Region();
                            space.setPrefSize(180.0, USE_PREF_SIZE);
                           
                           
                            //---------------
                            
                            ///------------------------
                           
                            Hyperlink name= new Hyperlink(item.getNom());
                            name.setStyle(" -fx-text-fill: #81aa2a;" +
                                          " -fx-font-size: 17px;" +
                                          " -fx-font-weight: bold;");
                            name.setPrefSize(255, USE_PREF_SIZE);
                            Label date= new Label(String.valueOf(item.getDate()));
                            date.setStyle(" -fx-text-fill: #aacc63;" +
                                          " -fx-font-size: 17px;");
                            date.setPrefSize(140.0, USE_PREF_SIZE);
                            Label lieu= new Label(item.getLieu());
                            lieu.setStyle(" -fx-text-fill: #aacc63;" +
                                          " -fx-font-size: 17px;");
                            lieu.setPrefSize(140.0, USE_PREF_SIZE);
                            //--------------------------
                          
                            //-------------------
                           
                            VBox part1= new VBox(name,lieu);
                            part1.setSpacing(10.0);
                   
                            //--------------
                            HBox container = new HBox(part1,space,date);
                            setGraphic(container);
                            
                            ////-----
                            listCamp.refresh();
                            name.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        System.out.println("nananna");
        
         try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/AjoutInvités.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
          /*FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            AnchorPane p = fxmlLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/AjoutInvités.fxml").openStream());
        } catch (IOException ex) {
            Logger.getLogger(MesCampingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
          AjoutInvitésController AjoutC = (AjoutInvitésController) fxmlLoader.getController();
          cs.addCamper(item, AjoutC.getUtilisateurs());*/
    }
});
                            
  }
                    }
                             
                             };
                             }
                         });
    
});
       
                

    }    
    
}
