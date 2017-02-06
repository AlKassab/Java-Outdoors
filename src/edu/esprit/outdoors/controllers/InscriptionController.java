/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.services.UserService;
import edu.esprit.outdoors.utils.Enum.Gouvernorat;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

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
    private ComboBox<String> govc;

    @FXML
    private JFXPasswordField mdpc2;

    @FXML
    private JFXPasswordField mdpc;

    @FXML
    private JFXTextField idtc;

    @FXML
    private JFXButton btn;
    
    UserService UserS = new UserService();
    
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
    void SinscrireAction(ActionEvent event) {
        
         Utilisateurs u  = new Utilisateurs();
         Profil p = new Profil();
         
       p.setNom(nomc.getText());
       p.setGouvernorat(Gouvernorat.valueOf(govc.getValue()));
       u.setEmail(emailc.getText());
       u.setId_Ut(idtc.getText());
       u.setMot_passe(mdpc.getText());
       
       if ((validateEmail(emailc.getText()))== true &&(confirmPassW(mdpc.getText(),mdpc2.getText()))==true){
       UserS.add(u,p);
       }else{
       System.out.println("mail invalid ou mot de passe nest pas le meme");
       }
       
        
        

    }

    @FXML
    void SinscrireHyper(ActionEvent event) {

    }
    
    private boolean validateEmail(String email){
    
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
 
    Matcher matcher = pattern.matcher(email);
    return matcher.find();
 
    }
    
    private boolean confirmPassW(String pass,String passc){
    
    return pass.equals(passc);
    }
    
}
