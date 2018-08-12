/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.outdoors.iservices.IUtilisateurs;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.services.UserService;
import edu.esprit.outdoors.tests.Outdoors;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author WILLIAM
 */
public class AuthentificationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXPasswordField mdpc2;

    @FXML
    private JFXButton btn;

    @FXML
    private JFXTextField idtc2;

    
    IUtilisateurs UserS = new UserService();
    
    public static Utilisateurs user;
    Stage stage;
    Parent root;

    public AuthentificationController() {
    }
    
 
    
      @FXML
    void ConnectionAction(ActionEvent event) throws IOException  {
       
         user = UserS.Authentication(idtc2.getText(), mdpc2.getText());
         
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/Home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                
        if (user!= null)
            {
                 
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show(); 
            
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Mot de passe ou pseudo incorrecte");
                alert.setContentText("Mot de passe ne correspond pas");
                alert.showAndWait();
               System.out.println("invalid");
            }
    }

    @FXML
    void SinscrireHyper(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
     private void loadSplashScreen() {
        try {
            Outdoors.isSplashLoaded = true;
            
            AnchorPane pane = FXMLLoader.load(getClass().getResource(("/edu/esprit/outdoors/gui/WelcomeScreen.fxml")));
            Inscription_Conex_Controller.rootcopy.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

//            fadeOut.setOnFinished((e) -> {
//                try {
//                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/edu/esprit/outdoors/gui/WelcomeScreen.fxml")));
//                    root.getChildren().setAll(parentContent);
//
//                } catch (IOException ex) {
//                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
//                } 
//                
//            });

        } catch (IOException ex) { 
        Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
