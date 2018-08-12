/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Ahmed Samti
 */
public class InvitationsController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private AnchorPane bd1;
     
    @FXML
    private BorderPane border;

    @FXML
    private TableView<?> invittable;

    @FXML
    private TableColumn<?, ?> campColumn;

    @FXML
    private TableColumn<?, ?> OrganColumn;

    @FXML
    private AnchorPane details;

    @FXML
    private GridPane listdetails;

    @FXML
    private Label nom;

    @FXML
    private Label lieu;

    @FXML
    private Label date;

    @FXML
    private Label description;

    @FXML
    private Label organisateur;

    @FXML
    private Label invités;

    @FXML
    private Button participation;

    @FXML
    private Button suppression;

    @FXML
    void participer(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
