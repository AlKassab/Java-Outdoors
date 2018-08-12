/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import edu.esprit.outdoors.iservices.IPhoto;
import edu.esprit.outdoors.iservices.IPublication;
import edu.esprit.outdoors.services.PhotoService;
import edu.esprit.outdoors.services.ProfilServices;
import edu.esprit.outdoors.services.PublicationService;
import edu.esprit.outdoors.services.UserService;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author WILLIAM
 */
public class Profileitem2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
 @FXML
    private ImageView threeStar;

    @FXML
    private ImageView fivestar;

    @FXML
    private ImageView oneStar;

    @FXML
    private MenuButton optiontprofile;

    @FXML
    private Label nbrabones;

    @FXML
    private ToggleButton followbtn;

    @FXML
    private Label nbrAvis;

    @FXML
    private AnchorPane anchorprofile;

    @FXML
    private AnchorPane ImgContainer;

    @FXML
    private ImageView fourstar;

    @FXML
    private MenuButton optiontouser;

    @FXML
    private ImageView twoStar;

    @FXML
    private TableColumn<?, ?> avistable;

    @FXML
    private Pane profilpic;

    @FXML
    private Label nbrAbonemnt;

 

    public static Label nbrabonescopy;
    public static Label nbrAbonemntcopy;
    public static Pane profilpiccopy;
    public static ToggleButton followbtncopy;
    public static MenuButton optiontousercopy;
    public static MenuButton optiontprofilecopy;
    
    
    final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    final Stage stage = new Stage();
    private Image image ;
    UserService UserS = new UserService();
    ProfilServices PS = new ProfilServices();
    
    IPublication PubS = new PublicationService();
   
    IPhoto PhS = new PhotoService();

    @FXML
    void Invite(ActionEvent event) {

    }

    @FXML
    void MesCamping(ActionEvent event) {

    }

    @FXML
    void MesRond(ActionEvent event) {

    }

    @FXML
    void Sendmess(ActionEvent event) {

    }

    @FXML
    void Settings(ActionEvent event) throws IOException {
        
                    
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/ModifierCompte.fxml")); 
        ProfileController.containerprofilcopy.getChildren().setAll(pane);
        //HomeController.scollfromhomep.setContent(pane);

    }

    @FXML
    void Signaler(ActionEvent event) {

    }

    @FXML
    void bloquer(ActionEvent event) {

    }


    @FXML
    void chnagerphoto(ActionEvent event) {
        
        File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                       // openFile(file);
                        
                        PS.insertImageToDb(file, AuthentificationController.user.getProfil());
                         image = new Image(file.toURI().toString());
                         BackgroundSize bz = new BackgroundSize(301, 316, false, false, false, true);
                         BackgroundImage myBI= new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,bz);
                         profilpic.setBackground(new Background(myBI));
                         
                         
                    }

    }

    @FXML
    void followBtn(ActionEvent event) {

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       nbrabonescopy = nbrabones;
       nbrAbonemntcopy = nbrAbonemnt;
       profilpiccopy = profilpic;
       followbtncopy = followbtn;
       optiontousercopy = optiontouser;
       optiontprofilecopy = optiontprofile;
       
       followbtn.setVisible(false);
        
        BackgroundSize bz = new BackgroundSize(301, 316, false, false, false, true);
        BackgroundImage myBI= new BackgroundImage(AuthentificationController.user.getProfil().getPhoto_profil(), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,bz);
        profilpic.setBackground(new Background(myBI));
        
        
        
        
        
        
        
    }    
    
    
    
     private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                ProfileController.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
}
