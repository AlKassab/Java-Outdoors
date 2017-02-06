/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.services;

import edu.esprit.outdoors.iservices.IUtilisateurs;
import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.technique.DbConnection;
import edu.esprit.outdoors.utils.Enum;
import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;


/**
 *
 * @author WILLIAM
 */
public class UserService  implements IUtilisateurs<Utilisateurs>{
    
    private Connection connection;
    private PreparedStatement ps,ps2;
    private Statement c;
    private CallableStatement ps3;
    public  static Utilisateurs user;

    public UserService() {
        connection = DbConnection.getInstance().getConnection();
        if(connection == null){
            System.out.println("Connection not successful");
            System.exit(1);
        }
        else{
            System.out.println("Connection  successful");
        }
    }
    
     public Utilisateurs getUser() {
        return user;
    }

    public void setUser(Utilisateurs user) {
        this.user = user;
    }
    
    @Override
    public void add(Utilisateurs t,Profil p){

        
   String insertUserWithProfilB1 =   "insert into utilisateurs (username,email,mdp) VALUES (" + "'" + t.getId_Ut() + "'," +  "'" + t.getEmail() + "'," + "'" + t.getMot_passe() + "')";
   String insertUserWithProfilB2 =  "SET @last_ID = LAST_INSERT_ID()";
   String insertUserWithProfilB3 =  "INSERT INTO profil (nom,localisation,id_utilisateur) value ("+"'"+p.getNom()+"',"+"'"+ p.getGouvernorat().toString()+"',@last_ID)";
        
         try{
           
           c = connection.createStatement();
           c.addBatch(insertUserWithProfilB1);
           c.addBatch(insertUserWithProfilB2);  
           c.addBatch(insertUserWithProfilB3);  
           c.executeBatch();
       }catch (SQLException ex) {
            System.err.println("Error"+ex);
        }        
    }
    
    @Override
    public Utilisateurs Authentication(String login, String password) {
        
        
        try {
            
            String requete = "SELECT * FROM utilisateurs WHERE username= " + "'" + login + "'" 
            + " AND mdp= " + "'" + password + "'";
            
            Utilisateurs u = new Utilisateurs();
            
            
            ps = connection.prepareStatement(requete);
            try (ResultSet rs = ps.executeQuery( requete)) {
                while ( rs.next() ) {
                    if (rs.getString("username") != null && rs.getString("mdp") != null) {
                        
                        
                        u.setId_user(rs.getInt("id_utilisateur"));
                        u.setEmail(rs.getString("email"));
                        u.setId_Ut(rs.getString("username"));
                        u.setMot_passe(rs.getString("mdp"));
                        
                        u.setProfil(getInfoFormProfil(rs.getInt("id_utilisateur")));
                        
                       
                        //setUser(u);
                        return u;
                    }
                }  
            }
            ps.close();
           // connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
       
    }

    
    public Profil getInfoFormProfil (int id_user) throws SQLException{
        
                         
                             
                             Profil p = new Profil();
                             
                             String requete2 = "SELECT * FROM profil WHERE id_utilisateur= " + "'" + id_user + "'";
                             
                             ps = connection.prepareStatement(requete2);
                             
                             ResultSet rs = ps.executeQuery( requete2); 
                                 while ( rs.next() ) {
                                     
                                     
                                     
                                     p.setDetail(rs.getString("detail"));
                                     p.setGouvernorat(Enum.Gouvernorat.valueOf(rs.getString("localisation")));
                                     p.setId_pr(rs.getInt("id_profil"));
                                     p.setNom(rs.getString("nom"));
                                     p.setSexe(rs.getString("sexe"));
                                     p.setPath_Photo(rs.getString("photo"));
                                     p.setTel(rs.getInt("tel"));
                                     
                                     
                                 }
                                 ps.close();
                                 connection.close();
                            
                        
     return p;

                       
    
    }
    

    @Override
    public List<Utilisateurs> DisplayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void HomeView(Utilisateurs u) {
        
        
              
                
        
        
    }
    
}
