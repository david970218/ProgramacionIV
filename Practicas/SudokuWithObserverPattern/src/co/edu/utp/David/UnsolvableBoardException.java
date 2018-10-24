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
public class UnsolvableBoardException extends Exception{

    public UnsolvableBoardException() {
       
    }
    
    @Override
    public String toString(){
       return "Sudoku imposible de resolver"; 
    }
    
}
