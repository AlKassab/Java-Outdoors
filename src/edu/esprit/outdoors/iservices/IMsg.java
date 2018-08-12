/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.iservices;

import edu.esprit.outdoors.models.Utilisateurs;
import java.util.List;

/**
 *
 * @author WILLIAM
 */
public interface IMsg<T, P> {

    void add(T t, P p);


    //List<T> DisplayAll();

    //void update(T t, P p);

    //void delete(int id);

}
