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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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


/**
 *
 * @author WILLIAM
 */
public class UserService  implements IUtilisateurs<Utilisateurs,Profil>{
    
    static Connection connection = DbConnection.getInstance().getConnection();
    private PreparedStatement ps,ps2;
    private Statement c;
    private CallableStatement ps3;
    public  static Utilisateurs user;
    private FileInputStream fis;

    ProfilServices PS = new ProfilServices();
    
    public UserService() {
        
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

        String crypted = t.getMot_passe() + "{ijYSzmxMN8SBRqoKEQR3UiC9mQkcflYk2jV3Pf6XyMI}";
        String salt = "ijYSzmxMN8SBRqoKEQR3UiC9mQkcflYk2jV3Pf6XyMI";
   String pathimageprofil = "http://localhost/image/profil_default_pic.png";
   String pathimagecover = "http://localhost/image/cover_default_pic.png"; 
   String insertUserWithProfilB1 =  "insert into fos_user (username,username_canonical,email,email_canonical,enabled,salt,password,roles,nom,prenom) VALUES (" + "'" + t.getId_Ut() + "',"+  "'" +t.getId_Ut() + "'," +  "'" + t.getEmail() + "'," +  "'" + t.getEmail() + "',"+ "1," + "'" + salt + "'"+",'"+ crypted +"',"+"'a:0:{}'," + "'" + t.getNom()+ "'," + "'" + t.getPrenom() + "')";
   String insertUserWithProfilB2 =  "SET @last_ID = LAST_INSERT_ID()";
   String insertUserWithProfilB3 =  "INSERT INTO profil (localisation,id_user,photo_profil,cover_photo) value ("+"'"+ p.getGouvernorat()+"',@last_ID,"
           + "'"+pathimageprofil+"',"+"'"+pathimagecover+"')";
        
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
        
         String requete = "SELECT * FROM fos_user WHERE username= " + "'" + login + "'" 
            + " AND password like" + "'" + password + "{%}'";
            
            Utilisateurs u = new Utilisateurs();
        
        try {
            
           
            
            
            ps = connection.prepareStatement(requete);
            try (ResultSet rs = ps.executeQuery( requete)) {
                while ( rs.next() ) {
                    if (rs.getString("username") != null && rs.getString("password") != null) {
                        
                        
                        u.setId_user(rs.getInt("id"));
                        u.setEmail(rs.getString("email"));
                        u.setId_Ut(rs.getString("username"));
                        u.setMot_passe(rs.getString("password"));
                        u.setNom(rs.getString("nom"));
                        u.setPrenom(rs.getString("prenom"));
                        
                        u.setProfil(PS.getInfoFormProfil(rs.getInt("id")));
                        
                        
                       
                        //setUser(u);
                        return u;
                    }
                }  
            }            ps.close();
           // connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
       
    }

    
    

    @Override
    public ObservableList<Utilisateurs> DisplayAll() {
        
    ObservableList<Utilisateurs> listedeusers = FXCollections.observableArrayList();
        String requete = "select * from fos_user";
        try {
            
            ps = connection.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            //Enseigne
            while (rs.next()) {
                Utilisateurs u = new Utilisateurs();
                
                        u.setId_user(rs.getInt("id"));
                        u.setEmail(rs.getString("email"));
                        u.setId_Ut(rs.getString("username"));
                        u.setMot_passe(rs.getString("password"));
                        u.setNom(rs.getString("nom"));
                        u.setPrenom(rs.getString("prenom"));
                        u.setProfil(PS.getInfoFormProfil(rs.getInt("id")));
                
                listedeusers.add(u);
            }
          
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            
        }
        return  listedeusers;   
    }

    


    
    
    
    
    public void addPhoto(File file,Profil p){
        
         String requete = "insert into photos (photo,id_album) value (?,?)";

              try{    

                ps = connection.prepareStatement(requete);
                
                fis = new FileInputStream(file);
               
                //ps.setString(1, p.getPhoto().getTitre());
                ps.setBinaryStream(1, (InputStream)fis, (int)file.length());
                ps.setInt(2, p.getId_pr());
             
                ps.execute();

                ps.close();

            }catch(FileNotFoundException | SQLException e1){

                System.err.println(e1);

            }
    } 
    
    
   @Override
    public Utilisateurs getById(Integer id) {
        String req = "select * from fos_user where id =?";
        Utilisateurs u = null;
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                //int id_user, String email, String mot_passe, String id_Ut, Profil profil
                 u = new Utilisateurs(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"),rs.getString("username"),PS.getInfoFormProfil(rs.getInt(1)));
          
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public void findbyemail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Utilisateurs> findbyusernameAndEmail(String username,String email) {
       ObservableList<Utilisateurs> fos_user = FXCollections.observableArrayList();
       
       
        String req = "select * from fos_user where username like "+"'%"+username+"%'"+"or like "+"'%"+email+"%'";
        Utilisateurs u = null;
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                //int id_user, String email, String mot_passe, String id_Ut, Profil profil
                u = new Utilisateurs(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"),rs.getString("username"),PS.getInfoFormProfil(rs.getInt(1)));
          
                fos_user.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fos_user;
        
        
    }
    
     @Override
    public ObservableList<Utilisateurs> findbyname(String name) {
       ObservableList<Utilisateurs> fos_user = FXCollections.observableArrayList();
       
       String req = "select u.* from fos_user u inner join profil p on u.id = p.id_user where nom like"+"'%"+name+"%'";
       
       Utilisateurs u = null;
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                //int id_user, String email, String mot_passe, String id_Ut, Profil profil
                u = new Utilisateurs(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"),rs.getString("username"),PS.getInfoFormProfil(rs.getInt(1)));
                fos_user.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
               
               
        return fos_user;
        
        
    }
    
    
    @Override
    public boolean checkforemail(String mail) throws SQLException{
    
        
       String req = "select * from fos_user where email =?";
        Utilisateurs u = null;
      
            ps = connection.prepareStatement(req);
            ps.setString(1, mail);
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next()) {
                return true;
            }else{
                
            return false ;}
       
        
    
    }
    
    
    @Override
    public boolean checkforusername(String username) throws SQLException{
    
        
       String req = "select * from fos_user where username =?";
        Utilisateurs u = null;
      
            ps = connection.prepareStatement(req);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next()) {
                return true;
            }else{
                
            return false ;}
       
        
    
    }
    
    
    
    @Override
     public Utilisateurs Authenticationwithfacebook(String email) {
        
         String requete = "SELECT * FROM fos_user WHERE email= " + "'" + email + "'";
            
            Utilisateurs u = new Utilisateurs();
        
        try {
            
           
            
            
            ps = connection.prepareStatement(requete);
            try (ResultSet rs = ps.executeQuery( requete)) {
                while ( rs.next() ) {
                    if (rs.getString("username") != null && rs.getString("password") != null) {
                        
                        
                        u.setId_user(rs.getInt("id"));
                        u.setEmail(rs.getString("email"));
                        u.setId_Ut(rs.getString("username"));
                        u.setMot_passe(rs.getString("password"));
                        u.setNom(rs.getString("nom"));
                        u.setPrenom(rs.getString("prenom"));
                        
                        u.setProfil(PS.getInfoFormProfil(rs.getInt("id")));
                        
                       
                        //setUser(u);
                        return u;
                    }
                }  
            }            ps.close();
           // connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
       
    }

    
    
    @Override
    public void addwithfcb(Utilisateurs t,Profil p,String link){
        
        
        String crypted = t.getMot_passe() + "{ijYSzmxMN8SBRqoKEQR3UiC9mQkcflYk2jV3Pf6XyMI}";
        String salt = "ijYSzmxMN8SBRqoKEQR3UiC9mQkcflYk2jV3Pf6XyMI";
        
   String pathimageprofil = "http://localhost/image/profil_default_pic.png";
   String pathimagecover = "http://localhost/image/cover_default_pic.png"; 
   String insertUserWithProfilB1 =  "insert into fos_user (username,username_canonical,email,email_canonical,enabled,salt,password,roles,nom,prenom) VALUES (" + "'" + t.getId_Ut() + "',"+  "'" +t.getId_Ut() + "'," +  "'" + t.getEmail() + "'," +  "'" + t.getEmail() + "',"+ "1," + "'" + salt + "'"+",'"+ crypted +"',"+"'a:0:{}'," + "'" + t.getNom()+ "'," + "'" + t.getPrenom() + "')";
   String insertUserWithProfilB2 =  "SET @last_ID = LAST_INSERT_ID()";
   String insertUserWithProfilB3 =  "INSERT INTO profil (localisation,id_user,photo_profil,cover_photo) value ("+"'"+ p.getGouvernorat()+"',@last_ID,"
           + "'"+pathimageprofil+"',"+"'"+pathimagecover+"')";
        
          
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
   public void updateEmail(String newEmail ,Utilisateurs u){
    
        try{

              // String query = "INSERT INTO profil (photo) VALUES(?) where id=?";
                String requete = "update fos_user set email=? where id=?";

                ps = connection.prepareStatement(requete);
                


              
                ps.setString(1, newEmail);
                ps.setInt(2, u.getId_user());
             
             
                ps.execute();
                u.setEmail(newEmail);
                ps.close();

            }catch(SQLException e1){

                System.err.println(e1);

            }
    
     }
    
   
    @Override
    public void DeleteAccount(int idUser){
    
       String req = "delete from fos_user where id = ?";
       String req2 = "delete from profil where id = ?";
       try {
            ps = connection.prepareStatement(req2);
            ps.setInt(1, idUser);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
       
       
       try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, idUser);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
     }
    
    @Override
   public void updatepass(String newPass ,Utilisateurs u){
    
        try{

              // String query = "INSERT INTO profil (photo) VALUES(?) where id=?";
                String requete = "update fos_user set password=? where id=?";

                ps = connection.prepareStatement(requete);
                


              
                ps.setString(1, newPass);
                ps.setInt(2, u.getId_user());
                
             
                ps.execute();
                u.setMot_passe(newPass);
                ps.close();         

            }catch(SQLException e1){

                System.err.println(e1);

            }
        
        
        
    
     }
   
   
   
   
    public String SelectMail(int id)
 {String mail="";
String req ="SELECT email FROM utilisateurs where `id_utilisateur`= " + " '" + id + "'";
 try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             mail=rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage detail");
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
return mail;
 }
 
 public String SelectName(int id)
 {String nom="";
String req ="SELECT nom FROM profil where `id_utilisateur`= " + " '" + id + "'";
 try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             nom=rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage detail");
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
return nom;
 }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
