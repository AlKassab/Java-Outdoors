/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.utils;

import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;

/**
 *
 * @author WILLIAM
 */
public class Notifications {
    
    
                
    public static void notifApi(String titre,String message){
                
        tray.notification.TrayNotification tr = new tray.notification.TrayNotification();
                tr.setTitle(titre);
                tr.setMessage(message);
                tr.setNotificationType(NotificationType.SUCCESS);
                tr.setAnimationType(AnimationType.SLIDE);
                tr.showAndDismiss(Duration.seconds(2));
    
    
    }
   
}
