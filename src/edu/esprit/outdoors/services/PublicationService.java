/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.services;

import edu.esprit.outdoors.iservices.IPublication;
import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Publication;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.technique.DbConnection;
import java.io.FileInputStream;
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
public class PublicationService implements IPublication<Publication>{

    
    private Connection connection = UserService.connection;
    private PreparedStatement ps,ps2;
    private Statement c;
    private CallableStatement ps3;
    public  static Utilisateurs user;
    private FileInputStream fis;
    
    ProfilServices PS = new ProfilServices();

    
    public PublicationService() {
        
    }
    
    @Override
    public void add(Publication pu) {
        
        String req = "insert into publication (Texte,id_profil,date_creation) values (?,?,?)";
        try {
            ps = connection.prepareStatement(req);
            ps.setString(1, pu.getText());
            ps.setInt(2, pu.getCreator().getId_pr());
            ps.setDate(3,new java.sql.Date(System.currentTimeMillis()));
            
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    @Override
    public ObservableList<Publication> DisplayAll() {
       
        ObservableList<Publication> listePub = FXCollections.observableArrayList();
        String requete = "select * from publication";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet rs = statement.executeQuery(requete);


            while (rs.next()) {
                Publication a = new Publication();
                
                a.setId(rs.getInt("id"));
                a.setText(rs.getString("Texte"));
                a.setCreator(PS.getprofilByID(rs.getInt("id_profil")));
                a.setDate_creation(rs.getDate("date_creation"));
                a.setDate_modification(rs.getDate("date_modification"));
                
                
                listePub.add(a);
            }
          
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des Publications " + ex.getMessage());
            
        }
        return  listePub;  
    
    }
    
    
    @Override
    public ObservableList<Publication> ListePubOfProfil(int idProfil) {
        String req = "select * from publication where id_profil="+"'"+idProfil+"'";
        
        ObservableList<Publication> publication = FXCollections.observableArrayList();

        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 Publication a = new Publication();
                
                a.setId(rs.getInt("id"));
                a.setText(rs.getString("Texte"));
                a.setCreator(PS.getprofilByID(rs.getInt("id_profil")));
                a.setDate_creation(rs.getDate("date_creation"));
                a.setDate_modification(rs.getDate("date_modification"));
                
                
                publication.add(a);
            }

        } catch (SQLException ex) {
            System.out.print("erreur : " + ex.getMessage());
        }
        return publication;
    }
    
    @Override
    public void update(String newText, int idPub) {
       
         try{

              // String query = "INSERT INTO profil (photo) VALUES(?) where id_utilisateur=?";
                String requete = "update publication set Texte=? where id=?";

                ps = connection.prepareStatement(requete);
               
                
                ps.setString(1,newText);
                ps.setInt(2, idPub);
             
                ps.execute();

                ps.close();

            }catch(SQLException e1){

                System.err.println(e1);

            }
        
    
    }

    @Override
    public void delete(int id) {
     
         String requete = "delete from publication where id=?";
          
          try {
            ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public Publication getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            
            System.out.println(nom);
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
