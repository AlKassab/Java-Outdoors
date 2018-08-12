/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.services;

import edu.esprit.outdoors.iservices.IPhoto;
import edu.esprit.outdoors.models.Photo;
import edu.esprit.outdoors.models.Publication;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.technique.DbConnection;
import edu.esprit.outdoors.technique.UploadImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 *
 * @author WILLIAM
 */
public class PhotoService implements IPhoto{

    
    Connection connection = UserService.connection;
    private PreparedStatement ps,ps2;
    private Statement c;
    private CallableStatement ps3;
    public  static Utilisateurs user;
    private FileInputStream fis;
    
    ProfilServices PS = new ProfilServices();
    UploadImage ui = new UploadImage();
    
    
    public PhotoService() {
        
    }

    @Override
    public void add(Photo pu) {
        
        
    }

    @Override
    public ObservableList<Photo> DisplayAll() {
    
    ObservableList<Photo> listePub = FXCollections.observableArrayList();
        String requete = "select * from publication ORDER BY date_creation DESC, id DESC";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet rs = statement.executeQuery(requete);


            while (rs.next()) {
                Photo a = new Photo();
               
                if((rs.getString("image"))!=null){
                    
                a.setId(rs.getInt("id"));
                a.setText(rs.getString("Texte"));
                a.setCreator(PS.getprofilByID(rs.getInt("id_profil")));
                //System.out.println(rs.getDate("date_creation"));
                a.setDate_creation(rs.getDate("date_creation"));
                a.setDate_modification(rs.getDate("date_modification"));   
                Image imagepub = new Image(rs.getString("image"));
                a.setPhoto(imagepub);
                listePub.add(a);
                }else{
                a.setId(rs.getInt("id"));
                a.setText(rs.getString("Texte"));
                a.setCreator(PS.getprofilByID(rs.getInt("id_profil")));
                a.setDate_creation(rs.getDate("date_creation"));
                a.setDate_modification(rs.getDate("date_modification"));  
                listePub.add(a);
                }
                
                
                
            }
          
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des Publications " + ex.getMessage());
            
        }
        return  listePub;  
    
    
    }

    @Override
    public ObservableList<Photo> ListePubOfProfil(int idProfil) {
     
     String req = "select * from publication where id_profil="+"'"+idProfil+"' ORDER BY date_creation DESC, id DESC";
        
        ObservableList<Photo> publicationphoto = FXCollections.observableArrayList();

        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 Photo a = new Photo();
                
                if((rs.getString("image"))!=null){
                    
                a.setId(rs.getInt("id"));
                a.setText(rs.getString("Texte"));
                a.setCreator(PS.getprofilByID(rs.getInt("id_profil")));
                a.setDate_creation(rs.getDate("date_creation"));
                a.setDate_modification(rs.getDate("date_modification"));   
                Image imagepub = new Image(rs.getString("image"));
                a.setPhoto(imagepub);
                publicationphoto.add(a);
                }else{
                a.setId(rs.getInt("id"));
                a.setText(rs.getString("Texte"));
                a.setCreator(PS.getprofilByID(rs.getInt("id_profil")));
                a.setDate_creation(rs.getDate("date_creation"));
                a.setDate_modification(rs.getDate("date_modification"));  
                publicationphoto.add(a);
                }
            }

        } catch (SQLException ex) {
            System.out.print("erreur : " + ex.getMessage());
        }
        return publicationphoto;
    
    }

    @Override
    public void update(String text, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publication getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addwith(Photo p, File f) {
    
        
         String req = "insert into publication (image,Texte,id_profil,date_creation) values (?,?,?,?)";
        try {
            ps = connection.prepareStatement(req);
            
               File source = new File(f.toPath().toString());
               File dest = new File("C:\\wamp\\www\\image\\"+f.getName());
                
               
                
                ui.copyFileUsingStream(source, dest);
                
            ps.setString(1, "http://localhost/image/"+f.getName());
            ps.setString(2, p.getText());
            ps.setInt(3, p.getCreator().getId_pr());
            ps.setDate(4,new java.sql.Date(System.currentTimeMillis()));
            
            
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        
        
    }

     @Override
        public String getNomByIDprf(int idProfil) {


            String nom =null;
            String requete2 = "select nom from fos_user "
                    + "INNER JOIN profil"
                    + " ON fos_user.id = profil.id_user "
                    + "where id_profil="+"'"+idProfil+"'";
        try {
            
            
            ps = connection.prepareStatement(requete2);
            
            ResultSet rs = ps.executeQuery( requete2);
            while ( rs.next() ) {
                
                nom = rs.getString("nom");
                
            }
            
            ps.close();
            //  connection.close();
            
          return nom;
          
          
        } catch (SQLException ex) {
            Logger.getLogger(ProfilServices.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        

    }
        @Override  
        public String getPrenomByIDprf(int idProfil) {


            String prenom =null;
            String requete2 = "select prenom from fos_user "
                    + "INNER JOIN profil"
                    + " ON fos_user.id = profil.id_user "
                    + "where id_profil="+"'"+idProfil+"'";
        try {
            
            
            ps = connection.prepareStatement(requete2);
            
            ResultSet rs = ps.executeQuery( requete2);
            while ( rs.next() ) {
                
                prenom = rs.getString("prenom");
                
            }
            
            ps.close();
            //  connection.close();
            
          return prenom;
          
          
        } catch (SQLException ex) {
            Logger.getLogger(ProfilServices.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        

    }
    
    
  
    
}
