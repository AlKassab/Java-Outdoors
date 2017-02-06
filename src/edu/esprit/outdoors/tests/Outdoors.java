/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.tests;


import com.sun.javaws.Main;
import javafx.application.Application;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.scenicview.ScenicView;
/**
 *
 * @author WILLIAM
 */


public class Outdoors extends Application {
    
    public static Main main;
    
    @Override
    public void start(Stage stage) throws Exception {
        

       // Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Parent root1 = FXMLLoader.load(getClass().getResource("/edu/esprit/outdoors/gui/Inscription_Connex.fxml"));
        
        
        //Scene scene = new Scene(root);
        Scene scene1 = new Scene(root1);
        
        stage.setTitle("Outdoors V1.0");
        //stage.setResizable(false);
       // stage.initStyle(StageStyle.UNDECORATED);
        //ScenicView.show(scene1);
        stage.setScene(scene1);
        stage.show();
    }     
        
        
     
     
    

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    
   
    public static void main(String[] args) {
       
        
        launch(args);
    }
    
}
