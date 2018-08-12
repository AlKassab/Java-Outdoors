/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author WILLIAM
 */
public class PublicationResultController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public PublicationResultController() {
        
    }

    
     @FXML
    private Label titre;

    @FXML
    private TextArea text;

    @FXML
    private Label nbrCom;

    @FXML
    private Label date;

    @FXML
    private ImageView imgposter;

    @FXML
    private Label name;

    @FXML
    private AnchorPane AnchorComment;
    
    @FXML
    private AnchorPane comment;
    
    
    public void setTitre(String t){
    
        titre.setText(t);
    }
    
    public void setText(String t){
    
        text.setText(t);
    }
    
    public void setnbrCom(int n){
    
        nbrCom.setText(String.valueOf(n));
    }
    
    public void setdate(Date d){
    
        date.setText(d.toString());
    }
    
    public void setimage(Image t){
    
       imgposter.setImage(t);
    }
    
    public void setName(String t){
    
        name.setText(t);
    }
    public AnchorPane getAnchor(){
        
        return comment;
    
    }
    


    @FXML
    void afficherCommentaire(ActionEvent event) {

    }

    @FXML
    void modfier(ActionEvent event) {

    }

    @FXML
    void signaler(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
