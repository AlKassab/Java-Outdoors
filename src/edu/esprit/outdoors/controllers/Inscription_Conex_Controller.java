/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

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
    
    
    
    private final double IMG_WIDTH = 400;
    private final double IMG_HEIGHT = 526;

    private final int NUM_OF_IMGS = 4;
    private final int SLIDE_FREQ = 4; // in 
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
   
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
    
    
    
}    
    
