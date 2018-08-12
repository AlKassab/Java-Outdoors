/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author WILLIAM
 */
public class Validator {
    
    public static Boolean emailvalidator(String email){

         String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
 
    Matcher matcher = pattern.matcher(email);
    return matcher.find();
 
    }
    
    public static boolean confirmPassW(String pass,String passc){
    
    return pass.equals(passc);
    }

    public static boolean champVide(String name){
    
    return name.isEmpty();
    }
    
    public static boolean nameSize(String name){
    
        return name.length() >= 3;
    }
    
    public static boolean passwwordVerification(String pass1,String pass2){
    
        return pass1.equals(pass2);
    }

    
    
    
}
