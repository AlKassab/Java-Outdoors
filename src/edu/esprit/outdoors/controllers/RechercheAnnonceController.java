/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import static edu.esprit.outdoors.controllers.GestionAnnonceController.idA;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ASUS I7
 */
public class RechercheAnnonceController implements Initializable {

    @FXML
    private JFXTextField chTxt;
    @FXML
    private JFXComboBox type;
ObservableList<String> typeA = FXCollections.observableArrayList("vente","location");
    @FXML
    private TableView<Object> rech;
    @FXML
    private TableColumn<Object,String> nom;
    @FXML
    private TableColumn<Object,String> desc;
    @FXML
    private TableColumn<Object,Float> prix;
    @FXML
    private TableColumn<Object,String> typeAn;
    AnnonceService as = new AnnonceService();
    private ObservableList<Object> items = FXCollections.observableArrayList();
    List <Annonce> liste;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         type.setItems(typeA);
         
         
    chTxt.textProperty().addListener((observable, oldValue, newValue) -> { 
      //rech.refresh();
      items.clear();
        liste = new ArrayList<>();
        liste = as.RechercheAnnonce(newValue, (String)type.getValue());
        
         for (Annonce a : liste) {
            
          System.out.println(a);
            items.add(a);
             }
         
            nom.setCellValueFactory(new PropertyValueFactory<>("nom") );
            typeAn.setCellValueFactory(new PropertyValueFactory<>("type") );
             desc.setCellValueFactory(new PropertyValueFactory<>("description") );
              prix.setCellValueFactory(new PropertyValueFactory<>("prix") );
              TableColumn plusinfo = new TableColumn<>("PLUS INFO");
              
              
               rech.getColumns().add(plusinfo);
                 plusinfo.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
                 plusinfo.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new RechercheAnnonceController.ButtonCell();
            }
        
        });
                 rech.refresh();
         rech.setItems(items);
 
});
    
    
} 
 private  class ButtonCell extends TableCell<Disposer.Record, Boolean> {

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
