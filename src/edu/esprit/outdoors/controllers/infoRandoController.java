/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.jfoenix.controls.JFXButton;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import edu.esprit.outdoors.services.RandoService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class infoRandoController implements Initializable, MapComponentInitializedListener {

    @FXML
    private Label lieu;
    @FXML
    private Label date;
    @FXML
    private Label type;
    @FXML
    private Label diff;
    @FXML
    private Label klm;
    @FXML
    private Label alt;
    @FXML
    private Label desc;
    @FXML
    private Label nbr;
    @FXML
    private Label prix;
    @FXML
    private Label org;
    @FXML
    private JFXButton retourner;
    @FXML
    private JFXButton participer;
    @FXML
    private GoogleMapView mapView;
    private GoogleMap map;
    private Marker marker; 
    RandoService rs= new RandoService();
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lieu.setText("Lieu: "+rs.getInfo(lstRandoController.rr.getId_ran()).getLieu());
        date.setText("Date: "+rs.getInfo(lstRandoController.rr.getId_ran()).getDate()+" Heure: "+rs.getInfo(lstRandoController.rr.getId_ran()).getHeure()+"H");
        type.setText("Type: "+rs.getInfo(lstRandoController.rr.getId_ran()).getType());
        diff.setText("Difficulté: "+rs.getInfo(lstRandoController.rr.getId_ran()).getDifficulte());
        klm.setText("Kilométrage: "+rs.getInfo(lstRandoController.rr.getId_ran()).getKilometrage()+"Klm");
        alt.setText("Altitude: "+rs.getInfo(lstRandoController.rr.getId_ran()).getAltitude()+"cm");
        prix.setText("Prix: "+rs.getInfo(lstRandoController.rr.getId_ran()).getPrix()+"DTN");
        desc.setText("Description: "+rs.getInfo(lstRandoController.rr.getId_ran()).getDescription());
        nbr.setText("N° de places: "+rs.getInfo(lstRandoController.rr.getId_ran()).getNb_randonneur()+"places");
        org.setText("Organisateur: "+rs.getInfo(lstRandoController.rr.getId_ran()).getOrganisateur());
        
//        lieu.setText("Lieu: "+lstRandoController.rr.getLieu());
//        date.setText("Date: "+lstRandoController.rr.getDate().toString()+"Heure: "+lstRandoController.rr.getHeure());
//        type.setText("Type: "+lstRandoController.rr.getType());
//        diff.setText("Difficulté: "+lstRandoController.rr.getDifficulte());
//        klm.setText("Kilométrage: "+lstRandoController.rr.getKilometrage());
//        alt.setText("Altitude: "+lstRandoController.rr.getAltitude());
//        prix.setText("Prix: "+lstRandoController.rr.getPrix());
//        desc.setText("Description: "+lstRandoController.rr.getDescription());
//        nbr.setText("N° de places: "+lstRandoController.rr.getNb_randonneur());
//        org.setText("Organisateur: "+lstRandoController.rr.getOrganisateur());
        mapView.addMapInializedListener(this);
        
        
        
        
    }    

    @FXML
    private void retourner(ActionEvent event) {
    }

    @FXML
    private void participer(ActionEvent event) {
    }
    @Override
    public void mapInitialized() {
          System.out.println("here");
        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(33.8869, 9.5375))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(true)
                .zoom(6);
 
        map = mapView.createMap(mapOptions);
        MarkerOptions markerOptions = new MarkerOptions();
       
            
                                Double alt= rs.maplat(lstRandoController.rr);
                                Double lng= rs.maplng(lstRandoController.rr);
                                 System.out.println(alt);
                                  System.out.println(lng);


    markerOptions.position( new LatLong(alt, lng) )
                .visible(Boolean.TRUE)
                .title("My Marker");

    Marker marker = new Marker( markerOptions );

    map.addMarker(marker);
    }
}
