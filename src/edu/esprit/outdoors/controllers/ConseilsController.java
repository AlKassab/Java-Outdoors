/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.controllers;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.outdoors.models.Actualites;
import edu.esprit.outdoors.services.ActualiteService;
import static java.awt.Color.red;
import java.io.FileOutputStream;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author hassen
 */
public class ConseilsController implements Initializable {
        
    
    @FXML
    private Pane ppr;

    @FXML
    private TableView<Object> advices;
    @FXML
    private TableColumn<Object, String> titre;
    @FXML
    private TableColumn<Object, String> conseil;
    
    private ObservableList<Object> items = FXCollections.observableArrayList();
    List<Actualites> liste ;
    @FXML
    private Button pdf;
    
    @FXML
    private Label title;
    
    @FXML
    private Label content;
    
    public static ActualiteService as =  new ActualiteService() ;
    
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ppr.setVisible(false);
                                
         title.setText("");
         content.setText("");
         
         pdf.setVisible(false);

        
        
        items.clear();
        liste = new ArrayList<>();
        liste = as.myAdv();
        
         for (Actualites r : liste) {
            items.add(r);
             }
         
         titre.setCellValueFactory(new PropertyValueFactory<>("titre") );
         conseil.setCellValueFactory(new PropertyValueFactory<>("conseil") );
        
         advices.setItems(items);
         
    }    
    
    @FXML
    void taktak(MouseEvent event) {
        
        ppr.setVisible(true);
        
         title.setText(titre.getCellData(advices.getSelectionModel().getFocusedIndex()));
         content.setText(conseil.getCellData(advices.getSelectionModel().getFocusedIndex()));
         
         pdf.setVisible(true);
         
    }

    @FXML
    private void doPdf(ActionEvent event) {
        
        Document document = new Document(PageSize.A4);
        document.addAuthor("hassen");
        document.addTitle("outdoors");
        
        try {
            PdfWriter.getInstance(document, new FileOutputStream("conseils.pdf"));
            
            document.open();
            Chunk bigTitle;
            Chunk title;
            Chunk deuxPoints;
            Font red = new Font(FontFamily.HELVETICA, 18, Font.NORMAL, BaseColor.RED);
            Font blue = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLUE);

            bigTitle = new Chunk("                                            OutDoors", red);

            document.add(bigTitle);
            document.add( Chunk.NEWLINE );      
            
            title = new Chunk(titre.getCellData(advices.getSelectionModel().getFocusedIndex()), blue);
            deuxPoints = new Chunk(": ", blue);
            
            document.open();
            Paragraph para = new Paragraph();
            para.add(title);
            para.add(deuxPoints);
            para.add(conseil.getCellData(advices.getSelectionModel().getFocusedIndex()));
            document.add(para);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        document.close();
                
                
                
        
    }
    
    
    
    
}
