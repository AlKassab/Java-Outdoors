/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import edu.esprit.outdoors.models.Annonce;
import edu.esprit.outdoors.services.AnnonceService;
import edu.esprit.outdoors.services.UserService;
import edu.esprit.outdoors.technique.ApiMail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ASUS I7
 */
public class AjouterAnnonceController implements Initializable {
      ObservableList<String> type = FXCollections.observableArrayList("vente","location");
       ObservableList<String> etat = FXCollections.observableArrayList("nouveau","occasion");
 private String filePath = "";
    @FXML
    private TextField titreA;
    @FXML
    private JFXComboBox typeA;
    @FXML
    private TextArea descA;
    @FXML
    private TextField prixA;
    @FXML
    private JFXComboBox etatA;
    @FXML
    private ImageView showimg;
    @FXML
    private JFXTextField urlimg;
    
    @FXML
    private Button ajouterImage;
    
     InputStream fileStream;
    
      AnnonceService AS = new AnnonceService();
      UserService US = new UserService();
      ApiMail m = new ApiMail();
private Image img ;
   
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       typeA.setItems(type);
        etatA.setItems(etat);
        
            ajouterImage.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
            fileChooser.setTitle("Choisir une image");
            
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                setFilePath(file.getPath());
                urlimg.setText(filePath);
                try {
                    fileStream = new FileInputStream(file);
                    File f = new File(urlimg.getText());
                    Image img = new Image(f.toURI().toString());
                   
                    showimg.setImage(img);
                    
                    
                } catch (FileNotFoundException ex) {
                    System.out.println("erreur lors de la mise à jour " + ex.getMessage());
                }
            }
           
        });
           
            
    }    


    @FXML
    private void reset(ActionEvent event) {
        typeA.getSelectionModel().clearSelection();
        etatA.getSelectionModel().clearSelection();
       titreA.clear();
        descA.clear();
        prixA.clear();
        urlimg.clear();
        
       
    }
private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
public String datenow;
 Date date;
    @FXML
    private void publier(ActionEvent event) {
        String mail="";
         date = new Date(); 
        datenow = sdf.format(date);
        
        Annonce a = new Annonce(titreA.getText(),(String)typeA.getValue(),descA.getText(),Float.parseFloat(prixA.getText()),datenow,datenow,(String)etatA.getValue(),urlimg.getText(),AuthentificationController.user.getId_user());
        AS.add(a);
        
        mail=US.SelectMail(AuthentificationController.user.getId_user());
        System.out.println(mail);
        String subject="";
        String msg="";
        
        subject="outdoors annonces";
        msg="Bonjour, \n Votre annonce à été publier avec succes. \nL'equipe de OutDoors vous remercie.\nCoridalment.";
        
        m.envoyermail(mail, subject, msg);
        
        Alert dialog = new Alert(AlertType.INFORMATION);
dialog.setTitle("An information dialog-box");
//dialog.setHeaderText("An information dialog with header");
dialog.setContentText("Votre Annonce à été ajouter\n " +
"Verifier votre boite mail");
dialog.showAndWait();

 typeA.getSelectionModel().clearSelection();
        etatA.getSelectionModel().clearSelection();
       titreA.clear();
        descA.clear();
        prixA.clear();
        urlimg.clear();
        
        
        try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/AjouterAnnonce.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
       
        
    
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @FXML
    private void afficherimg(ActionEvent event) {
        Image img = new Image(urlimg.getText());
        showimg.setImage(img);
    }
    
}
