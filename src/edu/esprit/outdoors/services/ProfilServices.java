/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.services;

import edu.esprit.outdoors.iservices.Iprofil;
import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.technique.DbConnection;
import edu.esprit.outdoors.technique.UploadImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
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
public class ProfilServices  implements Iprofil{
    
    Connection connection = UserService.connection;
    private PreparedStatement ps,ps2;
    private Statement c;
    private CallableStatement ps3;
    public  static Utilisateurs user;
    private FileInputStream fis;
    
    UploadImage ui = new UploadImage();

    public ProfilServices() {
       
        
    }
 
    

    @Override
    public Profil getInfoFormProfil (int id_user) {
        
            Profil p = new Profil();
            
            String requete2 = "SELECT * FROM profil WHERE id_user= " + "'" + id_user + "'";
                             
        try {
            
            
            ps = connection.prepareStatement(requete2);
            
            ResultSet rs = ps.executeQuery( requete2);
            while ( rs.next() ) {
                
                
                
                p.setDetail(rs.getString("detail"));
                p.setGouvernorat(rs.getString("localisation"));
                p.setId_pr(rs.getInt("id_profil"));
                
                p.setSexe(rs.getString("sexe"));
                
                /*
                
                if (rs.getBinaryStream("photo_profil")!= null){
                    
                    int i = 0;
                    String filename = "profilePic"+Integer.toString(i)+".png";
                    File f = new File("C:\\Users\\WILLIAM\\Documents\\Netbeans\\Outdoors\\src\\edu\\esprit\\outdoors\\userresources\\"+filename);
                    
                    if(f.exists())
                        while (f.exists()) {
                            i++;
                            filename = "profilePic"+Integer.toString(i)+".png";
                            f = new File("C:\\Users\\WILLIAM\\Documents\\Netbeans\\Outdoors\\src\\edu\\esprit\\outdoors\\userresources\\"+filename);
                        }
                    f.createNewFile();
                    f.deleteOnExit();

                    
                    InputStream is = rs.getBinaryStream("photo_profil");
                    OutputStream os = new FileOutputStream(f);
                    byte[] content = new byte[1024];
                    int size = 0;
                    while ((size = is.read(content)) != -1){
                        os.write(content,0,size);
                    }
                    os.close();
                    is.close();
                    
                    Image image = new Image("file:///C:/Users/WILLIAM/Documents/Netbeans/Outdoors/src/edu/esprit/outdoors/userresources/"+filename);
                    
                    
                    //  Image image = SwingFXUtils.toFXImage(img, null);
                    p.setPhoto_profil(image);
                }else {
                    p.setPhoto_profil(new Image ("file:///C:/Users/WILLIAM/Documents/Netbeans/Outdoors/src/edu/esprit/outdoors/userresources/profil_default_pic.png"));
                }
                
                
                if (rs.getBinaryStream("cover_photo")!=null){
                    
                    int i = 0;
                    String filename = "coverPic"+Integer.toString(i)+".png";
                    File f = new File("C:\\Users\\WILLIAM\\Documents\\Netbeans\\Outdoors\\src\\edu\\esprit\\outdoors\\userresources\\"+filename);
                    while (f.exists()) {
                        i++;
                        filename = "coverPic"+Integer.toString(i)+".png";
                        f = new File("C:\\Users\\WILLIAM\\Documents\\Netbeans\\Outdoors\\src\\edu\\esprit\\outdoors\\userresources\\"+filename);
                    }
                    f.createNewFile();
                    f.deleteOnExit();
                    
                    InputStream is1 = rs.getBinaryStream("cover_photo");
                    OutputStream os1 = new FileOutputStream(f);
                    byte[] content1 = new byte[1024];
                    int size1 = 0;
                    while ((size1 = is1.read(content1)) != -1){
                        os1.write(content1,0,size1);
                    }
                    os1.close();
                    is1.close();
                    
                    Image image1 = new Image("file:///C:/Users/WILLIAM/Documents/Netbeans/Outdoors/src/edu/esprit/outdoors/userresources/"+filename);
                    
                    p.setPhoto_cover(image1);
                }else{
                    p.setPhoto_cover(new Image ("file:///C:/Users/WILLIAM/Documents/Netbeans/Outdoors/src/edu/esprit/outdoors/userresources/cover_default_pic.png"));
                    
                }*/
                
              
               Image imgPhotoProfil = new Image(rs.getString("photo_profil"));
               p.setPhoto_profil(imgPhotoProfil);
               
              
               Image imgPhotoCover = new Image(rs.getString("cover_photo"));
               p.setPhoto_cover(imgPhotoCover);
               
               
               
              
               
               
                
                p.setTel(rs.getInt("tel"));
                p.setId_u(rs.getInt("id_user"));
                
                
            }
            ps.close();
            //  connection.close();
            
            
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ProfilServices.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        

                       
    
    }
    
    
    @Override
    public void insertImageToDb(File file,Profil p ){
    
        try{

              // String query = "INSERT INTO profil (photo) VALUES(?) where id_user=?";
                String requete = "update profil set photo_profil=? where id_user=?";

                ps = connection.prepareStatement(requete);
                

               File source = new File(file.toPath().toString());
               File dest = new File("C:\\wamp\\www\\image\\"+file.getName());
                
               
                
                ui.copyFileUsingStream(source, dest);
                
                ps.setString(1, "http://localhost/image/"+file.getName());
                ps.setInt(2, p.getId_u());
             
                ps.execute();

                ps.close();

            }catch(SQLException e1){

                System.err.println(e1);

            } catch (IOException ex) {
            Logger.getLogger(ProfilServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    
    
    @Override
    public void insertcoverToDb(File file,Profil p ){
    
        try{

              // String query = "INSERT INTO profil (photo) VALUES(?) where id_user=?";
                String requete = "update profil set cover_photo=? where id_user=?";

                ps = connection.prepareStatement(requete);
                


               File source = new File(file.toPath().toString());
               File dest = new File("C:\\wamp\\www\\image\\"+file.getName());
                
               
                
                ui.copyFileUsingStream(source, dest);
                
                ps.setString(1, "http://localhost/image/"+file.getName());
                ps.setInt(2, p.getId_u());
             
             
                ps.execute();

                ps.close();

            }catch(FileNotFoundException | SQLException e1){

                System.err.println(e1);

            } catch (IOException ex) {
            Logger.getLogger(ProfilServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    
    
    @Override
    public Profil getprofilByID(int idProfil) {

        Profil p = null;
            String requete2 = "select * from profil where id_profil="+"'"+idProfil+"'";
        try {
            
            
            ps = connection.prepareStatement(requete2);
            
            ResultSet rs = ps.executeQuery( requete2);
            while ( rs.next() ) {
                
                p = new Profil();
                p.setDetail(rs.getString("detail"));
                p.setGouvernorat(rs.getString("localisation"));
                p.setId_pr(rs.getInt("id_profil"));
                
                p.setSexe(rs.getString("sexe"));
                
               /* 
                
                if (rs.getBinaryStream("photo_profil")!= null){
                    
                    int i = 0;
                    String filename = "profilePic"+Integer.toString(i)+".png";
                    File f = new File("C:\\Users\\WILLIAM\\Documents\\Netbeans\\Outdoors\\src\\edu\\esprit\\outdoors\\userresources\\"+filename);
                    
                    if(f.exists())
                        while (f.exists()) {
                            i++;
                            filename = "profilePic"+Integer.toString(i)+".png";
                            f = new File("C:\\Users\\WILLIAM\\Documents\\Netbeans\\Outdoors\\src\\edu\\esprit\\outdoors\\userresources\\"+filename);
                        }
                    f.createNewFile();
                    f.deleteOnExit();

                    
                    InputStream is = rs.getBinaryStream("photo_profil");
                    OutputStream os = new FileOutputStream(f);
                    byte[] content = new byte[1024];
                    int size = 0;
                    while ((size = is.read(content)) != -1){
                        os.write(content,0,size);
                    }
                    os.close();
                    is.close();
                    
                    Image image = new Image("file:///C:/Users/WILLIAM/Documents/Netbeans/Outdoors/src/edu/esprit/outdoors/userresources/"+filename);
                    
                    
                    //  Image image = SwingFXUtils.toFXImage(img, null);
                    p.setPhoto_profil(image);
                }else {
                    p.setPhoto_profil(new Image ("file:///C:/Users/WILLIAM/Documents/Netbeans/Outdoors/src/edu/esprit/outdoors/userresources/profil_default_pic.png"));
                }
                
                
                if (rs.getBinaryStream("cover_photo")!=null){
                    
                    int i = 0;
                    String filename = "coverPic"+Integer.toString(i)+".png";
                    File f = new File("C:\\Users\\WILLIAM\\Documents\\Netbeans\\Outdoors\\src\\edu\\esprit\\outdoors\\userresources\\"+filename);
                    while (f.exists()) {
                        i++;
                        filename = "coverPic"+Integer.toString(i)+".png";
                        f = new File("C:\\Users\\WILLIAM\\Documents\\Netbeans\\Outdoors\\src\\edu\\esprit\\outdoors\\userresources\\"+filename);
                    }
                    f.createNewFile();
                    f.deleteOnExit();
                    
                    InputStream is1 = rs.getBinaryStream("cover_photo");
                    OutputStream os1 = new FileOutputStream(f);
                    byte[] content1 = new byte[1024];
                    int size1 = 0;
                    while ((size1 = is1.read(content1)) != -1){
                        os1.write(content1,0,size1);
                    }
                    os1.close();
                    is1.close();
                    
                    Image image1 = new Image("file:///C:/Users/WILLIAM/Documents/Netbeans/Outdoors/src/edu/esprit/outdoors/userresources/"+filename);
                    
                    p.setPhoto_cover(image1);
                }else{
                    p.setPhoto_cover(new Image ("file:///C:/Users/WILLIAM/Documents/Netbeans/Outdoors/src/edu/esprit/outdoors/userresources/cover_default_pic.png"));
                    
                }
                */
                
                System.out.println(rs.getString("photo_profil"));
               Image imgPhotoProfil = new Image(rs.getString("photo_profil"));
               p.setPhoto_profil(imgPhotoProfil);
               
              
               Image imgPhotoCover = new Image(rs.getString("cover_photo"));
               p.setPhoto_cover(imgPhotoCover);
               
               
                p.setTel(rs.getInt("tel"));
                p.setId_u(rs.getInt("id_user"));
                
                
            }
            
            ps.close();
            //  connection.close();
            
          return p;
          
          
        } catch (SQLException ex) {
            Logger.getLogger(ProfilServices.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        

    }

    
    
    @Override
    public ObservableList<Profil> findbyname(String name) {
         String requete2 = "select * from profil where nom like "+"'%"+name+"%'";
        
        ObservableList<Profil> profil = FXCollections.observableArrayList();

        try {
            ps = connection.prepareStatement(requete2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 Profil p = new Profil();
                
                p.setDetail(rs.getString("detail"));
                p.setGouvernorat(rs.getString("localisation"));
                p.setId_pr(rs.getInt("id_profil"));
                
                p.setSexe(rs.getString("sexe"));
                
                /*
                
                int i = 0;
                String filename = "profilePic"+Integer.toString(i)+".png";
                File f = new File("C:\\Users\\WILLIAM\\Documents\\Netbeans\\Outdoors\\src\\edu\\esprit\\outdoors\\userresources\\"+filename);
                while (f.exists()) {
                    i++;
                    filename = "profilePic"+Integer.toString(i)+".png";
                    f = new File("C:\\Users\\WILLIAM\\Documents\\Netbeans\\Outdoors\\src\\edu\\esprit\\outdoors\\userresources\\"+filename);
                }
                f.createNewFile();
                f.deleteOnExit();
                
                try (InputStream is = rs.getBinaryStream("photo_profil"); OutputStream os = new FileOutputStream(f)) {
                    byte[] content = new byte[1024];
                    int size = 0;
                    while ((size = is.read(content)) != -1){
                        os.write(content,0,size);
                    }
                }
                
                Image image = new Image("file:///C:/Users/WILLIAM/Documents/Netbeans/Outdoors/src/edu/esprit/outdoors/userresources/"+filename);
                
                
                //  Image image = SwingFXUtils.toFXImage(img, null);
                p.setPhoto_profil(image);
                p.setPhoto_cover(null);
               */
              
               Image imgPhotoProfil = new Image(rs.getString("photo_profil"));
               p.setPhoto_profil(imgPhotoProfil);
               
              
               Image imgPhotoCover = new Image(rs.getString("cover_photo"));
               p.setPhoto_cover(imgPhotoCover);
               
               
                
                p.setTel(rs.getInt("tel"));
                p.setId_u(rs.getInt("id_user"));
                
                
            }
            ps.close();
            //  connection.close();
            
          return profil;
          
          
        } catch (SQLException ex) {
            Logger.getLogger(ProfilServices.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        

    }
    
    
  
    @Override
    public void updatename(String newName ,Utilisateurs u){
    
        try{

              // String query = "INSERT INTO profil (photo) VALUES(?) where id_user=?";
                String requete = "update fos_user set nom=? where id=?";

                ps = connection.prepareStatement(requete);
                


              
                ps.setString(1, newName);
                ps.setInt(2, u.getId_user());
             
             
                ps.execute();
                ps.close();

            }catch(SQLException e1){

                System.err.println(e1);

            }
        
    
    
    }
    
       @Override
    public void updatefirstname(String newName ,Utilisateurs u){
    
        try{

              // String query = "INSERT INTO profil (photo) VALUES(?) where id_user=?";
                String requete = "update fos_user set prenom=? where id=?";

                ps = connection.prepareStatement(requete);
                


              
                ps.setString(1, newName);
                ps.setInt(2, u.getId_user());
             
             
                ps.execute();
                ps.close();

            }catch(SQLException e1){

                System.err.println(e1);

            }
        
    
    
    }
    
    
    
    
    @Override
     public void updateGov(String newGov ,Profil p){
    
        try{

              // String query = "INSERT INTO profil (photo) VALUES(?) where id_user=?";
                String requete = "update profil set localisation=? where id_user=?";

                ps = connection.prepareStatement(requete);
                


              
                ps.setString(1, newGov);
                ps.setInt(2, p.getId_u());
             
             
                ps.execute();
                p.setGouvernorat(newGov);
                ps.close();

            }catch(SQLException e1){

                System.err.println(e1);

            }
    
     }
    
    
     
    @Override
       public void updateInfo(String newInfo ,Profil p){
    
        try{

              // String query = "INSERT INTO profil (photo) VALUES(?) where id_user=?";
                String requete = "update profil set detail=? where id_user=?";

                ps = connection.prepareStatement(requete);
                


              
                ps.setString(1, newInfo);
                ps.setInt(2, p.getId_u());
             
             
                ps.execute();
                p.setDetail(newInfo);
                ps.close();

            }catch(SQLException e1){

                System.err.println(e1);

            }
    
     }
       
       
    @Override
        public void updateTel(long newTel ,Profil p){
    
        try{

              // String query = "INSERT INTO profil (photo) VALUES(?) where id_user=?";
                String requete = "update profil set tel=? where id_user=?";

                ps = connection.prepareStatement(requete);
                


              
                ps.setLong(1, newTel);
                ps.setInt(2, p.getId_u());
             
             
                ps.execute();
                p.setTel(newTel);
                ps.close();

            }catch(SQLException e1){

                System.err.println(e1);

            }
    
     }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
