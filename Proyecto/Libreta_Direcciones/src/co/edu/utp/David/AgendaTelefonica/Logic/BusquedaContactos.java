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
public abstract class BusquedaContactos {
    /**
     * @param list // lista de contactos en las que se va a aplicar la busqueda
     * @param a es el parametro a buscar
     * @return retorna una lista con los contactos que cumplen el criterio
     */
    public abstract Contacto[] listaQueCumpleElRequisito(Contacto[] list ,String a);
}
