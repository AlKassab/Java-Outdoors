/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXListView;
import edu.esprit.outdoors.iservices.IPhoto;
import edu.esprit.outdoors.iservices.IPublication;
import edu.esprit.outdoors.iservices.IUtilisateurs;
import edu.esprit.outdoors.iservices.Iprofil;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.services.PhotoService;
import edu.esprit.outdoors.services.ProfilServices;
import edu.esprit.outdoors.services.PublicationService;
import edu.esprit.outdoors.services.UserService;
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
import javafx.scene.control.ComboBox;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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
 * @author WILLIAM
 */
public class MembreController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Label nombreRslt;

    @FXML
    private TextField search;

    @FXML
    private JFXListView<Utilisateurs> listUser;
    
     @FXML
    private AnchorPane result;


    @FXML
    private ToggleButton abonnemnt;

    @FXML
    private ToggleGroup choix;

    @FXML
    private ToggleButton abonne;

    @FXML
    private ToggleButton explore;

    @FXML
    private ComboBox<String> comboTirerpar;

    @FXML
    private ComboBox<String> comboGouvernorat;

    @FXML
    private ComboBox<String> comboType;
    
    
   
    IUtilisateurs UserS = new UserService();
    IPublication PubS = new PublicationService();
    Iprofil PS = new ProfilServices();
    IPhoto PhS = new PhotoService();        

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
         
        listUser.setItems(UserS.DisplayAll());
        //listUser.refresh();
        
        nombreRslt.setText(String.valueOf(listUser.getItems().size()));
        listUser.setCellFactory(new Callback<ListView<Utilisateurs>, ListCell<Utilisateurs>>() {

                             @Override
                             public ListCell<Utilisateurs> call(ListView<Utilisateurs> listPub ) {
                                
                             return new ListCell<Utilisateurs>(){
                             
                                 @Override
                    protected void updateItem(Utilisateurs item, boolean bln) {
 
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
                            ImagePattern imagepattern = new ImagePattern(UserS.getById(item.getId_user()).getProfil().getPhoto_profil());
                            Circle cicleofimage = new Circle();
                            cicleofimage.setFill(imagepattern);
                            cicleofimage.setRadius(50.0);
                            cicleofimage.setStroke(Color.WHITE);
                            cicleofimage.setStrokeWidth(5.0);
                            //imgprf.setFitHeight(45.0);
                            //imgprf.setFitWidth(45.0);
                           
                            ///-----------------------------------
                            Image valide= new Image("/edu/esprit/outdoors/resource/verified.png");
                            ImageView valideview  = new ImageView();
                            valideview.setImage(valide);
                            valideview.setFitHeight(20);
                            valideview.setFitWidth(20);
                            
                            ImageView guideview  = new ImageView();
                            Image guideicon= new Image("/edu/esprit/outdoors/resource/guide.png");
                            guideview.setImage(guideicon);
                            guideview.setFitHeight(25);
                            guideview.setFitWidth(25);
                            
                            Image star= new Image("/edu/esprit/outdoors/resource/star.png");
                            ImageView oneS  = new ImageView(star);
                            ImageView towS  = new ImageView(star);
                            ImageView threeS  = new ImageView(star);
                            ImageView fourS  = new ImageView(star);
                            ImageView fiveS  = new ImageView(star);
                            oneS.setFitHeight(15);
                            oneS.setFitWidth(15);
                            towS.setFitHeight(15);
                            towS.setFitWidth(15);
                            threeS.setFitHeight(15);
                            threeS.setFitWidth(15);
                            fourS.setFitHeight(15);
                            fourS.setFitWidth(15);
                            fiveS.setFitHeight(15);
                            fiveS.setFitWidth(15);
                             
                            ///------------------------
                           
                            Hyperlink name= new Hyperlink(UserS.getById(item.getId_user()).getPrenom()+" "+UserS.getById(item.getId_user()).getNom());
                            name.setStyle(" -fx-text-fill: #81aa2a;" +
                                          " -fx-font-size: 17px;" +
                                          " -fx-font-weight: bold;");
                            name.setPrefSize(140, USE_PREF_SIZE);
                            Label gov= new Label(UserS.getById(item.getId_user()).getProfil().getGouvernorat());
                            gov.setStyle(" -fx-text-fill: #aacc63;" +
                                          " -fx-font-size: 17px;");
                            gov.setPrefSize(140.0, USE_PREF_SIZE);
                            //--------------------------
                            
                            ///-----------------------------
                            
                            ToggleButton follow = new ToggleButton("Suivre");
                            follow.setPrefSize(160.0,30.0);
                            follow.setStyle(" -fx-text-fill: white;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-background-color:#81aa2a;");
                            //------------------------------
                          
                            //-------------------
                            HBox rating = new HBox(oneS,towS,threeS,fourS,fiveS);
                            HBox nameAndAccount = new HBox(name,valideview,guideview);
                            nameAndAccount.setSpacing(10.0);
                            HBox part1 = new HBox(space,cicleofimage);
                            VBox part2= new VBox(space3,nameAndAccount,gov,rating);
                            part2.setSpacing(5.0);
                            //--------------
                            HBox containerNoSeperator = new HBox(part1,part2,space1,follow);
                            containerNoSeperator.setSpacing(15.0);
                            HBox.setHgrow(space1, Priority.ALWAYS);
                            VBox containerwithSeprator = new VBox(separator1,containerNoSeperator,separator2);
                
                            
                            
                            setGraphic(containerwithSeprator);
                            
                            ///// code ////
                            
                            
                            name.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                try {
                                    setuserprofile(item);
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
        
               comboTirerpar.setCellFactory(param -> new ListCell<String>() {
    {
        setTextFill(Color.WHITE);

        Background blackBackground = new Background(new BackgroundFill(Color.rgb(77, 77, 77), null, null));
        Background greenBackground = new Background(new BackgroundFill(Color.rgb(129, 170, 42), null, null));

        
        
        setBackground(blackBackground);
        setOnMouseEntered(event -> {
            setBackground(greenBackground);
        });
        setOnMouseExited(event -> {
            setBackground(blackBackground);
        });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            return;
        }
        setText(item);
    }
});
            
            ObservableList<String> options = 
    FXCollections.observableArrayList(   
          "Evaluation",
          "Nombre de rondonnées organisée"
         
    );
           
   comboTirerpar.setItems(options);
        
        comboGouvernorat.setCellFactory(param -> new ListCell<String>() {
    {
        setTextFill(Color.WHITE);

        Background blackBackground = new Background(new BackgroundFill(Color.rgb(77, 77, 77), null, null));
        Background greenBackground = new Background(new BackgroundFill(Color.rgb(129, 170, 42), null, null));

        
        
        setBackground(blackBackground);
        setOnMouseEntered(event -> {
            setBackground(greenBackground);
        });
        setOnMouseExited(event -> {
            setBackground(blackBackground);
        });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            return;
        }
        setText(item);
    }
});
            
            ObservableList<String> options2 = 
    FXCollections.observableArrayList(   
          "Ariana",
          "Beja" ,
          "Ben_Arous",
          "Bizerte", 
          "Gabès" ,
          "Gafsa" ,
          "Jendouba" ,
          "Kairouan" ,
          "Kasserine", 
          "Kébili" ,
          "La_Mannouba" ,
          "Le_Kef" ,
          "Mahdia" ,
          "Médinine", 
          "Monastir" ,
          "Nabeul", 
          "Sfax" ,
          "Sidi Bouzid", 
          "Siliana" ,
          "Sousse" ,
          "Tataouine", 
          "Tozeur", 
          "Tunis", 
          "Zaghouan" 
         
    );
           
   comboGouvernorat.setItems(options2);
        
        
        
        
        comboType.setCellFactory(param -> new ListCell<String>() {
    {
        setTextFill(Color.WHITE);

        Background blackBackground = new Background(new BackgroundFill(Color.rgb(77, 77, 77), null, null));
        Background greenBackground = new Background(new BackgroundFill(Color.rgb(129, 170, 42), null, null));

        
        
        setBackground(blackBackground);
        setOnMouseEntered(event -> {
            setBackground(greenBackground);
        });
        setOnMouseExited(event -> {
            setBackground(blackBackground);
        });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            return;
        }
        setText(item);
    }
});
            
            ObservableList<String> options3 = 
    FXCollections.observableArrayList(   
          "Membre ordinaire",
          "Guide"
         
    );
           
   comboType.setItems(options3);
        
        
        
       search.textProperty().addListener((observable, oldValue, newValue) -> {
           
           nombreRslt.setText(String.valueOf(listUser.getItems().size()));
           
           
      listUser.refresh();
      
        listUser.setItems(UserS.findbyname(newValue));
   
        listUser.setCellFactory(new Callback<ListView<Utilisateurs>, ListCell<Utilisateurs>>() {

                             @Override
                             public ListCell<Utilisateurs> call(ListView<Utilisateurs> listPub ) {
                                
                             return new ListCell<Utilisateurs>(){
                             
                                 @Override
                    protected void updateItem(Utilisateurs item, boolean bln) {
 
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
                            ImagePattern imagepattern = new ImagePattern(UserS.getById(item.getId_user()).getProfil().getPhoto_profil());
                            Circle cicleofimage = new Circle();
                            cicleofimage.setFill(imagepattern);
                            cicleofimage.setRadius(50.0);
                            cicleofimage.setStroke(Color.WHITE);
                            cicleofimage.setStrokeWidth(5.0);
                            //imgprf.setFitHeight(45.0);
                            //imgprf.setFitWidth(45.0);
                           
                            ///-----------------------------------
                            Image valide= new Image("/edu/esprit/outdoors/resource/verified.png");
                            ImageView valideview  = new ImageView();
                            valideview.setImage(valide);
                            valideview.setFitHeight(20);
                            valideview.setFitWidth(20);
                            
                            ImageView guideview  = new ImageView();
                            Image guideicon= new Image("/edu/esprit/outdoors/resource/guide.png");
                            guideview.setImage(guideicon);
                            guideview.setFitHeight(25);
                            guideview.setFitWidth(25);
                            
                            Image star= new Image("/edu/esprit/outdoors/resource/star.png");
                            ImageView oneS  = new ImageView(star);
                            ImageView towS  = new ImageView(star);
                            ImageView threeS  = new ImageView(star);
                            ImageView fourS  = new ImageView(star);
                            ImageView fiveS  = new ImageView(star);
                            oneS.setFitHeight(15);
                            oneS.setFitWidth(15);
                            towS.setFitHeight(15);
                            towS.setFitWidth(15);
                            threeS.setFitHeight(15);
                            threeS.setFitWidth(15);
                            fourS.setFitHeight(15);
                            fourS.setFitWidth(15);
                            fiveS.setFitHeight(15);
                            fiveS.setFitWidth(15);
                             
                            ///------------------------
                           
                            Hyperlink name= new Hyperlink(UserS.getById(item.getId_user()).getPrenom()+" "+UserS.getById(item.getId_user()).getNom());
                            name.setStyle(" -fx-text-fill: #81aa2a;" +
                                          " -fx-font-size: 17px;" +
                                          " -fx-font-weight: bold;");
                            name.setPrefSize(140, USE_PREF_SIZE);
                            Label gov= new Label(UserS.getById(item.getId_user()).getProfil().getGouvernorat());
                            gov.setStyle(" -fx-text-fill: #aacc63;" +
                                          " -fx-font-size: 17px;");
                            gov.setPrefSize(140.0, USE_PREF_SIZE);
                            //--------------------------
                            
                            ///-----------------------------
                            
                            ToggleButton follow = new ToggleButton("Suivre");
                            follow.setPrefSize(160.0,30.0);
                            follow.setStyle(" -fx-text-fill: white;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-background-color:#81aa2a;");
                            //------------------------------
                          
                            //-------------------
                            HBox rating = new HBox(oneS,towS,threeS,fourS,fiveS);
                            HBox nameAndAccount = new HBox(name,valideview,guideview);
                            nameAndAccount.setSpacing(10.0);
                            HBox part1 = new HBox(space,cicleofimage);
                            VBox part2= new VBox(space3,nameAndAccount,gov,rating);
                            part2.setSpacing(5.0);
                            //--------------
                            HBox containerNoSeperator = new HBox(part1,part2,space1,follow);
                            containerNoSeperator.setSpacing(15.0);
                            HBox.setHgrow(space1, Priority.ALWAYS);
                            VBox containerwithSeprator = new VBox(separator1,containerNoSeperator,separator2);
                
                            
                            
                            setGraphic(containerwithSeprator);
                            listUser.refresh();
                            nombreRslt.setText(String.valueOf(listUser.getItems().size()));
                            
                            
                            
                            ////code ///
                              name.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                try {
                                    setuserprofile(item);
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
    
    
    
    
    
    private void setuserprofile(Utilisateurs item) throws IOException{
    
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/Profile.fxml")); 
        HomeController.scollfromhomep.setContent(pane);
        
        ProfileController.nameinprofilecopy.setText(UserS.getById(item.getId_user()).getNom()+" "+UserS.getById(item.getId_user()).getPrenom());
        ProfileController.gouvernoratLabelcpoy.setText(UserS.getById(item.getId_user()).getProfil().getGouvernorat());
        BackgroundSize bz = new BackgroundSize(301, 316, false, false, false, true);
        BackgroundImage myBI= new BackgroundImage(UserS.getById(item.getId_user()).getProfil().getPhoto_profil(), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,bz);
        Profileitem2Controller.profilpiccopy.setBackground(new Background(myBI));
       
        BackgroundSize bz1 = new BackgroundSize(301, 316, false, false, false, true);
        BackgroundImage myBI1= new BackgroundImage(UserS.getById(item.getId_user()).getProfil().getPhoto_cover(), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,bz1);
        ProfileController.covercopy.setBackground(new Background(myBI1));
        if((UserS.getById(item.getId_user()).getId_user())==(AuthentificationController.user.getId_user())){
        Profileitem2Controller.optiontousercopy.setVisible(false);
        Profileitem2Controller.optiontousercopy.toBack();
        Profileitem2Controller.optiontousercopy.setOpacity(0.0);
        Profileitem2Controller.optiontprofilecopy.setVisible(true);
        Profileitem2Controller.optiontprofilecopy.toFront();
        Profileitem2Controller.followbtncopy.setVisible(false);
        }else{
        Profileitem2Controller.optiontousercopy.setVisible(true);
        Profileitem2Controller.optiontousercopy.toFront();
        Profileitem2Controller.optiontousercopy.setOpacity(0.0);
        Profileitem2Controller.optiontprofilecopy.setVisible(false);
        Profileitem2Controller.followbtncopy.setVisible(true);
        }
        
        
        PublicationInProfilController.listPubcopy.setItems(PhS.ListePubOfProfil(UserS.getById(item.getId_user()).getProfil().getId_pr()));
        
        
        
    
    }
    
    
    
    











}
