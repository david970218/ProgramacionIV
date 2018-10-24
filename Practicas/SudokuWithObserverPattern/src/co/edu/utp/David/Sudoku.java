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
public class Sudoku {
    Cell[][] cells = new Cell[9][9];
    
    public Sudoku(){
     init();
    }
    
    public void setUp(int [][] puzzle){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(puzzle[i][j] != 0 ){
                    cells[i][j].setValues(puzzle[i][j]);
                if(i == 1 && j == 5 )
                    System.out.println("aqui hay un lindo " +puzzle[i][j] + " y puse un lindo " + cells[i][j].getValue() );
                }
            }
        }
        System.out.println(this);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(cells[i][j].getValue() == 0){
                    if(j > 0){
                    
                    puzzle[i][j] = cells[i][j].forceValue(cells[i][j-1].getValue());
                   
                    }else
                    {   if(i > 0)
                        //cells[i][j].setValues(cells[i][j].
                        puzzle[i][j] = cells[i][j].forceValue(cells[i - 1][8].getValue());
                    }
                    System.out.println(puzzle[i][j]+"===");
                    init();
                    setUp(puzzle);
                    break;
                    
                    
                }
            }
        }
        
        
    }
    
    public void init(){
           for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
            for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j].addObserver(cells);
            }
        }
    }
    public int getCellValue(int i, int j){
        return cells[i][j].getValue();
    }
    
    @Override
    public String toString(){
        String tosstring = "";
        for (int j = 0; j < 9; j++){
            for (int i = 0; i < 9; i++) {
                tosstring += getCellValue(j,i);
                if(i == 2 || i == 5){
                    tosstring += "  ";
                }else
                    if(i == 8){
                        tosstring += '\n';
                    }
            }
            if(j == 2 || j == 5){
                tosstring += '\n';
            }
        }
        return tosstring;
    }
}
