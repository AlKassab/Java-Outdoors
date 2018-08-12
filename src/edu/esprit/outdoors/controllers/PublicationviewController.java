/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import edu.esprit.outdoors.models.Photo;
import edu.esprit.outdoors.models.Publication;
import edu.esprit.outdoors.services.PhotoService;
import edu.esprit.outdoors.services.ProfilServices;
import edu.esprit.outdoors.services.PublicationService;
import edu.esprit.outdoors.services.UserService;
import edu.esprit.outdoors.utils.Notifications;
import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author WILLIAM
 */
public class PublicationviewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextArea text;

    @FXML
    private Label nameFile;
    
     @FXML
    private Button uimage;
     
     @FXML
    private Button publierId;


    
    PublicationService PubS = new PublicationService();
    final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    final Stage stage = new Stage();
    private Image image ;
    UserService UserS = new UserService();
    ProfilServices PS = new ProfilServices();
    PhotoService PhS = new PhotoService();
    static File selected;
    
    
    public void setSelected(File f){
        selected = f;
    }
    
    @FXML
    void publier(ActionEvent event) throws InterruptedException {
        
        //System.out.println(selected.getName());
          if (selected != null) {
                       // openFile(file);
                       
                         PhS.addwith(new Photo(text.getText(),AuthentificationController.user.getProfil()),selected);
                       Notifications.notifApi("Terminé", "Publication publiée avec succees");
                       text.clear();
                       PublicationInProfilController.listPubcopy.refresh();
                       HomePublicationController.listPubcopy.refresh();
                    }else{
          //System.out.println("....insert into publication table");
          Publication pub = new Publication(text.getText(),AuthentificationController.user.getProfil());
         
          PubS.add(pub);
          Notifications.notifApi("Terminé", "Publication publiée avec succees");
          text.clear();
          PublicationInProfilController.listPubcopy.refresh();
          HomePublicationController.listPubcopy.refresh();
          
         }
          
          
          
       
        
        
    }

    @FXML
    void uploadImage(ActionEvent event) {

        File file = fileChooser.showOpenDialog(stage);
        nameFile.setText(file.getName());
        setSelected(file);
    }
    

    @FXML
    void uploadVideo(ActionEvent event) {

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        text.setFont(Font.font("Typografix-demo", 15));
        
        }
        
        
        
}    
    
