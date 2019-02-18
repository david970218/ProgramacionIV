/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David;

import java.util.Scanner;

/**
 *
 * @author david_perez
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       int [][] puzzle = new int [9][9];
       
       /*
       Scanner read = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print("Ingrese el numero en fila " + (i+1) + " Columna " + (j+1) + " ");
                puzzle[i][j] = read.nextInt();
            }
        }
        */
            int [][] puzzle ={

{ 8,0, 5, 0, 0, 6, 2, 9, 0},

{2, 0, 9, 0, 0, 0, 0, 0, 8},

{0, 0, 0, 9, 2, 8, 0, 0, 1},

{1, 5, 3, 8, 9, 4, 6, 0, 0},

{4, 9, 2, 6, 7, 3, 8, 1, 5},

{6, 8, 7, 1, 5, 2, 3, 4, 9},

{0, 0, 0, 3, 8, 0, 0, 0, 4},

{7, 0, 0, 0, 0, 0, 0, 8, 6},

{0, 0, 8, 0, 0, 7, 1, 0, 0}

};
       Sudoku sudoku = new Sudoku();
       sudoku.setUp(puzzle);
       System.err.println(sudoku);
        



    }
    
}
