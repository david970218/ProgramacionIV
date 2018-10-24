/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Logic;

/**
 *
 * @author david_perez
 */
public class BusquedaPorNombre extends BusquedaContactos  {
    @Override
    public Contacto[] listaQueCumpleElRequisito(Contacto[] list, String nombre) {
        Contacto[] listaContactos = new Contacto[10000];
        int b =1;
        int c = 1;
        while(list[b] != null){
            if(list[b].getNombre().equals(nombre)){
                listaContactos[c] = list[b];
                c++;
            }
            b++;
        }
        return listaContactos;
    }
}
