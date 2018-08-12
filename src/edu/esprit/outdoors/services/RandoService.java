/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.services;

import edu.esprit.outdoors.controllers.AuthentificationController;
import edu.esprit.outdoors.iservices.IServices1;
import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Randonnees;
import edu.esprit.outdoors.technique.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 *
 * @author macbookpro
 */
public class RandoService implements  IServices1<Randonnees, Integer, Image,String,Profil>{
private Connection connection;
    private PreparedStatement ps,ps2;

    public RandoService() {
        connection = DbConnection.getInstance().getConnection();
    }
    
    
    @Override
    public void add(Randonnees r) {
        

        String req = "insert into randonnees (lieu,date,description,prix,heure,kilometrage,altitude,nbr_randonneur,type,difficulte,organisateur) values (?,?,?,?,?,?,?,?,?,?,?)";
//      String req = "insert into randonnees (id_ran,lieu,date,description,prix,duree,kilometrage,altitude,nbr_randonneur,type,difficulte) values ("+"'"+r.getId_ran()+"'"+","+"'"+r.getLieu()+"'"+","+"'"+r.getDate()+"'"+","+"'"+r.getDescription()+"'"+","+"'"+r.getPrix()+"'"+","+"'"+r.getDuree()+"'"+","+"'"+r.getKilometrage()+"'"+","+"'"+r.getAltitude()+"'"+","+"'"+r.getNb_randonneur()+"'"+","+"'"+r.getType().toString()+"'"+","+"'"+r.getDifficulte().toString()+"'"+")";
//       
System.out.println(r);
        try {
            ps = connection.prepareStatement(req);
            // ps.setInt(1, r.getId_ran());
           ps.setString( 1, r.getLieu());
            ps.setDate(2, (java.sql.Date) r.getDate());
            ps.setString(3, r.getDescription());
            ps.setFloat(4, r.getPrix());
            ps.setString(5, r.getHeure());
           ps.setFloat(6, r.getKilometrage());
            ps.setFloat(7, r.getAltitude());
            ps.setInt(8, r.getNb_randonneur());
          ps.setString(9, r.getType());
      ps.setString(10, r.getDifficulte());
      ps.setString(11, AuthentificationController.user.getId_Ut());
             
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erreur lors de l'ajout d'une randonnée");
            e.printStackTrace();
        } 
       
        
   }

    @Override
    public ObservableList<Randonnees> Rechercher(String name) {
        ObservableList<Randonnees> r = FXCollections.observableArrayList();
       
       String req = "select * from randonnees  where lieu like"+"'%"+name+"%'";
       
       Randonnees u = null;
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                //int id_user, String email, String mot_passe, String id_Ut, Profil profil
                u = new Randonnees(rs.getInt("id_ran"), rs.getString("lieu"), rs.getDate("date"), rs.getString("description"), rs.getFloat("prix"),rs.getString("heure"),rs.getFloat("kilometrage"),rs.getFloat("altitude"),rs.getInt("nbr_randonneur"),rs.getString("type"),rs.getString("difficulte"),rs.getString("organisateur"));
                r.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
               
               
        return r;
    
    }
     @Override
    public ObservableList<Randonnees> RechercherMine(String name) {
        ObservableList<Randonnees> r = FXCollections.observableArrayList();
       String nom= AuthentificationController.user.getId_Ut();
       String req = "select * from randonnees  where lieu like"+"'%"+name+"%' and organisateur='"+ nom+ "'";
       
       Randonnees u = null;
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                //int id_user, String email, String mot_passe, String id_Ut, Profil profil
                u = new Randonnees(rs.getInt("id_ran"), rs.getString("lieu"), rs.getDate("date"), rs.getString("description"), rs.getFloat("prix"),rs.getString("heure"),rs.getFloat("kilometrage"),rs.getFloat("altitude"),rs.getInt("nbr_randonneur"),rs.getString("type"),rs.getString("difficulte"),rs.getString("organisateur"));
                r.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
               
               
        return r;
    
    }

    @Override
    public ObservableList<Randonnees> getAll() {
   
    ObservableList<Randonnees> listedeusers = FXCollections.observableArrayList();
        String requete = "select * from randonnees";
        try {
            
            ps = connection.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            //Enseigne
            while (rs.next()) {
                Randonnees r = new Randonnees();
                
                r.setId_ran(rs.getInt("id_ran"));
                r.setLieu(rs.getString("lieu"));
                r.setDate(rs.getDate("date"));
                r.setDescription(rs.getString("description"));
                r.setType(rs.getString("type"));
                r.setDifficulte(rs.getString("difficulte"));
                r.setOrganisateur(rs.getString("organisateur"));
                r.setPrix(rs.getFloat("prix"));
                r.setKilometrage(rs.getFloat("kilometrage"));
                r.setAltitude(rs.getFloat("altitude"));
                r.setHeure(rs.getString("heure"));
                r.setNb_randonneur(rs.getInt("nbr_randonneur"));
                
                  
                listedeusers.add(r);
            }
          
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des randonnées " + ex.getMessage());
            
        }
        return  listedeusers;  }

    @Override
    public ObservableList<Randonnees> getMine() {
        String nom= AuthentificationController.user.getId_Ut();
        //System.out.println("chouuuuuf ya firas ahoo l nom: "+nom);
        ObservableList<Randonnees> listedeusers = FXCollections.observableArrayList();
        String requete = "select * from randonnees where organisateur='"+ nom+ "'";
        try {
            
            ps = connection.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            //Enseigne
            while (rs.next()) {
                Randonnees r = new Randonnees();
                
                r.setId_ran(rs.getInt("id_ran"));
                r.setLieu(rs.getString("lieu"));
                r.setDate(rs.getDate("date"));
                r.setDescription(rs.getString("description"));
                r.setType(rs.getString("type"));
                r.setDifficulte(rs.getString("difficulte"));
                r.setOrganisateur(rs.getString("organisateur"));
                r.setPrix(rs.getFloat("prix"));
                r.setKilometrage(rs.getFloat("kilometrage"));
                r.setAltitude(rs.getFloat("altitude"));
                r.setHeure(rs.getString("heure"));
                r.setNb_randonneur(rs.getInt("nbr_randonneur"));
                
                  
                listedeusers.add(r);
            }
          
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des randonnées " + ex.getMessage());
            
        }
        return  listedeusers; 
   }

    @Override
    public void delete(Randonnees r) {
        
        try {
            String req ="delete from randonnees where id_ran=?";
            PreparedStatement ps = connection.prepareStatement(req);
           ps.setInt(1, r.getId_ran());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RandoService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
   
    }

    @Override
    public void modify(Randonnees r) {
     try {
            //String req = "update randonnees set lieu=?, description=?, prix=?, duree=?, kilometrage=?, altitude=?, nbr_randonneur=?, type=?, difficulte=?, organisateur=? where id_ran=?";
           String req="UPDATE `randonnees` SET `lieu`=?,`description`=?,`prix`=?,`heure`=?,`kilometrage`=?,`altitude`=?,`nbr_randonneur`=?,`type`=?,`difficulte`=? WHERE id_ran=?";
            ps = connection.prepareStatement(req);
            ps.setString(1, r.getLieu());
           // ps.setDate(2, (java.sql.Date) r.getDate());
            ps.setString(2, r.getDescription());
            ps.setFloat(3, r.getPrix());
            ps.setString(4, r.getHeure());
            ps.setFloat(5, r.getKilometrage());
            ps.setFloat(6, r.getAltitude());
            ps.setInt(7,r.getNb_randonneur());
            ps.setString(8, r.getType());
            ps.setString(9, r.getDifficulte());
            ps.setInt(10, r.getId_ran());
            ps.executeUpdate();
            
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(RandoService.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public double maplat(Randonnees r){
        double lat=0;
    try {
        String req="select * from map where lieu=? ";
        ps= connection.prepareStatement(req);
        ps.setString(1, r.getLieu());
        ResultSet rs = ps.executeQuery();
                    //Enseigne
        while (rs.next()) {
            
            lat=rs.getDouble("lat");
            
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(RandoService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return lat;
    }
    public double maplng(Randonnees r){
        double lng=0;
    try {
        String req="select * from map where lieu=? ";
        ps= connection.prepareStatement(req);
        ps.setString(1, r.getLieu());
        ResultSet rs = ps.executeQuery();
                    //Enseigne
        while (rs.next()) {
            
            lng=rs.getDouble("lng");
            
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(RandoService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return lng;
    }

    @Override
    public Randonnees getInfo(Integer idRando) {
         String req = "SELECT id_ran , `lieu`, `date`, `description`, `prix`, `heure`, `kilometrage`, `altitude`, nbr_randonneur, type,difficulte,organisateur FROM `randonnees` where id_ran=" + " '" + idRando + "' ";
       Randonnees rando=null;
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Randonnees r = new Randonnees(rs.getInt(1),rs.getString(2),(java.sql.Date)rs.getDate(3),rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getFloat(7),rs.getFloat(8),rs.getInt(9),rs.getString(10),rs.getString(11), rs.getString(12));
             rando=r;
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage detail");
            Logger.getLogger(RandoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rando;
    }
    

    
}


