/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.outdoors.models.Randonnees;
import edu.esprit.outdoors.services.RandoService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.util.converter.LocalDateTimeStringConverter;
import tray.animations.AnimationType;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class modifRandoController implements Initializable {

    @FXML
    private ComboBox<String> lieu;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXDatePicker heure;
    @FXML
    private JFXTextField klm;
    @FXML
    private JFXTextField alt;
    @FXML
    private ComboBox<String> type;
    @FXML
    private ComboBox<String> diff;
    @FXML
    private JFXTextField nbr;
    @FXML
    private JFXTextArea desc;
    @FXML
    private JFXTextField prix;
    @FXML
    private Button returnbtn;
    @FXML
    private ImageView MemImg;
    @FXML
    private Label t2;
    @FXML
    private Button cancelbtn;
    @FXML
    private ImageView MemImg1;
    @FXML
    private Label t21;
    @FXML
    private Button addbtn;
    @FXML
    private ImageView MemImg2;
    @FXML
    private Label t22;
    RandoService rs= new RandoService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                 ObservableList<String> optionsLieu = 
    FXCollections.observableArrayList(   
                    "Oued Zitoun",
                    "Djerba",
                    "Ain Draham",
                    "Tamerza",
                    "Zaghouan",
                    "Tozeur",
                    "Douz",
                    "Boukornine",
                    "Mides",
                    "Gafsa",
                    "Chott el jerid",
                    "Bouhedma",
                    "Tataouine",
                    "El Kala",
                    "El Haouaria",
                    "Matmata",
                    "Nafta",
                    "Chenini",
                    "Korbous",
                    "Tabarka",
                    "Kebili",
                    "Ksar Hadada",
                    "Tinija",
                    "Jbil"
    );
                                            ObservableList<String> optionsDiff = 
    FXCollections.observableArrayList(   
                    "Facile",
                    "Moyenne",
                    "Difficle"
    );
                                                                 ObservableList<String> optionsType = 
    FXCollections.observableArrayList(   
                    "A pied",
                    "En vélo"
    );
                       
            lieu.setItems(optionsLieu);
             type.setItems(optionsType);
             diff.setItems(optionsDiff);
             
             lieu.setValue(mesRandoController.rr.getLieu());
             type.setValue(mesRandoController.rr.getType());
             diff.setValue(mesRandoController.rr.getDifficulte());
             desc.setText(mesRandoController.rr.getDescription());
             prix.setText(String.valueOf(mesRandoController.rr.getPrix()));
             alt.setText(String.valueOf(mesRandoController.rr.getAltitude()));
             klm.setText(String.valueOf(mesRandoController.rr.getKilometrage()));
             Date in = (Date) mesRandoController.rr.getDate();
            heure.setTime(LocalTime.parse(mesRandoController.rr.getHeure()));
            
            date.setValue(in.toLocalDate());
             nbr.setText(String.valueOf(mesRandoController.rr.getNb_randonneur()));
             
             
        
    }    

    

    @FXML
    private void ReturnAction(ActionEvent event) {
         try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/mesRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void CancelAction(ActionEvent event) {
         lieu.setValue(mesRandoController.rr.getLieu());
             type.setValue(mesRandoController.rr.getType());
             diff.setValue(mesRandoController.rr.getDifficulte());
             desc.setText(mesRandoController.rr.getDescription());
             prix.setText(String.valueOf(mesRandoController.rr.getPrix()));
             alt.setText(String.valueOf(mesRandoController.rr.getAltitude()));
             klm.setText(String.valueOf(mesRandoController.rr.getKilometrage()));
             Date in = (Date) mesRandoController.rr.getDate();
            heure.setTime(LocalTime.parse(mesRandoController.rr.getHeure()));
            date.setValue(in.toLocalDate());
             nbr.setText(String.valueOf(mesRandoController.rr.getNb_randonneur()));
    }

    @FXML
    private void AddAction(ActionEvent event) {
      Randonnees r= new Randonnees();
       
        
        LocalDate ld= date.getValue();        
        Date dateRando =Date.valueOf(ld);
        LocalTime lt= heure.getTime();
        Time heureR= Time.valueOf(lt);
        
        
//        
//        java.util.Date daa= new java.util.Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
//        java.sql.Date sDate1 = new java.sql.Date(daa.getTime());

        r.setLieu((String) lieu.getValue());
        r.setDate(dateRando);
        r.setDescription(desc.getText());
        r.setPrix(Float.parseFloat(prix.getText()));
        r.setHeure(heureR.toString());
        r.setKilometrage(Float.parseFloat(klm.getText()));
        r.setAltitude(Float.parseFloat(alt.getText()));
        r.setNb_randonneur(Integer.parseInt(nbr.getText()));
        r.setType((String) type.getValue());
        r.setDifficulte((String) diff.getValue());
        r.setId_ran(mesRandoController.rr.getId_ran());
     
        rs.modify(r);
        tray.notification.TrayNotification tr = new tray.notification.TrayNotification();
                tr.setTitle("Modification");
                tr.setMessage("cette randonnée a été bien modifiée" );
                tr.setNotificationType(NotificationType.SUCCESS);
                tr.setAnimationType(AnimationType.POPUP);
                tr.showAndDismiss(Duration.seconds(5));
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/mesRando.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                
    }

    @FXML
    private void changecolorOnExit2(MouseEvent event) {
    }

    @FXML
    private void changecolorOnEnter2(MouseEvent event) {
    }
    
}
