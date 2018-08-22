/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.david;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Main {
   private static boolean[] primos;
   static int tamanio;
   private static void Primes()
   {
       int prime = 2;
       int bandera =0;
       primos[0] = primos[1] = false;
       
        while(prime<=tamanio)
        {
            
           for (int i = prime; i <=tamanio; i += prime) {
               primos[i] = false;
           }
           primos[prime] = true;
           prime++;
           while(prime <= tamanio)
           {
               if(primos[prime] == false)
                   prime++;
               else 
                   break;
               
                
           }
           if(prime*prime > tamanio)
               break;
           
        }
        
     
   }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int a;
        tamanio = 10000000;
        
        primos = new boolean[tamanio+1];
        Arrays.fill(primos,true);
        Primes();
        a = reader.nextInt();
        while(a>=0){
            if(primos[a] == true)
                System.out.println(a + " es un numero primo");
            else
                System.out.println(a +" es un numero compuesto");
            a = reader.nextInt();
        }
    }
    
}
