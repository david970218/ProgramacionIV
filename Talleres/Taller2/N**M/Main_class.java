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
public class Main_class {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N,m;
        Scanner read = new Scanner(System.in);
        N = read.nextInt();
        m = read.nextInt();
        System.out.print(N +"^" + m + " = ");
        for (int i = 1; i <= m; i++) {
            System.out.print(N);
            if(i<m)
                System.out.print(" * ");
            }
        System.out.println(" = "+ (int) Math.pow(N,m));
    }
    
}
