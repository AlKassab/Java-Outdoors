/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author WILLIAM
 */
public class ValidationFields {
    
    private static boolean validateEmail(String email){
    
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
 
    Matcher matcher = pattern.matcher(email);
    return matcher.find();
 
    }
    
    private static boolean confirmPassW(String pass,String passc){
    
    if (pass==passc){return true;}
    return false;
    }
    
    
}
