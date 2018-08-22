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
public class Main_class {
    private static  int horasSem = 24*7;
    private static int horasDia = 24;
    private  static int Semanas;
    private  static int Dias;
    private static int Horas;
    private static void CalcularSemanas()
    {
        if(Horas >= horasSem){
            Semanas = Horas/horasSem;
            Horas -= (Semanas*horasSem);
        }
    }
    private static void CalcularDias()
    {
        if(Horas >= horasDia){
            Dias = Horas/horasDia;
            Horas -= (Dias*horasDia);
        }
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Horas = read.nextInt();
        CalcularSemanas();
        CalcularDias();
        System.out.println(Semanas +" Semanas " + Dias + " Dias " + Horas + " Horas ");
    }
    
}
