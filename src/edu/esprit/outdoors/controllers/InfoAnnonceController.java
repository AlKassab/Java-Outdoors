/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;


import edu.esprit.outdoors.models.Annonce;
import edu.esprit.outdoors.services.AnnonceService;
import edu.esprit.outdoors.services.UserService;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ASUS I7
 */
public class InfoAnnonceController implements Initializable {

    @FXML
    private TextField TitreA;
    @FXML
    private ImageView img;
    @FXML
    private TextArea Desca;
    @FXML
    private TextField PrixA;
    @FXML
    private TextField date;
    @FXML
    private TextField pubPar;
    @FXML
    private TextField type;
    @FXML
    private TextField etat;
    
     private final double IMG_WIDTH = 470;
    private final double IMG_HEIGHT = 650;
    
     private final int NUM_OF_IMGS = 4;
    private final int SLIDE_FREQ = 4;
    @FXML
    private HBox defilante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ImageView im1= new ImageView("/edu/esprit/outdoors/resource/pub.png");
        ImageView im2 = new ImageView("/edu/esprit/outdoors/resource/pub1.png");
        ImageView im3 = new ImageView("/edu/esprit/outdoors/resource/pub3.png");
        ImageView im4 = new ImageView("/edu/esprit/outdoors/resource/pub4.png");
         defilante.getChildren().addAll(im1, im2, im3,im4);
   
        startAnimation(defilante);
        
        AnnonceService AS = new AnnonceService();
        UserService US = new UserService();
     
         Annonce a=AS.getInfo(GestionAnnonceController.idA);
          float prix= a.getPrix();
          String sPrix = Float.toString(prix);
        File f = new File(a.getImage());
                    Image img1 = new Image(f.toURI().toString());
                    img.setImage(img1);
        TitreA.setText(a.getNom());
        Desca.setText(a.getDescription());
        PrixA.setText(sPrix);
        date.setText(a.getDatePub());
        int idAnnonceur=a.getIdCurrentUser();
     
        pubPar.setText(US.SelectName(idAnnonceur));
        type.setText(a.getType());
        etat.setText(a.getEtat());
       
    }    

    @FXML
    private void cantacter(ActionEvent event) {
    }
    
     public void startAnimation(final HBox hbox) {
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
    
    
}
