/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.david;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author david_perez
 */
public class Main {
    private static BigInteger[] Factoriales; 
    /**
     * @param args the command line arguments
     */
    private static void Factorial(int n){
        Arrays.fill(Factoriales,BigInteger.ONE);
        for (int i = 1; i <= n; i++) {
            int x = i-1;
            Factoriales[i] = Factoriales[x].multiply(BigInteger.valueOf(i));
            
        }
   
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
      int  n = 30000;
      Factoriales = new BigInteger[n+1];
      Factorial(n);
      int a;
      Scanner read = new Scanner(System.in);
      a = read.nextInt();
      while(a>=0){
        System.out.println("El factorial de: "+ a + " es: " + Factoriales[a]);
        a = read.nextInt();
      }
    
}
}