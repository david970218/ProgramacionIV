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
            int [][] puzzle = {

{2, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0}

};

       Sudoku sudoku = new Sudoku();
       sudoku.setUp(puzzle);
       System.err.println(sudoku);
        



    }
    
}
