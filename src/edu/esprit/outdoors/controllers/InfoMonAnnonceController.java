/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import com.sun.prism.impl.Disposer;
import static edu.esprit.outdoors.controllers.GestionAnnonceController.idA;
import static edu.esprit.outdoors.controllers.MesAnnoncesController.i;
import static edu.esprit.outdoors.controllers.MesAnnoncesController.idAnSelected;
import edu.esprit.outdoors.models.Annonce;
import edu.esprit.outdoors.models.Feed;
import edu.esprit.outdoors.services.AnnonceService;
import edu.esprit.outdoors.services.UserService;
import edu.esprit.outdoors.technique.HTTPXML;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import edu.esprit.outdoors.technique.HTTPXML;
import java.awt.Desktop;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author ASUS I7
 */
public class InfoMonAnnonceController implements Initializable {
public HTTPXML httpxml = new HTTPXML();
    @FXML
    private ImageView showImg;
    @FXML
    private TextField Nom;
    @FXML
    private JFXTextArea Desc;
    
    @FXML
    private TextField date;
    @FXML
    private TextField PrixA;
 
   
    @FXML
    private TableView<Feed> tableV;
    @FXML
    private TableColumn<Object,String> titre;
    @FXML
    private TableColumn<Object, String> lien;
   private ObservableList<Feed> items = FXCollections.observableArrayList();
    List <Annonce> liste;
    
     int index;
    @FXML
    private TextField type;
    @FXML
    private TextField etat;
    @FXML
    private TextField dateM;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       AnnonceService AS = new AnnonceService();
        UserService US = new UserService();
         items.clear();
        liste = new ArrayList<>();
        
         try {
            httpxml.start("http://www.lerepairedesmotards.com/forum/feed.php?3,1017438,type=rss");
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }
         
          for (Feed f : HTTPXML.feedList) {
               
             
                 
                 items.add(f);
} 

            
         
          
          titre.setCellValueFactory(new PropertyValueFactory<>("title") );
          
            lien.setCellValueFactory(new PropertyValueFactory<>("link") );
            
           
                   
            
        tableV.setItems(items);
        
            tableV.setOnMousePressed(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent event) {
            if (event.isPrimaryButtonDown() && event.getClickCount()==2){
               String value;
               value= lien.getCellData(tableV.getSelectionModel().getFocusedIndex());
//List selectedItems = tableV.getSelectionModel().getSelectedItems();
                
                try {
                    Desktop.getDesktop().browse(new URI(value));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(InfoMonAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(InfoMonAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
                }
               


             
               
            }
         }
     }
     
     );
     
     
         Annonce a=AS.getInfo(MesAnnoncesController.idAnSelected);
          float prix= a.getPrix();
          String sPrix = Float.toString(prix);
        File f = new File(a.getImage());
                    Image img1 = new Image(f.toURI().toString());
                    showImg.setImage(img1);
        Nom.setText(a.getNom());
        Desc.setText(a.getDescription());
        PrixA.setText(sPrix);
        date.setText(a.getDatePub());
        type.setText(a.getType());
        etat.setText(a.getEtat());
        dateM.setText(a.getDateModif());
        
        
         
         
    }  
    
 
 
}

