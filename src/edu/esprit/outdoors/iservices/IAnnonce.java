/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.iservices;

import java.util.List;

/**
 *
 * @author ASUS I7
 */
public interface IAnnonce<T,R> {
     void add(T t);
    void delete(R r);
    List<T> getAll();
    void modify(T t,R r);
    
}
