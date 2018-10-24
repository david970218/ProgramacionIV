/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David;

import java.util.ArrayList;
import java.util.List;
import co.edu.utp.David.Cell;
/**
 *
 * @author david_perez
 */
public class Cell implements Observer,Observable{
    
    private List<Observer> observadores = new ArrayList<Observer>();
    private  List Values = new ArrayList();
    private Integer value;
    private boolean isSolved = false;
    private int row,col;
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        for (int i = 1; i <= 9; i++) {
            Values.add(new Integer(i));

        }
        
    }
 
    

    @Override
    public void Notify(Object a) {
        
        for(Observer o : observadores){
           
           
                o.update(a,this);
        }
    }

    public void addObserver(Cell[][] cells) {
                            
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boolean isSame = (i == row) && (j== col);
                boolean isSameline = (i == row) || (j == col);
                boolean isSecondary = (i/3 == row/3) && (j/3 == col/3);
                
                if(!isSame &&(isSameline || isSecondary)){
                    addObserver(cells[i][j]);
         
                    
                }
            }
        }
        
    }
    
    public void setValues(int value){
        Values.clear();   
        Values.add(value);

        isSolved = true;
        Notify(new Integer(value));
        
    }
    
    @Override
    public void addObserver(Observer o) {
        observadores.add(o);
}

    @Override
    public void update(Object o, Observable x) {
        Cell aux = (Cell) x;
        Values.remove(o);
        if(row == 1 && (col == 7) )
        System.out.println(this.getPosition() + " " + Values.size() +" "+ aux.getPosition() + "  mando a eliminaar: " + (int) o );
        if(!isSolved && Values.size() == 1){
            Integer value = (Integer) Values.get(0);
            setValues(value.intValue());
        }
    }

    public boolean isIsSolved() {
        return isSolved;
    }
    
    private String getPosition(){
        return "(" + row + "," + col +")";
    }
    
    public int forceValue(int a){
        if(row == 1 && col == 5)
        System.out.println(this.getPosition() +" " + Values.size() + "**" + a);
        if(Values.contains(a+1)){
            Values.remove(new Integer(a+1));
            return a+1;
        }
        else
           return (int) Values.get(0);
    }
    
    public int getValue(){
        if(Values.size() == 1){
            return (Integer)Values.get(0);
        }
        return 0;
    }
}
