/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.User;
import edu.esprit.outdoors.iservices.IPhoto;
import edu.esprit.outdoors.iservices.IUtilisateurs;
import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.services.PhotoService;
import edu.esprit.outdoors.services.UserService;
import edu.esprit.outdoors.tests.Outdoors;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * FXML Controller class
 *
 * @author WILLIAM
 */
public class Inscription_Conex_Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
@FXML
    private ToggleButton conexT;

    @FXML
    private ToggleGroup choiceAu;

    @FXML
    private ToggleButton sincT ;

    @FXML
    private HBox HboxImage;

    @FXML
    private AnchorPane An1;
    
      @FXML
    private AnchorPane root;

    
    
    IUtilisateurs userS = new UserService();;
    IPhoto PhS = new PhotoService();   
    //static Utilisateurs user;
    
    static String username;
    static String pass1;
    static String pass2;
    
    static AnchorPane rootcopy;
    
    
    @FXML
    void facebook(MouseEvent event) throws SQLException, IOException {

        String domain = "http://www.google.tn/";
        String appId = "1129909027135670";
       
        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId+"&redirect_uri="+domain+"&scope=user_about_me,"
                + "user_actions.books,user_actions.fitness,user_actions.music,user_actions.news,user_actions.video,user_birthday,user_education_history,"
                + "user_events,user_photos,user_friends,user_games_activity,user_hometown,user_likes,user_location,user_photos,user_relationship_details,"
                + "user_relationships,user_religion_politics,user_status,user_tagged_places,user_videos,user_website,user_work_history,ads_management,ads_read,email,"
                + "manage_pages,publish_actions,read_insights,read_page_mailboxes,rsvp_event";
        
       
        System.setProperty("webdirver.chrome.driver", "chromedriver.exe");
       
        WebDriver driver = new ChromeDriver();
        driver.get(authUrl);
        String accessToken;
        while(true){
       
            if(!driver.getCurrentUrl().contains("facebook.com")){
            String url = driver.getCurrentUrl();
            accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");
           
            driver.quit();
           
                FacebookClient fbClient = new DefaultFacebookClient(accessToken);
                User user = fbClient.fetchObject("me",User.class,Parameter.with("fields", "email,location,id,birthday,hometown,gender,last_name,first_name,cover,picture"));
               
               // label.setText(user.getName());
               // label.setText(user.getHometownName());
                if (userS.checkforemail(user.getEmail())){
                
                AuthentificationController.user=userS.Authenticationwithfacebook(user.getEmail());
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/Home.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
                
                }else{
                    
                    Utilisateurs u  = new Utilisateurs();
                    Profil p = new Profil();
         
                    display("completer l'inscription");
                    
                    u.setNom(user.getLastName());
                    u.setPrenom(user.getFirstName());
                    p.setGouvernorat(user.getLocation().getName());
                    p.setSexe(user.getGender());
                    u.setEmail(user.getEmail());
                    u.setId_Ut(username);
                    u.setMot_passe(pass1);
                    
                    userS.addwithfcb(u, p,user.getPicture().getUrl());
                  // System.out.println(user.getPicture().getUrl());
                   
                   Image profilimg = new Image(user.getPicture().getUrl());
                   
                   p.setPhoto_profil(profilimg); 
                  
                   
                  
                AuthentificationController.user=userS.Authenticationwithfacebook(user.getEmail());
                
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/Home.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
                        
                        
                  
                
                
                
                }
                
                
               
   
           
            }
       
        }
       
        
    }

    
    
    
    private final double IMG_WIDTH = 400;
    private final double IMG_HEIGHT = 526;

    private final int NUM_OF_IMGS = 4;
    private final int SLIDE_FREQ = 4; // in 
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         rootcopy = root;
   
        ImageView img1= new ImageView("/edu/esprit/outdoors/resource/1.png");
        ImageView img2 = new ImageView("/edu/esprit/outdoors/resource/2.png");
        ImageView img3 = new ImageView("/edu/esprit/outdoors/resource/3.png");
        ImageView img4 = new ImageView("/edu/esprit/outdoors/resource/4.png");
   
        HboxImage.getChildren().addAll(img1, img2, img3,img4);
   
        startAnimation(HboxImage);
        
        //sincT.isSelected(true);
        choiceAu.selectToggle(conexT);
        sincT.setStyle("-fx-background-color:#757575;-fx-effect: null;");
        conexT.setStyle("-fx-background-color:rgb(129, 170, 42);-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.5),10,0.0,0.0,0.0);");
             try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/Authentification.fxml"));
                    An1.getChildren().setAll(pane);
                } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
        choiceAu.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (conexT.isSelected()){
                sincT.setStyle("-fx-background-color:#757575;-fx-effect: null;");
                conexT.setStyle("-fx-background-color:rgb(129, 170, 42);-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.5),10,0.0,0.0,0.0);");
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/Authentification.fxml"));
                    An1.getChildren().setAll(pane);
                } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            if (sincT.isSelected()){
                conexT.setStyle("-fx-background-color:#757575;-fx-effect: null;");
                sincT.setStyle("-fx-background-color:rgb(129, 170, 42);-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.5),10,0.0,0.0,0.0);");
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/Inscription.fxml"));
                    An1.getChildren().setAll(pane);
                } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

       
        
      private void startAnimation(final HBox hbox) {
        //error occured on (ActionEvent t) line
        //slide action
        EventHandler<ActionEvent> slideAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1.5), hbox);
            trans.setByX(-IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };
        //eventHandler
        EventHandler<ActionEvent> resetAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1), hbox);
            trans.setByX((NUM_OF_IMGS - 1) * IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };

        List<KeyFrame> keyFrames = new ArrayList<>();
        for (int i = 1; i <= NUM_OF_IMGS; i++) {
            if (i == NUM_OF_IMGS) {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), resetAction));
            } else {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), slideAction));
            }
        }
//add timeLine
        Timeline anim = new Timeline(keyFrames.toArray(new KeyFrame[NUM_OF_IMGS]));

        anim.setCycleCount(Timeline.INDEFINITE);
        anim.playFromStart();
    }  
    
      public static void display(String title) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

      
    
        JFXTextField un = new JFXTextField();
        un.setPromptText("Identifiant");
        JFXPasswordField pass = new JFXPasswordField();
        pass.setPromptText("Mot de passe");
        JFXPasswordField passC = new JFXPasswordField();
        passC.setPromptText("Confirmation du mot de passe");
        
        
        JFXButton finish = new JFXButton("OK");
        finish.setStyle("-fx-border-radius: 10px;" +
                        "  -fx-background-color: rgb(129, 170, 42);" +
                        "  -fx-position: absolute;" +
                        "  -fx-left: 191px;" +
                        "  -fx-top: 766px;" +
                        "  -fx-width: 168px;" +
                        "  -fx-height: 68px;" +
                        "  -fx-z-index: 58;" +
                        "  -fx-font-size: 20px;" +
                        "  -fx-line-height: 1.2;" +
                        "  -fx-text-align: center;" +
                        "  -fx-font-weight: bold;" +
                        "  -fx-text-fill: white;");
        //Button closeButton = new Button("Close this window");
        finish.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                username = un.getText();
                pass1 = pass.getText();
                pass2 = passC.getText();
                if (pass.getText().equals(passC.getText())){window.close();}
                else{ Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Mots de passe ne sont pas identiques!");

                alert.showAndWait();}
               
            }
        });
        
        

        VBox layout = new VBox(10);
        layout.getChildren().addAll(un, pass,passC,finish);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    
    
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}    
    
