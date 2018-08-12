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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
public class lstRandoController implements Initializable {

    @FXML
    private Label nombreRslt;
    @FXML
    private TextField search;
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
    private ComboBox<String> comboType;
    @FXML
    private JFXListView<Randonnees> listR;
    @FXML
    private ComboBox<String> combodiff;
    
   RandoService rs= new RandoService();
   public static Randonnees rr;
 public static Randonnees rando;
     public static int idRando;
     public static int idR;
    public static Randonnees Rando;
    
 RandoService rds = new RandoService();
    public static Randonnees getRando() {
        return Rando;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
         
        listR.setItems(rs.getAll());
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
                            ///space4.setPrefSize(250.0, USE_PREF_SIZE);
                           
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
                            Label type= new Label("Type: "+item.getType());
                            Label diff =new Label("Difficulté: "+item.getDifficulte());
                            //--------------------------
                            
                            ///-----------------------------
                            
                            ToggleButton follow = new ToggleButton("Participer");
                            follow.setPrefSize(160.0,30.0);
                            follow.setStyle(" -fx-text-fill: white;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-background-color:#81aa2a;");
                            
                            Label prix =new Label("Prix:  "+item.getPrix());
                            //------------------------------
                          
                            //-------------------
                            //HBox rating = new HBox(oneS,towS,threeS,fourS,fiveS);
                          HBox nameAndAccount = new HBox(name);
                            nameAndAccount.setSpacing(10.0);
                            HBox part1 = new HBox(space,cicleofimage);
                            VBox part2= new VBox(space3,nameAndAccount,gov);
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
                                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/infoRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                                } catch (IOException ex) {
                                    Logger.getLogger(MembreController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            });
                            follow.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    if(item.getNb_randonneur()==0){
                                       Alert alert = new Alert(AlertType.WARNING);
                                        alert.setTitle("ECHEC DE PARTICIPATION");
                                        alert.setHeaderText("Un problème est survenu lors de votre participation");
                                        alert.setContentText("Votre participation n'a pas été prise en considéraion!\n" +
"L'equipe d'outdoors vous remercie pour votre participation et vous informe que malheureusement il n'y a plus de place disponibe pour cette randonnée \n" +
"Veuillez consulter nos autres randonnée disponible\n" +
"On vous remercie pour votre compréhension!");
                                        alert.showAndWait();
                                    }
               else{
                                        if(AuthentificationController.user.getMoney()<item.getPrix()){
                                item.setNb_randonneur(item.getNb_randonneur()-1);
                                AuthentificationController.user.setMoney(AuthentificationController.user.getMoney()-Math.round(item.getPrix()));
                                Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("CONFIRMATION DE PARTICIPATION");
alert.setHeaderText(null);
alert.setContentText("Votre participation a bien été prise en considération!\n" +
"L'equipe d'outdoors vous remercie pour votre participation et pour vous encourager vous allez bénéficer d'une somme de 25dt qui va etre ajouté directement à votre compte");

alert.showAndWait();
                                        }
                                
                                
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
          "Prix",
          "Date"
         
    );
           
   comboTirerpar.setItems(options);
        
        combodiff.setCellFactory(param -> new ListCell<String>() {
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
          "Facile",
          "Moyenne" ,
          "Difficile"
         
    );
           
   combodiff.setItems(options2);
        
        
        
        
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
          "A pied",
          "En vélo"
         
    );
           
   comboType.setItems(options3);
        
        
        
       search.textProperty().addListener((observable, oldValue, newValue) -> {
           
           nombreRslt.setText(String.valueOf(listR.getItems().size()));
           
           
      listR.refresh();
      
        listR.setItems(rs.Rechercher(newValue));
   
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
                            
                            ToggleButton follow = new ToggleButton("Participer");
                            follow.setPrefSize(160.0,30.0);
                            follow.setStyle(" -fx-text-fill: white;" +
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
                                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/infoRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                                } catch (IOException ex) {
                                    Logger.getLogger(MembreController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            });
                            follow.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    if(item.getNb_randonneur()==0){
                                       Alert alert = new Alert(AlertType.WARNING);
                                        alert.setTitle("ECHEC DE PARTICIPATION");
                                        alert.setHeaderText("Un problème est survenu lors de votre participation");
                                        alert.setContentText("Votre participation n'a pas été prise en considéraion!\n" +
"L'equipe d'outdoors vous remercie pour votre participation et vous informe que malheureusement il n'y a plus de place disponibe pour cette randonnée \n" +
"Veuillez consulter nos autres randonnée disponible\n" +
"On vous remercie pour votre compréhension!");
                                        alert.showAndWait();
                                    }
               else{
                                        if(AuthentificationController.user.getMoney()<item.getPrix()){
                                item.setNb_randonneur(item.getNb_randonneur()-1);
                                AuthentificationController.user.setMoney(AuthentificationController.user.getMoney()-Math.round(item.getPrix()));
                                Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("CONFIRMATION DE PARTICIPATION");
alert.setHeaderText(null);
alert.setContentText("Votre participation a bien été prise en considération!\n" +
"L'equipe d'outdoors vous remercie pour votre participation et pour vous encourager vous allez bénéficer d'une somme de 25dt qui va etre ajouté directement à votre compte");

alert.showAndWait();
                                        }
                                
                                
                                    }
                                }
              
                            });
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
  }
                    }
                             
                             };
                             }
                         });
        
        
       
                
    
});
        
        
        
        
        
        
        
        
         listR.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Randonnees>(){
     @Override
     public void changed(ObservableValue<? extends Randonnees> observable, Randonnees oldValue, Randonnees newValue) {
          Randonnees currentrando=(Randonnees) listR.getSelectionModel().getSelectedItem();
                   
                   idRando= currentrando.getId_ran();
                   rds.getInfo(idRando);
                   System.out.println(".changed() "+ currentrando.toString());
                   //rds.modify(currentrando);
         try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/infoRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
         
     });  
        
        
        
        
        
        
        
        
        
        
        // TODO
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
    private void mine(ActionEvent event) {
           try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/mesRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void archive(ActionEvent event) {
    }
    
}
