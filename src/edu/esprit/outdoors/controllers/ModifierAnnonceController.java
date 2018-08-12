/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;


import edu.esprit.outdoors.models.Annonce;
import edu.esprit.outdoors.services.AnnonceService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ASUS I7
 */
public class ModifierAnnonceController implements Initializable {
ObservableList<String> typeA = FXCollections.observableArrayList("vente","location");
       ObservableList<String> etatA = FXCollections.observableArrayList("nouveau","occasion");
    @FXML
    private ImageView newImg;
    @FXML
    private Button modImg;
    @FXML
    private TextArea desc;
    @FXML
    private TextField prix;
    @FXML
    private TextField nom;
    @FXML
    private ComboBox type;
    @FXML
    private ComboBox etat;
    @FXML
    private AnchorPane m1;
    private String filePath = "";
   InputStream fileStream;
    @FXML
    private TextField urlimg;
    AnnonceService AS = new AnnonceService();
 
public ModifierAnnonceController() {
    }

    public void setNewImg(Image img) {
       newImg.setImage(img);
    }

    
    public void setDesc(String description) {
        desc.setText(description);
    }

    public void setPrix(String prixA) {
        prix.setText(prixA);
    }

    public void setNom(String nomA) {
        nom.setText(nomA);
    }
    
    public void setUrl(String urlA)
    {
    urlimg.setText(urlA);}
    
    
    

 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
              

        type.setItems(typeA);
        etat.setItems(etatA);
        
         modImg.setOnAction(event -> {
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
                   
                    newImg.setImage(img);
                    
                    
                } catch (FileNotFoundException ex) {
                    System.out.println("erreur lors de la mise à jour " + ex.getMessage());
                }
            }
           
        });
    }
private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
public String datenow;
 Date date;
    @FXML
    private void modifierAnnonce(ActionEvent event) {
        
        if (((String)type.getValue()!= "") && ((String)type.getValue()!= "")){
            date = new Date();
        
        datenow = sdf.format(date);
        Annonce a = new Annonce(nom.getText(),(String)type.getValue(), desc.getText(),Float.parseFloat(prix.getText()), datenow,(String)etat.getValue() ,urlimg.getText() );
      
        AS.modify(a, MesAnnoncesController.i);
          try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/MesAnnonces.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                } }
        else {
         Alert dialog = new Alert(Alert.AlertType.INFORMATION);
dialog.setTitle("An information dialog-box");
//dialog.setHeaderText("An information dialog with header");
dialog.setContentText("Remplir le champs Type et Etat SVB ");
dialog.showAndWait();
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
    
}
