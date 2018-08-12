/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.outdoors.models.Actualites;
import edu.esprit.outdoors.services.ActualiteService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.management.Notification;
import org.controlsfx.control.Notifications;
import tray.notification.TrayNotification;


/**
 * FXML Controller class
 *
 * @author hassen
 */
public class ACT_createController implements Initializable {
    
    @FXML
    private AnchorPane updateDeleteForm1;

    @FXML
    private JFXTextField mytit1;

    @FXML
    private Pane taPane1;

    @FXML
    private JFXTextArea myta1;

    @FXML
    private Button ajouter;
    
    @FXML
    private AnchorPane updateDeleteForm;
    
    @FXML
    private Button update;

    @FXML
    private Button delete;
    
    
    @FXML
    private JFXTextField mytit;

    @FXML
    private JFXTextArea myta;
    
    @FXML
    private Pane taPane;
    
    
    @FXML
    private TableView<Object> advices;
    @FXML
    private TableColumn<Object, String> titre;
    @FXML
    private TableColumn<Object, String> conseil;
    
    
    private ObservableList<Object> items = FXCollections.observableArrayList();
    List<Actualites> liste ;


    @FXML
    private Button retour_create;
    
    @FXML
    private Button newbtn;
    
    @FXML
    private Label titreAj;

    @FXML
    private Label contenuAj;
    
    @FXML
    private Label titreUp;

    @FXML
    private Label contenuUp;
    public static ActualiteService actService =  new ActualiteService() ;


@FXML
    void doNew(ActionEvent event) {
        
          myta.setVisible(false);
          mytit.setVisible(false);
          taPane.setVisible(false);
          update.setVisible(false);
          delete.setVisible(false);
          updateDeleteForm.setVisible(false);
          titreUp.setVisible(false);
          contenuUp.setVisible(false);
          
          
          
          
          myta1.setVisible(true);
          mytit1.setVisible(true);
          taPane1.setVisible(true);
          ajouter.setVisible(true);
          updateDeleteForm1.setVisible(true);
          titreAj.setVisible(true);
          contenuAj.setVisible(true);
          
          myta1.setText("");
          mytit1.setText("");


    }

    @FXML
    void doRetour_create(ActionEvent event) throws IOException {
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/ActualiteFXML.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }

   
    
    
    
    @FXML
    void doUp(ActionEvent event) {
        
        actService.update(myta.getText(),mytit.getText());
        
        ActualiteService actService =  new ActualiteService() ;
        items.clear();
        liste = new ArrayList<>();
        liste = actService.myAdv();
        
         for (Actualites r : liste) {
            items.add(r);
             }
         
         titre.setCellValueFactory(new PropertyValueFactory<>("titre") );
         conseil.setCellValueFactory(new PropertyValueFactory<>("conseil") );
        
         advices.setItems(items);

    }


@FXML
    void doDel(ActionEvent event) {
        
      actService.delete(mytit.getText());
      
        items.clear();
        liste = new ArrayList<>();
        liste = actService.myAdv();
        
         for (Actualites r : liste) {
            items.add(r);
             }
         
         titre.setCellValueFactory(new PropertyValueFactory<>("titre") );
         conseil.setCellValueFactory(new PropertyValueFactory<>("conseil") );
        
         advices.setItems(items);
         
         myta.setText("");
         mytit.setText("");

    }


@FXML
    void doAj(ActionEvent event) {
        
        Actualites act = new Actualites(1, mytit1.getText() , myta1.getText());
        actService.add(act);


        items.clear();
        liste = new ArrayList<>();
        liste = actService.myAdv();
        
         for (Actualites r : liste) {
            items.add(r);
             }
         
         titre.setCellValueFactory(new PropertyValueFactory<>("titre") );
         conseil.setCellValueFactory(new PropertyValueFactory<>("conseil") );
        
         advices.setItems(items);
         
         
         myta1.setText("");
                 String title = mytit1.getText()+ " ajoutée";

         mytit1.setText("");
         
         
         
         
         
        String message = "Congratulations!";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();


    }
    
    
    
    
    @FXML
    void Show(MouseEvent event) {
          myta.setVisible(true);
          mytit.setVisible(true);
          taPane.setVisible(true);
          update.setVisible(true);
          delete.setVisible(true);
          updateDeleteForm.setVisible(true);
          titreUp.setVisible(true);
          contenuUp.setVisible(true);

        mytit.setText(titre.getCellData(advices.getSelectionModel().getFocusedIndex()));
        myta.setText(conseil.getCellData(advices.getSelectionModel().getFocusedIndex()));
        
        
        myta1.setVisible(false);
          mytit1.setVisible(false);
          taPane1.setVisible(false);
          ajouter.setVisible(false);
          updateDeleteForm1.setVisible(false);
          titreAj.setVisible(false);
          contenuAj.setVisible(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          myta.setVisible(false);
          mytit.setVisible(false);
          taPane.setVisible(false);
          update.setVisible(false);
          delete.setVisible(false);
          updateDeleteForm.setVisible(false);
          titreUp.setVisible(false);
          contenuUp.setVisible(false);
          
          
          
          
          myta1.setVisible(false);
          mytit1.setVisible(false);
          taPane1.setVisible(false);
          ajouter.setVisible(false);
          updateDeleteForm1.setVisible(false);
          titreAj.setVisible(false);
          contenuAj.setVisible(false);

        
        
        items.clear();
        liste = new ArrayList<>();
        liste = actService.myAdv();
        
         for (Actualites r : liste) {
            items.add(r);
             }
         
         titre.setCellValueFactory(new PropertyValueFactory<>("titre") );
         conseil.setCellValueFactory(new PropertyValueFactory<>("conseil") );
        
         advices.setItems(items);
         
         
        
        // TODO

        
    }    
    

    
}
