/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Ejercicio_coleccion;

/**
 *
 * @author david_perez
 */
public class PruebaPila {
    void rellenar(ColeccionInterfaz c)
    {
        for (int i = 1; i <= 10; i++) {
            c.añadir(i);
        }
    }
    
    void mostraryVacear(ColeccionInterfaz c)
    {
        for (int i = 0; i < 10; i++) {
            System.out.print(c.extraer() +" ");
        }
    }
}
