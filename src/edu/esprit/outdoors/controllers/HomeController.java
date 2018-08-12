/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.controllers;


import com.jfoenix.controls.JFXListView;
import edu.esprit.outdoors.iservices.IPublication;
import edu.esprit.outdoors.iservices.IUtilisateurs;
import edu.esprit.outdoors.models.Publication;
import edu.esprit.outdoors.services.PublicationService;
import javafx.event.ActionEvent;
import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import edu.esprit.outdoors.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


/**
 * FXML Controller class
 *
 * @author WILLIAM
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
    
   
    
    @FXML
    private AnchorPane gaga;
     
    public static ScrollPane scollfromhomep;
    
    @FXML
    private JFXTextField villa;
    
     @FXML
    private ScrollPane scollfromhome;

@FXML
    private ImageView logoC;

    @FXML
    private JFXHamburger HamC;

    @FXML
    private TextField rechC;

    @FXML
    private Label messNum;

    @FXML
    private Label notifNum;

    @FXML
    private Label lblUsrName;

    @FXML
    private Circle imgUsrTop;

    @FXML
    private JFXDrawer DrawerC;
    
    @FXML
    private ImageView drawerimg;

     @FXML
    private ImageView messimg;

    @FXML
    private ImageView notifimg;
    
    double a,b;
    
    
        @FXML
    private Label lat;

    @FXML
    private Label lon;

    @FXML
    private Label tem;

    @FXML
    private Label hum;
    
    @FXML
    private Label lat1;

    @FXML
    private Label lon1;

    @FXML
    private Label tem1;

    @FXML
    private Label hum1;
    
       @FXML
    private JFXListView<Publication> listPub;
    
    
    
   
    IUtilisateurs UserS = new UserService();
    IPublication PubS = new PublicationService();
    
    
    
    Image image = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/drawer.png"));
    Image image1 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/drawerC.png"));
    Image image2 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/message.png"));
    Image image3 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/messageW.png"));
    Image image4 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/notif.png"));
    Image image5 = new Image(getClass().getResourceAsStream("/edu/esprit/outdoors/resource/notifW.png"));
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/DrawerMenuHome.fxml"));
            DrawerC.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(HamC);
        transition.setRate(-1);
        HamC.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            if(DrawerC.isShown())
            {
                DrawerC.close();
                //scollfromhome.setPrefWidth(1280);
              //  scollfromhome.toFront();
                
            }else{
            DrawerC.open();
            //scollfromhome.setPrefWidth(1080);
            //scollfromhome.toBack();
           
            }
        });
        
       lblUsrName.setText(AuthentificationController.user.getPrenom()+" "+AuthentificationController.user.getNom());
       scollfromhomep = scollfromhome;
        
       Image image = AuthentificationController.user.getProfil().getPhoto_profil();
       ImagePattern imagepattern = new ImagePattern(image); 
       
       imgUsrTop.setFill(imagepattern);
       
       
       
       try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/HomePublication.fxml")); 
                    scollfromhome.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
       
    
       
       
       
       
    }    
    
    
    
    
    
    
    
    
     @FXML
    void chanfecoloronexit(MouseEvent event) {
        drawerimg.setImage(image1);
    }

    @FXML
    void changecoloronenter(MouseEvent event) {
         drawerimg.setImage(image);
    }
    
    @FXML
    void changecolormessonenter(MouseEvent event) {
        messimg.setImage(image3);
    }

    @FXML
    void changecolormessonexit(MouseEvent event) {
        messimg.setImage(image2);
    }

    @FXML
    void changecolornotifonenter(MouseEvent event) {
        notifimg.setImage(image5);
    }


    @FXML
    void chnagecolornotifonexit(MouseEvent event) {
        notifimg.setImage(image4);
    }
    
    
     @FXML
    void ReturnHome(MouseEvent event) {
        
        
    }

    @FXML
    void openMessFromtopBar(MouseEvent event) {
        
        try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/Messages.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        gaga.setVisible(false);
            
        
        

    }

    @FXML
    void openNotifFromtopBar(MouseEvent event) {

         try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/Conseils.fxml")); 
                    HomeController.scollfromhomep.setContent(pane);
                    
                    
         } catch (IOException ex) {
                    Logger.getLogger(Inscription_Conex_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        gaga.setVisible(false);
        
    }
    
    @FXML
    void okThen(MouseEvent event) throws IOException {
        
        String ville = villa.getText();
                                
                if (ville.equals("Tunis")){
                    a=36.806495;
                    b=10.181532;
                }
                if (ville.equals("Ariana")){
                    a=36.866537;
                    b=10.164723;
                }
                if (ville.equals("Ben Arous")){
                    a=36.743500;
                    b=10.231976;
                }
                if (ville.equals("Manouba")){
                    a=36.809328;
                    b=10.086327;
                }
                if (ville.equals("Nabeul")){
                    a=36.455066;
                    b=10.715423;
                }
                if (ville.equals("Zaghouan")){
                    a=36.409119;
                    b=10.142317;
                }
                if (ville.equals("Bizerte")){
                    a=37.274612;
                    b=9.862724;
                }
                if (ville.equals("Beja")){
                    a=36.733319;
                    b=9.184368;
                }
                if (ville.equals("Jendouba")){
                    a=36.507226;
                    b=8.775656;
                }
                if (ville.equals("Kef")){
                    a=36.167965;
                    b=8.709579;
                }
                if (ville.equals("Siliana")){
                    a=36.088721;
                    b=9.364533;
                }
                if (ville.equals("Sousse")){
                    a=35.825603;
                    b=10.608395;
                }
                if (ville.equals("Monastir")){
                    a=35.764252;
                    b=10.811289;
                }
                if (ville.equals("Mahdia")){
                    a=35.502446;
                    b=11.045721;
                }
                if (ville.equals("Sfax")){
                    a=34.747847;
                    b=10.766163;
                }if (ville.equals("Kairouan")){
                    a=35.675914;
                    b=8.660059;
                }
                if (ville.equals("Sidi Bouzid")){
                    a=35.035439;
                    b=9.483939;
                }
                if (ville.equals("Gabes")){
                    a=33.888077;
                    b=10.097522;
                }
                if (ville.equals("Mednine")){
                    a=33.339922;
                    b=10.495868;
                }
                if (ville.equals("Tataouine")){
                    a=32.921090;
                    b=10.450896;
                }
                if (ville.equals("Gafsa")){
                    a=34.431140;
                    b=8.775656;
                }
                if (ville.equals("Tozeur")){
                    a=33.918534;
                    b=8.122933;
                }if (ville.equals("Kebili")){
                    a=33.707155;
                    b=8.971462;
                }
               
                
                
                
                
            
    ForecastIO fio = new ForecastIO("514a3cce78ebf6d14188fbf022f17397");
    fio.setUnits(ForecastIO.UNITS_SI);
    fio.setLang(ForecastIO.LANG_ENGLISH);
    fio.getForecast(String.valueOf(a), String.valueOf(b));
    
    lat1.setText(String.valueOf(fio.getLatitude()));
    System.out.println("Longitude: "+fio.getLongitude());
    lon1.setText(String.valueOf(fio.getLongitude()));
    FIOCurrently currently = new FIOCurrently(fio);
    FIODaily daily = new FIODaily(fio);
    hum1.setText(String.valueOf(daily.getDay(3).humidity()));
    tem1.setText(String.valueOf(currently.get().temperature())+" C");


    
    }
    
    
     @FXML
    void logout(ActionEvent event) {
        
        System.exit(0);

    }

    @FXML
    void mescam(ActionEvent event) {

    }

    @FXML
    void mesron(ActionEvent event) {

    }
      @FXML
    void setting(ActionEvent event) {

    }
    
    
    
}
