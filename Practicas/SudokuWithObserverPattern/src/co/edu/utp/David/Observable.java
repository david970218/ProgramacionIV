/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David;

/**
 *
 * @author david_perez
 */
public interface Observable {
  public void Notify(Object o);
  public void addObserver(Observer o);
}
