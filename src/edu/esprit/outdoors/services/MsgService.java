/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.services;

import edu.esprit.outdoors.iservices.IMsg;
import edu.esprit.outdoors.models.Profil;
import edu.esprit.outdoors.models.Message;
import edu.esprit.outdoors.technique.DbConnection;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author WILLIAM
 */
public class MsgService  implements IMsg<Message,Profil>{
    
    private Connection connection;
    private PreparedStatement ps,ps2;
    private Statement c;
    private CallableStatement ps3;
    public  static Message msg;
    private FileInputStream fis;

    public MsgService() {
        connection = DbConnection.getInstance().getConnection();
        if(connection == null){
            System.out.println("Connection not successful");
            System.exit(1);
        }
        else{
            System.out.println("Connection  successful");
        }
    }
  
    
    
    public List<String> choisirDestinataire(){
        
        List<String> tab = new ArrayList<String>();

        
        try {
            
            String requete="select username from fos_user";
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

    @Override
    public void add(Message t, Profil p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void SendMsg(String s1, String s2, String s3) {
        String req = "insert into messages (`contenu`, `destinataire`, `expediteur`) values (?,?,?)";
        try {
            ps = connection.prepareStatement(req);
            ps.setString(1, s1);
            ps.setString(2, s2);
            ps.setString(3, s3);
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Message> toMe(String who) {
        String req = "SELECT `contenu`, `destinataire`, `expediteur` FROM `messages` WHERE destinataire = ?";
        List<Message> Msgs = new ArrayList<>();
        try {
            ps = connection.prepareStatement(req);
            ps.setString(1, who);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Message m = new Message(rs.getString(1), rs.getString(2), rs.getString(3));
                Msgs.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msgs;
    }
    
    public List<Message> fromMoi(String who) {
        String req = "SELECT `contenu`, `destinataire`, `expediteur` FROM `messages` WHERE expediteur = ?";
        List<Message> Msgs = new ArrayList<>();
        try {
            ps = connection.prepareStatement(req);
            ps.setString(1, who);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Message m = new Message(rs.getString(1), rs.getString(2), rs.getString(3));
                Msgs.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msgs;
    }
    
    
}
