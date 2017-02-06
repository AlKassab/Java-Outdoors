/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    UserService UserS = new UserService();
    static Utilisateurs user;
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
    
}
