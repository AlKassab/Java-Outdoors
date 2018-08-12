/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.services;

import edu.esprit.outdoors.iservices.ICamping;
import edu.esprit.outdoors.models.Camping;
import edu.esprit.outdoors.models.Etat;
import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Utilisateurs;
import edu.esprit.outdoors.technique.DbConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Pair;

/**
 *
 * @author Ahmed Samti
 */
public class CampingService implements ICamping {
    private Connection connection = UserService.connection;
    private PreparedStatement ps;
    private Statement co;
    UserService Us=new UserService();
    ProfilServices PS = new ProfilServices();
    int idcamp ;
    
    public void setidcamp(int id){
    id = idcamp;
    }
    public int getidcamp(){
    return idcamp;
    }
    
    
    
    
    public CampingService() {
        
    }


    @Override
   public void add(Camping c) {
        
        
         /*String req = "insert into camping (nom,lieu,date,description,id_utilisateur) values(?,?,?,?,?)";;
        try {
            ps = connection.prepareStatement(req);
            ps.setString(1,c.getNom());
          
            ps.setString(2,c.getLieu());
             
            ps.setDate(3,(java.sql.Date)  c.getDate());
            ps.setString(4, c.getDescription());
            ps.setInt(5, c.getOrganisateur().getId_user());
            ps.executeUpdate();
         } catch (Exception e) {
            e.printStackTrace();
        }*/
       


         String req = "insert into camping (nom,lieu,date,description,id_utilisateur) values(?,?,?,?,?)";;
        try {
            ps = connection.prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);
            
            
            ps.setString(1,c.getNom());
          
            ps.setString(2,c.getLieu());
             
            ps.setDate(3,(java.sql.Date)  c.getDate());
            ps.setString(4, c.getDescription());
            ps.setInt(5, c.getOrganisateur().getId_user());
            ps.executeUpdate();
          
   ResultSet rs = ps.getGeneratedKeys();
    rs.next();
            setidcamp(rs.getInt(1));

//            
//             ResultSet keys = ps.getGeneratedKeys();
//  int lastKey = 1;
//  
//   while (keys.next()) {
//    lastKey = keys.getInt(1);
//  }
//  PreparedStatement pstmt;
//
//   String req2="insert into campers(id_camp,id_utilisateur,etat) VALUES (?,?,?)";
//   
//        Iterator<Utilisateurs> i=c.getInvités().iterator();
//             while(i.hasNext())
//             {
//                    Utilisateurs p=i.next(); 
//                     pstmt=connection.prepareStatement(req2);
//                     pstmt.setInt(1,lastKey);
//                     pstmt.setInt(2,p.getId_user());
//                      pstmt.setString(3,Etat.invité.name());
//
//                 pstmt.executeUpdate();
//             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

    
    
    @Override
    public void update(int id,Utilisateurs U) {
     
         String req="INSERT INTO campers(`id_camp`, `id_utilisateur`) VALUES (?,?)";
            try {
                     ps = connection.prepareStatement(req);
            ps.setInt(1,id);
             ps.setInt(2,U.getId_user());
      
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void delete(Integer n) {
          PreparedStatement ps1;
          
        String req = "delete from camping where id_camp = ?";
       
         String req1="DELETE FROM campers WHERE id_camp =?";
        try {
            ps = connection.prepareStatement(req);
             ps1 = connection.prepareStatement(req1);
            ps.setInt(1, n);
              ps1.setInt(1, n);
            System.out.println( ps.executeUpdate());
            System.out.println( ps1.executeUpdate());   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   /* @Override
    public List<Profil> getListUtilisateurs(int id) {
           List<Profil>  ar=new ArrayList<>();
        
          String req1 = "SELECT `id_utilisateur`,`etat` FROM `campers` WHERE  `id_camp`="+id;
          try{
          ps = connection.prepareStatement(req1);
          ResultSet r=ps.executeQuery();
          while(r.next())
          {
             
              String req2 = "SELECT * FROM `utilisateurs` WHERE `id_utilisateur`=?";
      
       
          PreparedStatement  ps1 = connection.prepareStatement(req2);
          ps1.setInt(1, r.getInt(1));
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                
                Profil p;
                p = new Profil(rs.getString(2));
          
              
            ar.add(p);
   
          }
          
          }
          }
           catch (Exception e) {
            e.printStackTrace();
        }
        return ar;
    }
*/
    @Override
    public List<Camping> getInvitations(int id) {
        
        PreparedStatement ps1;
        String req = "select id_camp from campers where id_utilisateur="+id+" etat= 'invité' ";
        List<Camping> campings = new ArrayList<>();
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              String req1="select nom from camping where id_camp=?";
               ps1 = connection.prepareStatement(req1);
               ps1.setInt(1, rs.getInt(1));
               ResultSet r=ps1.executeQuery();
               r.next();
               Camping c=new Camping(r.getString(1));
               campings.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return campings;
    }

    @Override
    public List<Camping> getParticipations(int id) {
      PreparedStatement ps1;
        String req = "select id_camp from campers where id_utilisateur="+id+" etat= 'participant' ";
        List<Camping> campings = new ArrayList<>();
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              String req1="select nom from camping where id_camp=?";
               ps1 = connection.prepareStatement(req1);
               ps1.setInt(1, rs.getInt(1));
               ResultSet r=ps1.executeQuery();
               r.next();
               Camping c=new Camping(r.getString(1));
               campings.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return campings;   
    }

   

    @Override
    public void changeEtat(Etat etat,int id, Camping camping) {
      
          String req = "UPDATE `campers` SET `etat`=? WHERE id_utilisateur=? and `id_camp`=?";
       
        try {
            ps = connection.prepareStatement(req);
           ps.setString(1, etat.name());
           ps.setInt(2, id);
           ps.setInt(3, camping.getId_camp());
           ps.executeUpdate();
         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCamper(Camping c, Utilisateurs u) {
    
    String req2="insert into campers(id_camp,id_utilisateur,etat) VALUES (?,?,?)";
    
    try {
            ps = connection.prepareStatement(req2);
            
            ps.setInt(1,c.getId_camp());
          
            ps.setInt(2,u.getId_user());
             
            
            ps.setString(3, Etat.invité.toString());
            
            ps.executeUpdate();
         } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    
    }
    
    
    @Override
    public ObservableList<Camping> DisplayAll() {
       
        ObservableList<Camping> listeCamp = FXCollections.observableArrayList();
        String requete = "select * from publication";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet rs = statement.executeQuery(requete);


            while (rs.next()) {
                Camping c = new Camping();
                
                c.setId_camp(rs.getInt("id_camp"));
                c.setNom(rs.getString("nom"));
                c.setOrganisateur(Us.getById(rs.getInt("id_utilisateur")));
                c.setLieu(rs.getString("lieu"));
                c.setDate(rs.getDate("date"));
                c.setDescription(rs.getString("description"));
                
                
                listeCamp.add(c);
            }
          
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des Publications " + ex.getMessage());
            
        }
        return  listeCamp;  
    
    }

    @Override
    public List<Profil> getListUtilisateurs(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public ObservableList<Camping> DisplayAllbyuser(int idUser) {
       
        ObservableList<Camping> listeCamp = FXCollections.observableArrayList();
        String requete = "select * from camping where id_utilisateur="+"'"+idUser+"'";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet rs = statement.executeQuery(requete);


            while (rs.next()) {
                Camping c = new Camping();
                
                c.setId_camp(rs.getInt("id_camp"));
                c.setNom(rs.getString("nom"));
                c.setOrganisateur(Us.getById(rs.getInt("id_utilisateur")));
                c.setLieu(rs.getString("lieu"));
                c.setDate(rs.getDate("date"));
                c.setDescription(rs.getString("description"));
                
                
                listeCamp.add(c);
            }
          
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des Publications " + ex.getMessage());
            
        }
        return  listeCamp;  
    
    }
   
      @Override
    public ObservableList<Camping> SearchByName(String nom,int idUser) {
       
        ObservableList<Camping> listeCamp = FXCollections.observableArrayList();
        String requete = "select * from camping where nom like "+"'%"+nom+"%'and id_utilisateur like"+"'%"+idUser+"%'";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet rs = statement.executeQuery(requete);


            while (rs.next()) {
                Camping c = new Camping();
                
                c.setId_camp(rs.getInt("id_camp"));
                c.setNom(rs.getString("nom"));
                c.setOrganisateur(Us.getById(rs.getInt("id_utilisateur")));
                c.setLieu(rs.getString("lieu"));
                c.setDate(rs.getDate("date"));
                c.setDescription(rs.getString("description"));
                
                
                listeCamp.add(c);
            }
          
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des Publications " + ex.getMessage());
            
        }
        return  listeCamp;  
    
    }

    @Override
    public Camping getcampingbyId(int idcam) {
    
     String requete = "select * from camping where id_camp=?";
     try { 
     ps = connection.prepareStatement(requete);
            ps.setInt(1, idcam);
            ResultSet rs = ps.executeQuery();
      
           

 
            while (rs.next()) {
                Camping c = new Camping();
                
                c.setId_camp(rs.getInt("id_camp"));
                c.setNom(rs.getString("nom"));
                c.setOrganisateur(Us.getById(rs.getInt("id_utilisateur")));
                c.setLieu(rs.getString("lieu"));
                c.setDate(rs.getDate("date"));
                c.setDescription(rs.getString("description"));
                
                
               return c;}
          
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des Publications " + ex.getMessage());
            
        }
        return null;  
    
        
    }
    
    
   
    public Camping getcampingbylastId() {
    
     String requete = "select * from camping where id_camp=@last_ID";
     try { 
            ps = connection.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
      
           

 
            while (rs.next()) {
                Camping c = new Camping();
                
                c.setId_camp(rs.getInt("id_camp"));
                c.setNom(rs.getString("nom"));
                c.setOrganisateur(Us.getById(rs.getInt("id_utilisateur")));
                c.setLieu(rs.getString("lieu"));
                c.setDate(rs.getDate("date"));
                c.setDescription(rs.getString("description"));
                
                
               return c;}
          
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des Publications " + ex.getMessage());
            
        }
        return null;  
    
        
    }
   
}
