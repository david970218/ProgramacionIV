/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author david_perez
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int a;
        a = read.nextInt();
        while(a != 0){
        if(a % 2 == 0)
            System.out.println("El numero " +  a + " es par");
        else
            System.out.println("El numero " +  a + " es im"+ "par");
        a = read.nextInt();
        System.out.flush();
        }
    }
    
}
