/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

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
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author WILLIAM
 */
public class ProfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
 
    @FXML
    private AnchorPane cover;

    @FXML
    private AnchorPane profilePane;

    @FXML
    private AnchorPane containerprofil;

    @FXML
    private Label gouvernoratLabel;

    @FXML
    private AnchorPane profile2;

    @FXML
    private Label nameinprofile;
    
            public static Label gouvernoratLabelcpoy;
            public static Label nameinprofilecopy;
            public static AnchorPane covercopy;
            
    
    public static AnchorPane containerprofilcopy;
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
     //ObservableList<Object> pairList = FXCollections.observableArrayList();
     
  
    
    @FXML
    void changerCover(ActionEvent event) {
        
        File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                       // openFile(file);
                        Photo photo = new Photo();
                        PS.insertcoverToDb(file, AuthentificationController.user.getProfil());
                         image = new Image(file.toURI().toString());
                        BackgroundSize bz = new BackgroundSize(1600, 390, false, false, true, true);
                         BackgroundImage myBI= new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,bz);
                         cover.setBackground(new Background(myBI));
                         
                    }
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        containerprofilcopy = containerprofil;
        gouvernoratLabelcpoy = gouvernoratLabel;
        nameinprofilecopy = nameinprofile;
        covercopy = cover;
        
        
                         BackgroundSize bz = new BackgroundSize(1600, 390, false, false, true, true);
                         BackgroundImage myBI= new BackgroundImage(AuthentificationController.user.getProfil().getPhoto_cover(), BackgroundRepeat.ROUND,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,bz);
                         cover.setBackground(new Background(myBI));
        
       
                         nameinprofile.setText(AuthentificationController.user.getPrenom()+" "+AuthentificationController.user.getNom());
                         gouvernoratLabel.setText(AuthentificationController.user.getProfil().getGouvernorat());
       
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/profileitem2.fxml"));
            profile2.getChildren().add(anchorPane);
                    
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try {
            AnchorPane pub = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/PublicationInProfil.fxml"));
            containerprofil.getChildren().add(pub);
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        }
    
    
    
   
    
    
}
