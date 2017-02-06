/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import edu.esprit.outdoors.controllers.HomeController;
import edu.esprit.outdoors.services.UserService;
import static edu.esprit.outdoors.services.UserService.user;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import edu.esprit.outdoors.controllers.AuthentificationController;
import javafx.fxml.FXMLLoader;

/**
 * FXML Controller class
 *
 * @author WILLIAM
 */
public class DrawerMenuHomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
   AuthentificationController auto = new AuthentificationController();
    
    @FXML
    private Circle imgTL;

    @FXML
    private Button AccBtn;

    @FXML
    private ImageView AccImg;

    @FXML
    private Label t1;

    @FXML
    private Button MemBtn;

    @FXML
    private ImageView MemImg;

    @FXML
    private Label t2;

    @FXML
    private Button RonBtn;

    @FXML
    private ImageView RonImg;

    @FXML
    private Label t3;

    @FXML
    private Button CamBtn;

    @FXML
    private ImageView CamImg;

    @FXML
    private Label t4;

    @FXML
    private Button AnnBtn;

    @FXML
    private ImageView AnnImg;

    @FXML
    private Label t5;

    @FXML
    private Button AprpBtn;

    @FXML
    private ImageView AprpImg;

    @FXML
    private Label t6;
    
    @FXML
    private Label myname;
     
    Image image = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/homew.png"));
    Image image1 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/userw.png"));
    Image image2 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/hikew.png"));
    Image image3 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/campingw.png"));
    Image image4 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/annoncew.png"));
    Image image5 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/aproposw.png"));
    Image image0 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/home.png"));
    Image image11 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/user.png"));
    Image image22 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/hike.png"));
    Image image33 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/camping.png"));
    Image image44 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/annonce.png"));
    Image image55 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/apropos.png"));

        

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        myname.setText(AuthentificationController.user.getProfil().getNom());
        
    }   
    
    
       @FXML
    void AcceuilAction(ActionEvent event) {
       
       
        
    }

    @FXML
    void AnnonceAction(ActionEvent event) {

    }

    @FXML
    void AproposAction(ActionEvent event) {

    }

    @FXML
    void CampingAction(ActionEvent event) {

    }

    @FXML
    void MembreAction(ActionEvent event) {

    }

    @FXML
    void RondonneAction(ActionEvent event) {

    }

    
      @FXML
    void changecolorOnEnter1(MouseEvent event) {
         AccImg.setImage(image);
        t1.setStyle("-fx-text-fill: white;");
    }

    @FXML
    void changecolorOnEnter2(MouseEvent event) {
         MemImg.setImage(image1);
        t2.setStyle("-fx-text-fill: white;");
    }

    @FXML
    void changecolorOnEnter3(MouseEvent event) {
         RonImg.setImage(image2);
        t3.setStyle("-fx-text-fill: white;");
    }

    @FXML
    void changecolorOnEnter4(MouseEvent event) {
         CamImg.setImage(image3);
        t4.setStyle("-fx-text-fill: white;");
    }

    @FXML
    void changecolorOnEnter5(MouseEvent event) {
         AnnImg.setImage(image4);
        t5.setStyle("-fx-text-fill: white;");
    }

    @FXML
    void changecolorOnEnter6(MouseEvent event) {
         AprpImg.setImage(image5);
        t6.setStyle("-fx-text-fill: white;");
    }

    @FXML
    void changecolorOnExit1(MouseEvent event) {
         AccImg.setImage(image0);
        t1.setStyle("-fx-text-fill: #cbcbcb;");
    }

    @FXML
    void changecolorOnExit2(MouseEvent event) {
         MemImg.setImage(image11);
        t2.setStyle("-fx-text-fill: #cbcbcb;");
    }

    @FXML
    void changecolorOnExit3(MouseEvent event) {
         RonImg.setImage(image22);
        t3.setStyle("-fx-text-fill: #cbcbcb;");
    }

    @FXML
    void changecolorOnExit4(MouseEvent event) {
         CamImg.setImage(image33);
        t4.setStyle("-fx-text-fill: #cbcbcb;");
    }

    @FXML
    void changecolorOnExit5(MouseEvent event) {
         AnnImg.setImage(image44);
        t5.setStyle("-fx-text-fill: #cbcbcb;");
    }

    @FXML
    void changecolorOnExit6(MouseEvent event) {
         AprpImg.setImage(image55);
        t6.setStyle("-fx-text-fill: #cbcbcb;");
    }

    
}
