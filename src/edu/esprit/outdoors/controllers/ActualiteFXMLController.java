/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hassen
 */
public class ActualiteFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane lalo;
    
    @FXML
    private Button ajouter;
    
    @FXML
    private Button modifier;
    
    @FXML
    private Button supprimer;
    
    
    @FXML
    void doAjouter(ActionEvent event) throws IOException {
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/ACT_create.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  

    }
    
    @FXML
    void doModifier(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/ACT_update.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  

    }
    
    @FXML
    void doSupprimer(ActionEvent event) throws IOException {
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/ACT_delete.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
