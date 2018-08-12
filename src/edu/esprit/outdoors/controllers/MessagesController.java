/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXTextArea;
import edu.esprit.outdoors.models.Message;
import edu.esprit.outdoors.services.MsgService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.TextFields;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author hassen
 */
public class MessagesController implements Initializable {

    @FXML
    private TextField des;

    @FXML
    private TextArea cnt;
    
    @FXML
    private TableView<Object> myMsgs;

    @FXML
    private TableColumn<Object, String> from;

    @FXML
    private TableColumn<Object, String> content;
    
    private ObservableList<Object> items = FXCollections.observableArrayList();
    List<Message> liste ;
    
    @FXML
    private Button show;
    @FXML
    private Button show2;
    
    int nbrM = 0;
    
    @FXML
    private Label title;
    
    @FXML
    private Label boss;
    
    @FXML
    private Label contenttt;
    
    @FXML
    private JFXTextArea repondTa;
    
    @FXML
    private AnchorPane bubArea;
    
    @FXML
    private Button repondBtn;
    
    @FXML
    private Label cmDes;

    @FXML
    private Label cmDnt;

    @FXML
    private Button cmBtn;
    
    @FXML
    private Button composerBtn;
    
    public static MsgService actService =  new MsgService() ;
    
    @FXML
    void composer(ActionEvent event) {
        
        cmDes.setVisible(true);
        des.setVisible(true);
        cmDnt.setVisible(true);
        cnt.setVisible(true);
        cmBtn.setVisible(true);
        composerBtn.setVisible(false);

    }
    
    @FXML
    void toktok(MouseEvent event) {
        
        bubArea.setVisible(true);
        
        boss.setText(from.getCellData(myMsgs.getSelectionModel().getFocusedIndex()) + " vous a envoyé un message");
        contenttt.setText(content.getCellData(myMsgs.getSelectionModel().getFocusedIndex()));
        
        if (from.getText().equals("De") == false){
            boss.setText("vous avez envoyé un message à "+from.getCellData(myMsgs.getSelectionModel().getFocusedIndex()));
            repondBtn.setText("Recontacter");
        }
        if (from.getText().equals("De")){
            repondBtn.setText("Repondre");
        }
         
    }
    
    @FXML
    void repond(ActionEvent event) {
        
        actService.SendMsg(repondTa.getText(), from.getCellData(myMsgs.getSelectionModel().getFocusedIndex()), AuthentificationController.user.getPrenom()+ AuthentificationController.user.getNom());
        
        des.setText("");
        cnt.setText("");
        
        String title = "Vous avez repondu à "+from.getCellData(myMsgs.getSelectionModel().getFocusedIndex());
        String message = "Congratulations!";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
        
        repondTa.setText("");

    }


@FXML
    void toMe(ActionEvent event) {
        
        
        
        myMsgs.setVisible (true);
        from.setText("De");
        
        items.clear();
        liste = new ArrayList<>();
        liste = actService.toMe(AuthentificationController.user.getPrenom()+ AuthentificationController.user.getNom());
        
         for (Message r : liste) {
            items.add(r);
             }
         
         from.setCellValueFactory(new PropertyValueFactory<>("expediteur") );
         content.setCellValueFactory(new PropertyValueFactory<>("contenu") );
        
         myMsgs.setItems(items);
         
    }
    
    @FXML
    void fromMe(ActionEvent event) {
        
        bubArea.setVisible(false);
        
        myMsgs.setVisible (true);
        from.setText("À");
        
        items.clear();
        liste = new ArrayList<>();
        liste = actService.fromMoi(AuthentificationController.user.getPrenom()+ AuthentificationController.user.getNom());
        
         for (Message r : liste) {
            items.add(r);
             }
         
         from.setCellValueFactory(new PropertyValueFactory<>("destinataire") );
         content.setCellValueFactory(new PropertyValueFactory<>("contenu") );
        
         myMsgs.setItems(items);
         
         
    }
    
  


    @FXML
    void doSend(ActionEvent event) {
        
        
        actService.SendMsg(cnt.getText(), des.getText(), AuthentificationController.user.getPrenom()+ AuthentificationController.user.getNom());
        
        des.setText("");
        cnt.setText("");
        
        String title = "Message bien envoyé";
        String message = "Congratulations!";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        cmDes.setVisible(false);
        des.setVisible(false);
        cmDnt.setVisible(false);
        cnt.setVisible(false);
        cmBtn.setVisible(false);
        
        
        boss.setText("");
        bubArea.setVisible(false);
        contenttt.setText("");
        
        //myMsgs.setVisible (false);
        
        
        List<String> tab = new ArrayList<String>();
        tab = actService.choisirDestinataire();
        TextFields.bindAutoCompletion(des, tab);
        
        
        
    }    
    
    
    
}
