/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.services;

import edu.esprit.outdoors.iservices.IServices;
import edu.esprit.outdoors.models.Actualites;
import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.technique.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

/**
 *
 * @author hassen
 */
public class ActualiteService implements IServices<Actualites, Integer> {

    private Connection connection = UserService.connection;
    private PreparedStatement ps;

    public ActualiteService() {
        
    }

    @Override
    public void add(Actualites act) {
        String req = "insert into actualites (titre,contenu) values (?,?)";
        try {
            ps = connection.prepareStatement(req);
            ps.setString(1, act.getTitre());
            ps.setString(2, act.getConseil());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Actualites> getAll() {
        String req = "select * from actualites";
        List<Actualites> actualites = new ArrayList<>();
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Actualites p = new Actualites(rs.getInt(1), rs.getString(2), rs.getString(3));
                actualites.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actualites;
    }

    
    public void delete(String tit) {
        String req = "delete from actualites where titre = ?";
        try {
            ps = connection.prepareStatement(req);
            ps.setString(1, tit);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public Actualites getById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void update(String r, String p) {

        String req="UPDATE actualites set contenu=? where titre=?";
        
        try {
        PreparedStatement pst=connection.prepareStatement(req);
            pst.setString(1,r);
            pst.setString(2,p);
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        

    }
    
    public String afficher(Integer p) {

        String req="Select contenu from actualites where id_actu=?";
        String s="";
        
        try {
        PreparedStatement pst=connection.prepareStatement(req);
        pst.setInt(1, p);
        ResultSet rs= pst.executeQuery(req);
             
            
                 
              s= rs.getString("contenu");
              return s;
             
             

        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
        return s;
                    
             

    }
    
    public String aff (String who) {
        String req = "SELECT `contenu` FROM `actualites` WHERE titre = ?";
        String s = "";
        try {
            ps = connection.prepareStatement(req);
            ps.setString(1, who);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 s = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public void delete(Actualites t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modify(Actualites t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Actualites getInfo(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<String> choisirTitre(){
        
        List<String> tab = new ArrayList<String>();

        
        try {
            
            String requete="select titre from actualites";
             Statement st = connection.createStatement();
             
             ResultSet rs= st.executeQuery(requete);
             
             while( rs.next() ){
                               
              tab.add(rs.getString(1));
              
             }
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        
       return tab;
    
}
    
    public List<Actualites> myAdv() {
        String req = "SELECT `id_actu`, `titre`, `contenu` FROM `actualites`";
        List<Actualites> Msgs = new ArrayList<>();
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Actualites m = new Actualites(rs.getInt(1), rs.getString(2), rs.getString(3));
                Msgs.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msgs;
    }
    
    
    
    
}
