/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import edu.esprit.outdoors.iservices.IUtilisateurs;
import edu.esprit.outdoors.iservices.Iprofil;
import edu.esprit.outdoors.services.ProfilServices;
import edu.esprit.outdoors.services.UserService;
import edu.esprit.outdoors.utils.Notifications;
import edu.esprit.outdoors.utils.Validator;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author WILLIAM
 */
public class ModifierCompteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //Validator validitor
    IUtilisateurs UserS = new UserService();
    Iprofil Ps = new ProfilServices();
    
      @FXML
    private Button descbtn;

    @FXML
    private Button passbtn;

    @FXML
    private Button mailbtn;
    @FXML
    private Button namebtn;

    @FXML
    private Button telbtn;
 
    @FXML
    private Button govbtn;
    
    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private PasswordField passactu;

    @FXML
    private PasswordField nvpass;

    @FXML
    private PasswordField nvpassc;

   @FXML
    private ComboBox<String> gouvernorat;

    @FXML
    private TextField tel;

    @FXML
    private TextArea bio;
    
    
    

    @FXML
    void changerdesc(ActionEvent event) {
        bio.setEditable(true);
        descbtn.setVisible(true);
    }


    @FXML
    void changermail(ActionEvent event) {
    email.setEditable(true);
    mailbtn.setVisible(true);

    }

    @FXML
    void changername(ActionEvent event) {
        name.setEditable(true);
        namebtn.setVisible(true);
    }

    @FXML
    void changerpass(ActionEvent event) {
        passactu.setVisible(true);
        nvpass.setVisible(true);
        nvpassc.setVisible(true);
        passbtn.setVisible(true);
    }

    @FXML
    void changertel(ActionEvent event) {
        tel.setEditable(true);
        telbtn.setVisible(true);
    }

    @FXML
    void guide(ActionEvent event) {

    }

    @FXML
    void savedesc(ActionEvent event) {
        
        Ps.updateInfo(bio.getText(), AuthentificationController.user.getProfil());
        Notifications.notifApi("Terminé", "A propos a ete modifié avec succes");
        

    }

    @FXML
    void savemail(ActionEvent event) throws SQLException {

        if((Validator.emailvalidator(email.getText()))==true && (UserS.checkforemail(email.getText()))==false)
        {
        UserS.updateEmail(email.getText(), AuthentificationController.user);
        Notifications.notifApi("Terminé", "L'adrresse e-mail a ete modifié avec succes");
        }else if (Validator.emailvalidator(email.getText())==false) {
        
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Email-format invalide");
        alert.setContentText("Adresse e-mail incorrecte");
        alert.showAndWait();
        
        }else if ((UserS.checkforemail(email.getText()))==true) {
            
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Email existe deja");
        alert.setContentText("SVP entrez une nouvelle Adresse e-mail");
        alert.showAndWait();
        
        }
        
        
    }

    @FXML
    void savename(ActionEvent event) {
        
        if ((Validator.nameSize(name.getText()))==true){
        Ps.updatename(name.getText(), AuthentificationController.user);
        Notifications.notifApi("Terminé", "Votre nom a ete modifié avec succes");
        }else {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Nom invalid");
        alert.setContentText("Le nom doit avoir minimum 3 caracteres");
        alert.showAndWait();
        }
        
        }

    @FXML
    void savepass(ActionEvent event) {
        
        if((Validator.passwwordVerification(nvpass.getText(), nvpassc.getText()))==true&&(Validator.passwwordVerification(passactu.getText(), AuthentificationController.user.getMot_passe()))==true){
        UserS.updatepass(nvpass.getText(), AuthentificationController.user);
        Notifications.notifApi("Terminé", "Mot de passe a ete modifié avec succes");
        }else if ((Validator.passwwordVerification(passactu.getText(), AuthentificationController.user.getMot_passe()))==false){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Mot de passe incorrecte");
        alert.setContentText("Mot de passe ne correspond pas");
        alert.showAndWait();
        }else if ((Validator.passwwordVerification(nvpass.getText(), nvpassc.getText()))==false){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Mot de passe ne sont pas identique");
        alert.setContentText("Mot de passe ne sont pas identique");
        alert.showAndWait();
        }

    }

    @FXML
    void savetel(ActionEvent event) {

        Ps.updateTel(Long.valueOf(tel.getText()), AuthentificationController.user.getProfil());
        Notifications.notifApi("Terminé", "Numero telephone a ete modifié avec succes");
    }

    @FXML
    void supprimercompte(ActionEvent event) {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
       alert.setTitle("Attention");
       alert.setHeaderText("Attention vous êtes entrain de supprimer votre compte");
       alert.setContentText("Vous etes sure?");

       Optional<ButtonType> result = alert.showAndWait();
       if (result.get() == ButtonType.OK){
    // ... user chose OK
        UserS.DeleteAccount(AuthentificationController.user.getId_user());
        System.exit(0);
       } else {
    // ... user chose CANCEL or closed the dialog
       }
        

    }
    
     @FXML
    void savegov(ActionEvent event) {
        
   Ps.updateGov(gouvernorat.getValue(), AuthentificationController.user.getProfil());
   Notifications.notifApi("Terminé", "Gouvernorat a ete modifié avec succes");

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         gouvernorat.setCellFactory(param -> new ListCell<String>() {
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
           
   gouvernorat.setItems(options);
        
        
        
        
         gouvernorat.valueProperty().addListener(new ChangeListener<String>() {

        @Override
        public void changed(ObservableValue<? extends String> ov, String t, String t1) {
       
        if(!t.equals(t1)){
        govbtn.setVisible(true);
        }
        }
    });
        
        
        
      
        name.setText(AuthentificationController.user.getNom()+" "+AuthentificationController.user.getPrenom());
        email.setText(AuthentificationController.user.getEmail());
        gouvernorat.setPromptText(AuthentificationController.user.getProfil().getGouvernorat());
        tel.setText(String.valueOf(AuthentificationController.user.getProfil().getTel()));
        bio.setText(AuthentificationController.user.getProfil().getDetail());
        
        
    }    
    
}
