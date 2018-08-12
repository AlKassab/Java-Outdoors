/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXListView;
import edu.esprit.outdoors.models.Randonnees;
import edu.esprit.outdoors.services.RandoService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class mesRandoController implements Initializable {

    @FXML
    private Label nombreRslt;
    @FXML
    private TextField search;
    @FXML
    private JFXListView<Randonnees> listR;
    @FXML
    private ToggleButton abonnemnt;
    @FXML
    private ToggleGroup choix;
    @FXML
    private ToggleButton abonne;
    @FXML
    private ToggleButton explore;
    RandoService rs= new RandoService();
    public static Randonnees rr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          listR.setItems(rs.getMine());
        //listUser.refresh();
        
        nombreRslt.setText(String.valueOf(listR.getItems().size()));
        listR.setCellFactory(new Callback<ListView<Randonnees>, ListCell<Randonnees>>() {

                             @Override
                             public ListCell<Randonnees> call(ListView<Randonnees> listPub ) {
                                
                             return new ListCell<Randonnees>(){
                             
                                 @Override
                    protected void updateItem(Randonnees item, boolean bln) {
 
                           super.updateItem(item, bln);
                        if (item != null) {
                            rr=item;
                            
                            
                            
                            //---------------
                            Region space =  new Region();
                            space.setPrefSize(20.0, USE_PREF_SIZE);
                            Region space3 =  new Region();
                            space.setPrefSize(USE_PREF_SIZE, 5.0);
                            Region space1 =  new Region();
                            Region space2 =  new Region();
                            Region space4 =  new Region();
                            Region space5 =  new Region();
                            Separator separator1 = new Separator();
                            Separator separator2 = new Separator();
                            
                           
                            //---------------
                            
                            //ImageView imgprf  = new ImageView(item.getCreator().getPhoto_profil());
                            Image valide1= new Image("/edu/esprit/outdoors/resource/verified.png");
                            ImagePattern imagepattern = new ImagePattern(valide1);
                            
                            Circle cicleofimage = new Circle();
                            cicleofimage.setFill(imagepattern);
                            cicleofimage.setRadius(50.0);
                            cicleofimage.setStroke(Color.WHITE);
                            cicleofimage.setStrokeWidth(5.0);
                            //imgprf.setFitHeight(45.0);
                            //imgprf.setFitWidth(45.0);
                           
                            ///-----------------------------------
//                            Image valide= new Image("/edu/esprit/outdoors/resource/verified.png");
//                            ImageView valideview  = new ImageView();
//                            valideview.setImage(valide);
//                            valideview.setFitHeight(20);
//                            valideview.setFitWidth(20);
//                            
//                            ImageView guideview  = new ImageView();
//                            Image guideicon= new Image("/edu/esprit/outdoors/resource/guide.png");
//                            guideview.setImage(guideicon);
//                            guideview.setFitHeight(25);
//                            guideview.setFitWidth(25);
//                            
//                            Image star= new Image("/edu/esprit/outdoors/resource/star.png");
//                            ImageView oneS  = new ImageView(star);
//                            ImageView towS  = new ImageView(star);
//                            ImageView threeS  = new ImageView(star);
//                            ImageView fourS  = new ImageView(star);
//                            ImageView fiveS  = new ImageView(star);
//                            oneS.setFitHeight(15);
//                            oneS.setFitWidth(15);
//                            towS.setFitHeight(15);
//                            towS.setFitWidth(15);
//                            threeS.setFitHeight(15);
//                            threeS.setFitWidth(15);
//                            fourS.setFitHeight(15);
//                            fourS.setFitWidth(15);
//                            fiveS.setFitHeight(15);
//                            fiveS.setFitWidth(15);
//                             
                            ///------------------------
                            Hyperlink name= new Hyperlink(item.getLieu());
                            name.setStyle(" -fx-text-fill: #81aa2a;" +
                                          " -fx-font-size: 17px;" +
                                          " -fx-font-weight: bold;");
                            name.setPrefSize(140, USE_PREF_SIZE);
                            Label gov= new Label(item.getDate().toString());
                            gov.setStyle(" -fx-text-fill: #aacc63;" +
                                          " -fx-font-size: 17px;");
                            gov.setPrefSize(140.0, USE_PREF_SIZE);
                            //--------------------------
                            
                            ///-----------------------------
                            
                            ToggleButton modif = new ToggleButton("Modifier");
                            modif.setPrefSize(160.0,30.0);
                            modif.setStyle(" -fx-text-fill: white;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-background-color:#81aa2a;");
                            ToggleButton supp = new ToggleButton("Supprimer");
                            supp.setPrefSize(160.0,30.0);
                            supp.setStyle(" -fx-text-fill: white;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-background-color:#81aa2a;");
                            //------------------------------
                          
                            //-------------------
                            //HBox rating = new HBox(oneS,towS,threeS,fourS,fiveS);
                            HBox nameAndAccount = new HBox(name);
                            nameAndAccount.setSpacing(10.0);
                            HBox part1 = new HBox(space,cicleofimage);
                            VBox part2= new VBox(space3,nameAndAccount,gov);
                            part2.setSpacing(5.0);
                            //--------------
                            VBox btn= new VBox(modif,space,supp);
                            HBox containerNoSeperator = new HBox(part1,part2,space1,btn);
                            containerNoSeperator.setSpacing(15.0);
                            HBox.setHgrow(space1, Priority.ALWAYS);
                            VBox containerwithSeprator = new VBox(separator1,containerNoSeperator,separator2);
                            //VBox fn= new VBox(follow,space5,prix);
                            //HBox fin= new HBox(containerwithSeprator);
                
                            
                            
                            setGraphic(containerwithSeprator);
                            
                            ///// code ////
                            
                            
                            name.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                try {
                                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/ajoutRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                                } catch (IOException ex) {
                                    Logger.getLogger(MembreController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            });
                                supp.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    rs.delete(item);
                                    System.out.println("delete****");
                               }
                            });
                            modif.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                     System.out.println("modif****");
                                       try {
                                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/modifRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                                } catch (IOException ex) {
                                    Logger.getLogger(MembreController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                }
                            });
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
  }
                    }
                             
                             };
                             }
                         });
                
                choix.selectToggle(explore);
                   abonnemnt.setStyle("-fx-background-color:#757575;-fx-effect: null;");
                   abonne.setStyle("-fx-background-color:#757575;-fx-effect: null;");
                   explore.setStyle("-fx-background-color:rgb(129, 170, 42);-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.5),10,0.0,0.0,0.0);");
        
             choix.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (abonnemnt.isSelected()){
                abonne.setStyle("-fx-background-color:#757575;-fx-effect: null;");
                explore.setStyle("-fx-background-color:#757575;-fx-effect: null;");
                abonnemnt.setStyle("-fx-background-color:rgb(129, 170, 42);-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.5),10,0.0,0.0,0.0);");
                
            }
            if (abonne.isSelected()){
                abonnemnt.setStyle("-fx-background-color:#757575;-fx-effect: null;");
                explore.setStyle("-fx-background-color:#757575;-fx-effect: null;");
                abonne.setStyle("-fx-background-color:rgb(129, 170, 42);-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.5),10,0.0,0.0,0.0);");
                
            }
            if (explore.isSelected()){
                abonnemnt.setStyle("-fx-background-color:#757575;-fx-effect: null;");
                abonne.setStyle("-fx-background-color:#757575;-fx-effect: null;");
                explore.setStyle("-fx-background-color:rgb(129, 170, 42);-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.5),10,0.0,0.0,0.0);");
                
            }
        });
        
    
 
           
   
        
       search.textProperty().addListener((observable, oldValue, newValue) -> {
           
           nombreRslt.setText(String.valueOf(listR.getItems().size()));
           
           
      listR.refresh();
      
        listR.setItems(rs.RechercherMine(newValue));
   
        listR.setCellFactory(new Callback<ListView<Randonnees>, ListCell<Randonnees>>() {

                             @Override
                             public ListCell<Randonnees> call(ListView<Randonnees> listPub ) {
                                
                             return new ListCell<Randonnees>(){
                             
                                 @Override
                    protected void updateItem(Randonnees item, boolean bln) {
 
                           super.updateItem(item, bln);
                        if (item != null) {
                            
                            
                            
                            //---------------
                            Region space =  new Region();
                            space.setPrefSize(20.0, USE_PREF_SIZE);
                            Region space3 =  new Region();
                            space.setPrefSize(USE_PREF_SIZE, 5.0);
                            Region space1 =  new Region();
                            Separator separator1 = new Separator();
                            Separator separator2 = new Separator();
                           
                            //---------------
                            
                            //ImageView imgprf  = new ImageView(item.getCreator().getPhoto_profil());
                            Image valide1= new Image("/edu/esprit/outdoors/resource/verified.png");
                            ImagePattern imagepattern = new ImagePattern(valide1);
                            
                            Circle cicleofimage = new Circle();
                            cicleofimage.setFill(imagepattern);
                            cicleofimage.setRadius(50.0);
                            cicleofimage.setStroke(Color.WHITE);
                            cicleofimage.setStrokeWidth(5.0);
                            //imgprf.setFitHeight(45.0);
                            //imgprf.setFitWidth(45.0);
                           
                            ///-----------------------------------
//                            Image valide= new Image("/edu/esprit/outdoors/resource/verified.png");
//                            ImageView valideview  = new ImageView();
//                            valideview.setImage(valide);
//                            valideview.setFitHeight(20);
//                            valideview.setFitWidth(20);
//                            
//                            ImageView guideview  = new ImageView();
//                            Image guideicon= new Image("/edu/esprit/outdoors/resource/guide.png");
//                            guideview.setImage(guideicon);
//                            guideview.setFitHeight(25);
//                            guideview.setFitWidth(25);
//                            
//                            Image star= new Image("/edu/esprit/outdoors/resource/star.png");
//                            ImageView oneS  = new ImageView(star);
//                            ImageView towS  = new ImageView(star);
//                            ImageView threeS  = new ImageView(star);
//                            ImageView fourS  = new ImageView(star);
//                            ImageView fiveS  = new ImageView(star);
//                            oneS.setFitHeight(15);
//                            oneS.setFitWidth(15);
//                            towS.setFitHeight(15);
//                            towS.setFitWidth(15);
//                            threeS.setFitHeight(15);
//                            threeS.setFitWidth(15);
//                            fourS.setFitHeight(15);
//                            fourS.setFitWidth(15);
//                            fiveS.setFitHeight(15);
//                            fiveS.setFitWidth(15);
//                             
                            ///------------------------
                           
                            Hyperlink name= new Hyperlink(item.getLieu());
                            name.setStyle(" -fx-text-fill: #81aa2a;" +
                                          " -fx-font-size: 17px;" +
                                          " -fx-font-weight: bold;");
                            name.setPrefSize(140, USE_PREF_SIZE);
                            Label gov= new Label(item.getDate().toString());
                            gov.setStyle(" -fx-text-fill: #aacc63;" +
                                          " -fx-font-size: 17px;");
                            gov.setPrefSize(140.0, USE_PREF_SIZE);
                            //--------------------------
                            
                            ///-----------------------------
                            
                            ToggleButton modif = new ToggleButton("Modifier");
                            modif.setPrefSize(160.0,30.0);
                            modif.setStyle(" -fx-text-fill: white;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-background-color:#81aa2a;");
                            ToggleButton supp = new ToggleButton("Supprimer");
                            supp.setPrefSize(160.0,30.0);
                            supp.setStyle(" -fx-text-fill: white;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-background-color:#81aa2a;");
                            //------------------------------
                          
                            //-------------------
                            //HBox rating = new HBox(oneS,towS,threeS,fourS,fiveS);
                            HBox nameAndAccount = new HBox(name);
                            nameAndAccount.setSpacing(10.0);
                            HBox part1 = new HBox(space,cicleofimage);
                            VBox part2= new VBox(space3,nameAndAccount,gov);
                            part2.setSpacing(5.0);
                            //--------------
                            VBox btn= new VBox(modif,space,supp);
                            HBox containerNoSeperator = new HBox(part1,part2,space1,btn);
                            containerNoSeperator.setSpacing(15.0);
                            HBox.setHgrow(space1, Priority.ALWAYS);
                            VBox containerwithSeprator = new VBox(separator1,containerNoSeperator,separator2);
                
                            
                            
                            setGraphic(containerwithSeprator);
                            
                            ///// code ////
                            
                            
                            name.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                try {
                                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/ajoutRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                                } catch (IOException ex) {
                                    Logger.getLogger(MembreController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            });
                            supp.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    rs.delete(item);
                                    System.out.println("delete****");
                               }
                            });
                            modif.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                     System.out.println("modif****");
                                       try {
                                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/modifRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                                } catch (IOException ex) {
                                    Logger.getLogger(MembreController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                }
                            });
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
  }
                    }
                             
                             };
                             }
                         });
        
        
       
                
    
});
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
     
    }    

    @FXML
    private void addRando(ActionEvent event) {
           try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/ajoutRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void lst(ActionEvent event) {
           try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/lstRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void archive(ActionEvent event) {
        
    }
    
}
