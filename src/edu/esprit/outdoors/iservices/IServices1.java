/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.iservices;

import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author macbookpro
 */
public interface IServices1<T,R,S,E,P> {
    void add(T t);

    void delete(T t);
//
   ObservableList<T> getAll();
    ObservableList<T> Rechercher(String s);
       ObservableList<T> RechercherMine(String s);
//   ObservableList<P> getParticipants(R r);
 ObservableList<T> getMine();
//    List<T> getA();
  void modify(T t);
   T getInfo(R r);
    
    
    
}
