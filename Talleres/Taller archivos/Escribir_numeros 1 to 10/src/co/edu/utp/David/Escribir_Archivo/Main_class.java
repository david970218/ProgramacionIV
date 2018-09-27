/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Escribir_Archivo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author david_perez
 */
public class Main_class {
    private static Archivo file;
    private static LeeArchivo la; 
    static File folder;
    static String directorio;
    static String menu = "*************Menu*************\n"
            + "1) Crear Archivo\n"
            + "2) llenar Archivo\n"
            + "3) calcular Promedio de los numeros en el archivo\n"
            + "4) Vacear Archivo\n"
            + "5) Eliminar Archivo\n"
            + "0) Salir."
            ;
    /**
     * @param args the command line arguments
     */
    private static void crearDirectorio(){
        folder = new File(System.getProperty("user.home") + 
        File.separator + "Documentos" +  File.separator + 
        "Archivo"+File.separator);
        folder.mkdirs();
        directorio = folder + File.separator +"archivo.txt";
    }
    
    private static void llenarArchivo(int a)
    {
        Scanner Read;
        Read = new Scanner(System.in);
        for (int i = 1; i <= a; i++)
            file.llenarArchivo(Read.nextInt());
    }
    
    private static void Menu() throws IOException, InterruptedException
    {
        int opc,A;
        Scanner read;
        read = new Scanner(System.in);
        System.out.println(menu);
        while(0 != (opc = read.nextInt()))
        {
            
            switch(opc)
            {
                case 1:
                    file = new Archivo(directorio);
                    la = new LeeArchivo(directorio);
                    System.out.println("Archivo Creado con exito");
                    break;
                case 2:
                    if(file != null){
                    System.out.println("\n\n Ingrese la cantidad de numeros a ingresar: ");
                    int a = read.nextInt();
                    llenarArchivo(a);
                    }
                    else{
                        System.err.println("Cree Primero El Archivo por favor");
                    }
                    break;
                case 3:
                    if(la != null)
                        System.out.println("El promedio es: "+ la.calculaPromedio());
                    else{
                        System.err.println("Cree Primero El Archivo por favor");
                    }
                    break;
                case 4:
                    if(file != null){
                        file.vacearArchivo();
                        System.out.println("Archivo Vacio");
                    }
                    else{
                        System.err.println("Cree Primero El Archivo por favor");
                    }
                    break;
                case 5:
                    file.eliminarArchivo();
                    file = null;
                    la = null;
                    System.out.println("Archivo Eliminado");
                    break;
                
            }
            System.out.println("Presione Enter Para Continuar....");
            System.in.read();
            System.out.println(menu);     
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        crearDirectorio();
        Menu();
    }
    
}
