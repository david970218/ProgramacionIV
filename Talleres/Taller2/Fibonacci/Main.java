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
public class Main {
    private static long[] Fibonacci;
    private static void Fibbonacci(int tam)
    {
        Fibonacci[1] = Fibonacci[2] = 1;
        for (int i = 3; i < tam-1; i++) {
            int j = i-1,k=i-2;
            Fibonacci[i] = Fibonacci[k]+Fibonacci[j];
        }
        
    }
    public static void main(String[] args) {
        int tam = 1000000;
        Fibonacci = new long[tam-1];
        Fibbonacci(tam);
        int a;
        Scanner read = new Scanner(System.in);
        a = read.nextInt();
        while (a>=0)
        {
            System.out.println("El Fibonacci en la poscicion "+ a + " es: "+ Fibonacci[a]);
            a = read.nextInt();
        }
        
    }
    
}
