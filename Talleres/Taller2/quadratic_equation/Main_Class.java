/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.david;

import java.util.Scanner;

/**
 *
 * @author david_perez
 */
public class Main_Class {
private static int a;
private static int b;
private static int c;
private static double b2_4ac , x1 ,x2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read;
        double aux;
        read = new Scanner(System.in);
        System.out.print("Ingrese el coeficiente a: ");
        a = read.nextInt();
        System.out.print("Ingrese el coeficiente b: ");
        b = read.nextInt();
        System.out.print("Ingrese el coeficiente c: ");
        c = read.nextInt();
        while(a != 0 || b!= 0 || c!= 0)
        {
            
            b2_4ac = (b*b)-(4*a*c);
            if(b2_4ac >= 0 && a != 0)
            {
                aux = Math.sqrt(b2_4ac);
                x1 = ((-b) + aux) / (2*a);
                x2 = ((-b) - aux) / (2*a);
                System.out.println("X = " + x1 + " O X = " + x2);
            }else
                System.out.println("la ecuacion: " + a +"x² + " + b +"x + " + c + " = 0 No tiene solucion");
            System.out.print("Ingrese el coeficiente a: ");
            a = read.nextInt();
            System.out.print("Ingrese el coeficiente b: ");
            b = read.nextInt();
            System.out.print("Ingrese el coeficiente c: ");
            c = read.nextInt();
            
            
        }
    }
    
}
