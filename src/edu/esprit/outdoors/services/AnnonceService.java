/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.services;

import edu.esprit.outdoors.controllers.AuthentificationController;
import edu.esprit.outdoors.iservices.IAnnonce;
import edu.esprit.outdoors.models.Annonce;
import edu.esprit.outdoors.technique.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS I7
 */
public class AnnonceService implements IAnnonce<Annonce,Integer>{

         private Connection connection; 
    private PreparedStatement ps;
     ResultSet rs;
     
     public AnnonceService()
     {
     connection=DbConnection.getInstance().getConnection();
     }
     
    @Override
    public void add(Annonce t) {
      String req="INSERT INTO `annonces`(`id_annonce`, `nom`, `type`, `description`, `prix`, `date_publication`, `derniere_modification`, `etat`, `image`, `id_utilisateur`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            
            ps=connection.prepareStatement(req);
            ps.setInt(1, t.getIdAnnonce());
            ps.setString(2, t.getNom());
            ps.setString(3, t.getType());
            ps.setString(4, t.getDescription());
            ps.setFloat(5, t.getPrix());
            ps.setString(6, t.getDatePub());
            ps.setString(7, t.getDateModif());
            ps.setString(8,t.getEtat());
            ps.setString(9,t.getImage());
            ps.setInt(10, AuthentificationController.user.getId_user());
            
            
              ps.executeUpdate();  
        } catch (Exception e) {
            e.printStackTrace();       }
       
    }

  

    @Override
    public List<Annonce> getAll() {
        String req="SELECT * FROM `annonces` ";
        List<Annonce> listannonce = new ArrayList<>();
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               Annonce a=new Annonce(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
             listannonce.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage");
           
        }
        return listannonce;
    }

    @Override
    public void modify(Annonce t, Integer id) {
        String req="UPDATE `annonces` SET `nom`=?,`type`=?,`description`=?,`prix`=?,`derniere_modification`=?,`etat`=?,`image`=? WHERE id_annonce=" + " '" + id + "' ";
        try {
             ps = connection.prepareStatement(req);
             ps.setString(1, t.getNom());
             ps.setString(2, t.getType().toString());
             ps.setString(3, t.getDescription());
             ps.setFloat(4, t.getPrix());
             ps.setString(5,t.getDateModif());
             ps.setString(6,t.getEtat().toString());
             ps.setString(7, t.getImage());
                 ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
             
            
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    @Override
    public void delete( Integer r) {
        String req="DELETE FROM `annonces` WHERE id_annonce=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, r);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
       
    }
    
   
    public Annonce getInfo(Integer idAnnonce) {
   
        String req = "SELECT * FROM `annonces` where id_annonce=" + " '" + idAnnonce + "' ";
       //String req = "SELECT * FROM `annonces` where id_annonce=1 ";
        
       Annonce an=null;
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              Annonce a=new Annonce(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
        
               an=a;
                System.out.println(an);
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage detail");
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return an;
            
    }
    
    public List<Annonce> selcetAnnonce(int id)
    {
        List<Annonce> lst = new ArrayList<Annonce>();
    String req="SELECT * FROM `annonces` where id_annonce=" + " '" + id + "' ";
    
     try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                
             Annonce a=new Annonce(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
        
              lst.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage detail");
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return lst;
    }
      public ObservableList<Annonce> selcetMesAnnonce(int id)
    {
        ObservableList<Annonce> lst = FXCollections.observableArrayList();
    String req="SELECT * FROM `annonces` where id_utilisateur=" + " '" + id + "' ";
    
     try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                
             Annonce a=new Annonce(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
        
              lst.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage detail");
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return lst;
    }
  
      
       public ObservableList<Annonce> RechercheAnnonce(String name,String type)
    {
        ObservableList<Annonce> lst = FXCollections.observableArrayList();
    String req = "select * from annonces where nom like "+"'%"+name+"%'"+"and type=" + " '" + type+ "' ";
    
     try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                
             Annonce a=new Annonce(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
        
              lst.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage detail");
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return lst;
    }
}
