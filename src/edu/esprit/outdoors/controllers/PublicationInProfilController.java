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
import edu.esprit.outdoors.models.Photo;
import edu.esprit.outdoors.services.PhotoService;
import edu.esprit.outdoors.services.ProfilServices;
import edu.esprit.outdoors.services.PublicationService;
import edu.esprit.outdoors.services.UserService;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author WILLIAM
 */
public class PublicationInProfilController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
   private static final String STANDARD_BUTTON_STYLE = "-fx-text-fill: white;" +
                                           "-fx-font-size: 12px;" +
                                           " -fx-background-color:#81aa2a;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-text-fill: white;" +
                                           "-fx-font-size: 12px;" +
                                           " -fx-background-color:#4d7002;";
 
    
    
      @FXML
    private JFXListView<Photo> listPub;

    @FXML
    private AnchorPane AnchorPub;
    
    
    
    public static JFXListView<Photo> listPubcopy ; 
    final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    final Stage stage = new Stage();
    private Image image ;
    IUtilisateurs UserS = new UserService();
    IPublication PubS = new PublicationService();
    Iprofil PS = new ProfilServices();
    IPhoto PhS = new PhotoService();
    
     private  Node graphic ;
     private PublicationResultController controller ;
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listPubcopy = listPub;
        
        try {
            AnchorPane pubpane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/Publicationview.fxml"));
            AnchorPub.getChildren().add(pubpane);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       // ObservableList<Publication> List1 = PubS.DisplayAll();
       // ObservableList<Photo> List2 = PhS.DisplayAll();
        
       
        
        
        
        listPub.setItems(PhS.ListePubOfProfil(AuthentificationController.user.getProfil().getId_pr()));
       
      listPub.setCellFactory(new Callback<ListView<Photo>, ListCell<Photo>>() {

                             @Override
                             public ListCell<Photo> call(ListView<Photo> listPub ) {
                                
                             return new ListCell<Photo>(){
                             
                                 @Override
                    protected void updateItem(Photo item, boolean bln) {
                        
                        
                           super.updateItem(item, bln);
                           
                           
                        if (item != null) {
                            
                            if ((AuthentificationController.user.getProfil().getId_pr())==item.getCreator().getId_pr()){
                           
                           
                                                       //---------------
                             
                            //---------------
                            Region space =  new Region();
                            //space.setPrefSize(USE_PREF_SIZE, USE_PREF_SIZE);
                            Region space1 =  new Region();
                           
                            //---------------
                            
                            
                             ///--------space reserved for comment
                            Pane commentpane = new Pane();
                            commentpane.setPrefSize(USE_COMPUTED_SIZE, 30.0);
                            
                            //ImageView imgprf  = new ImageView(item.getCreator().getPhoto_profil());
                            ImagePattern imagepattern = new ImagePattern(item.getCreator().getPhoto_profil());
                            Circle cicleofimage = new Circle();
                            cicleofimage.setFill(imagepattern);
                            cicleofimage.setRadius(50.0);
                            cicleofimage.setStroke(Color.WHITE);
                            cicleofimage.setStrokeWidth(5.0);
                            ImageView imgpub  = new ImageView(item.getPhoto());
                            if (item.getPhoto()!=null){
                            imgpub.setFitHeight(700.0);
                            imgpub.setFitWidth(700.0);
                            }else{
                            imgpub.setFitHeight(0.0);
                            imgpub.setFitWidth(0.0);
                            }
                            //imgprf.setFitHeight(45.0);
                            //imgprf.setFitWidth(45.0);
                           
                            ///-----------------------------------
                            Image Messicon= new Image("/edu/esprit/outdoors/resource/comment.png");
                            ImageView imgmess  = new ImageView();
                            imgmess.setImage(Messicon);
                            imgmess.setFitHeight(25);
                            imgmess.setFitWidth(25);
                            
                            ImageView setting  = new ImageView();
                            Image settingicon= new Image("/edu/esprit/outdoors/resource/setting.png");
                            StackPane settingpart= new StackPane();
                            setting.setImage(settingicon);
                            setting.setFitHeight(20);
                            setting.setFitWidth(20);
                            ///------------------------
                           
                            Label name= new Label(PhS.getPrenomByIDprf(item.getCreator().getId_pr())+" "+PhS.getNomByIDprf(item.getCreator().getId_pr()));
                            name.setStyle(" -fx-text-fill: #81aa2a;" +
                                          " -fx-font-size: 17px;" +
                                          " -fx-font-weight: bold;");
                            name.setPrefSize(160.0, 45.0);
                            Label date= new Label(String.valueOf(item.getDate_creation()));
                            date.setStyle(" -fx-text-fill: #4e4e4e;" +
                                          " -fx-font-size: 12px;");
                            date.setPrefSize(160.0, 45.0);
                            Label nbrmess= new Label("10");
                            nbrmess.setStyle(" -fx-text-fill: #cccccc;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-font-weight: bold;");
                            nbrmess.setPrefSize(25.0, 25.0);
                            //--------------------------
                            
                            ///-----------------------------
                            Button affMess = new Button("Tous les commentaires");
                            affMess.setPrefSize(160.0,30.0);
                            affMess.setStyle(" -fx-text-fill: white;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-background-color:#81aa2a;");
                            Button update = new Button("Enregistrer les modifications");
                            changeBackgroundOnHoverUsingEvents(update);
                            changeBackgroundOnHoverUsingEvents(affMess);
                            update.setPrefSize(170.0,30.0);
                            update.setVisible(false);
                            //-------------------------------
                            
                            //----------------------
                            MenuButton option= new MenuButton();
                            MenuItem modifier = new MenuItem("Modifier");
                            MenuItem supprimer = new MenuItem("Supprimer");
                            option.getItems().addAll(modifier,supprimer);
                            option.setPrefSize(32.0,25.0); 
                            option.setOpacity(0.0);
                            //-------------------------
                          
                            //--------------------------
                            TextArea  text= new TextArea(item.getText());
                            text.setFont(Font.font("Typografix-demo", 15));
                            text.setPrefSize(700.0,97.0);
                            text.setStyle(" -fx-border-color: white;"
                                    + "-fx-border-radius: 0px;");
                            text.setEditable(false);
                            //-------------------------------------
                            
                            
                            //--------------------------
                            settingpart.getChildren().addAll(setting,option);
                            HBox messagePart = new HBox(nbrmess,imgmess);
                            //----------------------------------------------
                            
                            
                            //-------------------
                            HBox top = new HBox(name,space,date,settingpart);
                            top.setSpacing(10);
                            top.setHgrow(space, Priority.ALWAYS);
                            HBox center = new HBox(text);
                            center.setHgrow(text, Priority.ALWAYS);
                            HBox buttom = new HBox(affMess,update,space1,messagePart);
                            buttom.setHgrow(space1, Priority.ALWAYS);
                            buttom.setSpacing(10);
                            
                           

                            //buttom.setSpacing(10);
                            //buttom.setHgrow(space, Priority.ALWAYS);
                            //-----------------------
                         
                            
                            
                            VBox container= new VBox(top,center,imgpub,buttom);
                            container.setSpacing(10);
                            HBox containers = new HBox(cicleofimage,container);
                            //container.setMaxSize(MAX_VALUE, MAX_VALUE);
                            containers.setSpacing(10);
                            //-------------------------
                            
                            
                            setGraphic(containers);
                            
                            //-----Code----////
                            
                            modifier.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                   
                    text.setEditable(true);
                    update.setVisible(true);
                    
                }
            });
                            
                             update.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                   
                    
                      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Are you ok with this?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                            // ... user chose OK
                        PubS.update(text.getText(), item.getId());
                    } else {
                    // ... user chose CANCEL or closed the dialog
                    } 
                    
                   // System.out.println(item.getId());
                }
            });
                             
                             
                             
                            supprimer.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                   
                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Are you ok with this?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                            // ... user chose OK
                         PubS.delete(item.getId());
                    } else {
                    // ... user chose CANCEL or closed the dialog
                    } 
                   
                }
            });
                           
                           
                           }else{
                            
                            
                                                        //---------------
                            Region space =  new Region();
                            //space.setPrefSize(USE_PREF_SIZE, USE_PREF_SIZE);
                            Region space1 =  new Region();
                            Separator separator1 = new Separator();
                            Separator separator2 = new Separator();
                           
                           
                            //---------------
                             Pane commentpane = new Pane();
                            commentpane.setPrefSize(USE_COMPUTED_SIZE, 30.0);
                            
                             //ImageView imgprf  = new ImageView(item.getCreator().getPhoto_profil());
                            ImagePattern imagepattern = new ImagePattern(item.getCreator().getPhoto_profil());
                            Circle cicleofimage = new Circle();
                            cicleofimage.setFill(imagepattern);
                            cicleofimage.setRadius(50.0);
                            cicleofimage.setStroke(Color.WHITE);
                            cicleofimage.setStrokeWidth(5.0);
                            ImageView imgpub  = new ImageView(item.getPhoto());
                            if (item.getPhoto()!=null){
                            imgpub.setFitHeight(700.0);
                            imgpub.setFitWidth(700.0);
                            }else{
                            imgpub.setFitHeight(0.0);
                            imgpub.setFitWidth(0.0);
                            }
                            //imgprf.setFitHeight(45.0);
                            //imgprf.setFitWidth(45.0);
                           
                            ///-----------------------------------
                            Image Messicon= new Image("/edu/esprit/outdoors/resource/comment.png");
                            ImageView imgmess  = new ImageView();
                            imgmess.setImage(Messicon);
                            imgmess.setFitHeight(25);
                            imgmess.setFitWidth(25);
                            
                            ImageView setting  = new ImageView();
                            Image settingicon= new Image("/edu/esprit/outdoors/resource/setting.png");
                            StackPane settingpart= new StackPane();
                            setting.setImage(settingicon);
                            setting.setFitHeight(20);
                            setting.setFitWidth(20);
                            ///------------------------
                           
                            Label name= new Label(PhS.getPrenomByIDprf(item.getCreator().getId_pr())+" "+PhS.getNomByIDprf(item.getCreator().getId_pr()));
                            name.setStyle(" -fx-text-fill: #81aa2a;" +
                                          " -fx-font-size: 17px;" +
                                          " -fx-font-weight: bold;");
                            name.setPrefSize(160.0, 45.0);
                            Label date= new Label(String.valueOf(item.getDate_creation()));
                            date.setStyle(" -fx-text-fill: #4e4e4e;" +
                                          " -fx-font-size: 12px;");
                            date.setPrefSize(160.0, 45.0);
                            Label nbrmess= new Label("10");
                            nbrmess.setStyle(" -fx-text-fill: #cccccc;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-font-weight: bold;");
                            nbrmess.setPrefSize(25.0, 25.0);
                            //--------------------------
                            
                            ///-----------------------------
                            Button affMess = new Button("Afficher tous les commentaires");
                            affMess.setPrefSize(170.0,30.0);
                            affMess.setStyle(" -fx-text-fill: white;" +
                                          " -fx-font-size: 12px;" +
                                          " -fx-background-color:#81aa2a;");
                            //-------------------------------
                            
                            //----------------------
                            MenuButton option= new MenuButton();
                            MenuItem modifier = new MenuItem("Signaler");
                            option.getItems().add(modifier);
                            option.setPrefSize(32.0,25.0); 
                            option.setOpacity(0.0);
                            //-------------------------
                          
                            //--------------------------
                            TextArea  text= new TextArea(item.getText());
                            text.setFont(Font.font("Typografix-demo", 15));
                            text.setPrefSize(700.0,97.0);
                            text.setStyle(" -fx-border-color: white;"
                                    + "-fx-border-radius: 0px;");
                            text.setEditable(false);
                            //-------------------------------------
                            
                            
                            //--------------------------
                            settingpart.getChildren().addAll(setting,option);
                            HBox messagePart = new HBox(nbrmess,imgmess);
                            //----------------------------------------------
                            
                            
                            HBox top = new HBox(name,space,date,settingpart);
                            top.setSpacing(10);
                            top.setHgrow(space, Priority.ALWAYS);
                            HBox center = new HBox(text);
                            center.setHgrow(text, Priority.ALWAYS);
                            HBox buttom = new HBox(affMess,space1,messagePart);
                            buttom.setHgrow(space1, Priority.ALWAYS);
                            buttom.setSpacing(10);
                            
                           

                            //buttom.setSpacing(10);
                            //buttom.setHgrow(space, Priority.ALWAYS);
                            //-----------------------
                         
                            
                            
                            VBox container= new VBox(top,center,imgpub,buttom);
                            container.setSpacing(10);
                            HBox containers = new HBox(cicleofimage,container);
                            containers.setPrefSize(500, 200);
                            //container.setMaxSize(MAX_VALUE, MAX_VALUE);
                            VBox containerwithseperator= new VBox(separator1,containers,commentpane,separator2);
                            containers.setSpacing(10);
                            //-------------------------
                            
                            
                            setGraphic(containerwithseperator);
                            
                            //-----Code----////
                            
                            
                            
                            }
                            

                            
                        }
                    }
                             
                             };
                             }
                         });
        
        
        
    }    
    
    
    
     public void changeBackgroundOnHoverUsingEvents(final Node node) {
    node.setStyle(STANDARD_BUTTON_STYLE);
    node.setOnMouseEntered(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        node.setStyle(HOVERED_BUTTON_STYLE);
      }
    });
    node.setOnMouseExited(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        node.setStyle(STANDARD_BUTTON_STYLE);
      }
    });
  }   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
