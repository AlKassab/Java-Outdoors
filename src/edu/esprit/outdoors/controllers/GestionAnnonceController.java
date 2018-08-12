/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.sun.prism.impl.Disposer.Record;

import edu.esprit.outdoors.models.Annonce;
import edu.esprit.outdoors.services.AnnonceService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ASUS I7
 */
public class GestionAnnonceController implements Initializable {

    @FXML
    private TableView<Object> afficheA;
    @FXML
    private TableColumn<Object, String> TitreA;
    @FXML
    private TableColumn<Object, String> TypeA;
    @FXML
    private TableColumn<Object, String> DescA;
    @FXML
    private TableColumn<Object, Float> PrixA;
   
 private ObservableList<Object> items = FXCollections.observableArrayList();
    List <Annonce> liste;
   
   public static int idA;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AnnonceService as = new AnnonceService();
        items.clear();
        liste = new ArrayList<>();
        liste = as.getAll();
        
         for (Annonce a : liste) {
            
          System.out.println(a);
            items.add(a);
             }
         
           TitreA.setCellValueFactory(new PropertyValueFactory<>("nom") );
            TypeA.setCellValueFactory(new PropertyValueFactory<>("type") );
             DescA.setCellValueFactory(new PropertyValueFactory<>("description") );
              PrixA.setCellValueFactory(new PropertyValueFactory<>("prix") );
             
                TableColumn plusinfo = new TableColumn<>("PLUS INFO");
                 afficheA.getColumns().add(plusinfo);
                 plusinfo.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
                 plusinfo.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell();
            }
        
        });
              afficheA.setItems(items);
             
            
              
               
    }    

    @FXML
    private void ajouterAnnonce(ActionEvent event) {
        try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/AjouterAnnonce.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void consulterMesAnnonce(ActionEvent event) {
          try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/MesAnnonces.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }

    @FXML
    private void rechercheAnnonce(ActionEvent event) {
        try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/RechercheAnnonce.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    
     private  class ButtonCell extends TableCell<Record, Boolean> {

        Button cellButton = new Button("plus info");
   
        
        ButtonCell(){
            
        	//Action when the button is pressed
            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent event) {
                    // get Selected Item
                    Annonce currentA=(Annonce) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                   idA= currentA.getIdAnnonce();
                   AnnonceService AS = new AnnonceService();
                  AS.getInfo(currentA.getIdAnnonce());
                  
                  try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/InfoAnnonce.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
          
                    	
                }
            });
               
          
               
    }
        //Display button if the row is not empty
@Override
protected void updateItem(Boolean t, boolean empty) {
super.updateItem(t, empty);
if(!empty){
setGraphic(cellButton);
}
else{
setGraphic(null);
}
}
    }

}
