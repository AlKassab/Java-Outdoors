/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.outdoors.iservices;

import edu.esprit.outdoors.models.Photo;
import edu.esprit.outdoors.models.Publication;
import java.io.File;

/**
 *
 * @author WILLIAM
 */
public interface IPhoto extends IPublication<Photo>{
    
   void addwith(Photo p , File f);
}
