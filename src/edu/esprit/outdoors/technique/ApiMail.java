///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.esprit.outdoors.technique;
//
//import com.jfoenix.controls.JFXButton;
//import java.net.Authenticator;
//import java.net.PasswordAuthentication;
//import java.net.URL;
//import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TextArea;
//import javafx.scene.input.MouseEvent;
//import javax.mail.*;
//import javax.mail.internet.*;
//
//public class ApiMail implements Initializable{
//  
// 
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//     
//    }   
//
//    private class SMTPAuthenticator extends Authenticator {
//
//        private   PasswordAuthentication authentication;
//
//        public  SMTPAuthenticator(String login, String password) {
//            authentication = new PasswordAuthentication(login, password);
//        }
//
//        @Override
//        protected PasswordAuthentication getPasswordAuthentication() {
//            return authentication;
//        }
//    }
//
//    public  void envoyermail(String a, String b, String c) {
//
//        String from = "outdoors20162017@gmail.com";
//        String to = a;
//        String subject = b;
//        String message = c;
//        String login = "outdoors20162017@gmail.com";
//        String password = "outdoors1617";
//
//        Properties props = new Properties();
//        props.setProperty("mail.host", "smtp.gmail.com");
//        props.setProperty("mail.smtp.port", "587");
//        props.setProperty("mail.smtp.auth", "true");
//        props.setProperty("mail.smtp.starttls.enable", "true");
//
//        Authenticator auth = new SMTPAuthenticator(login, password);
//
//        Session session = Session.getInstance(props, auth);
//
//        MimeMessage msg = new MimeMessage(session);
//
//        try {
//            msg.setText(message);
//            msg.setSubject(subject);
//            msg.setFrom(new InternetAddress(from));
//            msg.addRecipient(Message.RecipientType.TO,
//                    new InternetAddress(to));
//            Transport.send(msg);
//        } catch (MessagingException ex) {
//            Logger.getLogger(ApiMail.class.getName()).
//                    log(Level.SEVERE, null, ex);
//        }
//    }
//}
