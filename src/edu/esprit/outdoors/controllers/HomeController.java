/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author WILLIAM
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
@FXML
    private ImageView logoC;

    @FXML
    private JFXHamburger HamC;

    @FXML
    private TextField rechC;

    @FXML
    private Label messNum;

    @FXML
    private Label notifNum;

    @FXML
    private Label lblUsrName;

    @FXML
    private Circle imgUsrTop;

    @FXML
    private JFXDrawer DrawerC;
    
     UserService UserS ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/DrawerMenuHome.fxml"));
            DrawerC.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(HamC);
        transition.setRate(-1);
        HamC.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            
            if(DrawerC.isShown())
            {
                DrawerC.close();
            }else
                DrawerC.open();
        });
        
     
       
        
    }    
    
    
     @FXML
    void ReturnHome(MouseEvent event) {
        
        
    }

    @FXML
    void openMessFromtopBar(MouseEvent event) {

    }

    @FXML
    void openNotifFromtopBar(MouseEvent event) {

    }
}
