/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static edu.esprit.outdoors.controllers.AuthentificationController.user;
import edu.esprit.outdoors.iservices.IUtilisateurs;
import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.services.UserService;
import edu.esprit.outdoors.utils.Notifications;
import edu.esprit.outdoors.utils.Validator;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author WILLIAM
 */


    


public class InscriptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private JFXTextField emailc;

    @FXML
    private JFXTextField nomc;
    
     @FXML
    private JFXTextField prenomc;

    @FXML
    private ComboBox<String> govc;

    @FXML
    private JFXPasswordField mdpc2;

    @FXML
    private JFXPasswordField mdpc;

    @FXML
    private JFXTextField idtc;

    @FXML
    private JFXButton btn;
    
    
    IUtilisateurs UserS = new UserService();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        govc.setCellFactory(param -> new ListCell<String>() {
    {
        setTextFill(Color.WHITE);

        Background blackBackground = new Background(new BackgroundFill(Color.rgb(77, 77, 77), null, null));
        Background greenBackground = new Background(new BackgroundFill(Color.rgb(129, 170, 42), null, null));

        
        
        setBackground(blackBackground);
        setOnMouseEntered(event -> {
            setBackground(greenBackground);
        });
        setOnMouseExited(event -> {
            setBackground(blackBackground);
        });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            return;
        }
        setText(item);
    }
});
            
            ObservableList<String> options = 
    FXCollections.observableArrayList(   
          "Ariana",
          "Beja" ,
          "Ben_Arous",
          "Bizerte", 
          "Gabès" ,
          "Gafsa" ,
          "Jendouba" ,
          "Kairouan" ,
          "Kasserine", 
          "Kébili" ,
          "La_Mannouba" ,
          "Le_Kef" ,
          "Mahdia" ,
          "Médinine", 
          "Monastir" ,
          "Nabeul", 
          "Sfax" ,
          "Sidi Bouzid", 
          "Siliana" ,
          "Sousse" ,
          "Tataouine", 
          "Tozeur", 
          "Tunis", 
          "Zaghouan" 
    );
    
         //   options.setStyle("-fx-control-inner-background: blue;");
           
   govc.setItems(options);
        
        
    }
    
     @FXML
    void SinscrireAction(ActionEvent event) throws IOException, SQLException {
        
         Utilisateurs u  = new Utilisateurs();
         Profil p = new Profil();
         
         
       u.setNom(nomc.getText());
       u.setPrenom(prenomc.getText());
       p.setGouvernorat((govc.getValue()));
       u.setEmail(emailc.getText());
       u.setId_Ut(idtc.getText());
       u.setMot_passe(mdpc.getText());
       
       if (((Validator.emailvalidator(emailc.getText()))== true) &&((Validator.confirmPassW(mdpc.getText(),mdpc2.getText()))==true)&&(UserS.checkforusername(idtc.getText())==false)){
       UserS.add(u,p);
       AuthentificationController.user = u;
        Notifications.notifApi("Terminé", "Vous etes maintenant inscris");
       }else if (Validator.emailvalidator(emailc.getText())==false) {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Email-format invalide");
        alert.setContentText("Adresse e-mail incorrecte");
        alert.showAndWait();
        
        }else if (Validator.confirmPassW(mdpc.getText(),mdpc2.getText())==false) {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Mot de passe ne sont pas identique");
        alert.setContentText("Mot de passe ne sont pas identique");
        alert.showAndWait();
        
        }
       else if (UserS.checkforusername(idtc.getText())==true) {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Username deja existe");
        alert.setContentText("Choisir un autre username");
        alert.showAndWait();
        
        }
        
       
        
        

    }

    @FXML
    void SinscrireHyper(ActionEvent event) {

    }
    
    
}
