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
public class BusquedaPorNumeroTelefonico extends BusquedaContactos {

    @Override
    public Contacto[] listaQueCumpleElRequisito(Contacto[] list, String telefono) {
        Contacto[] listaContactos = new Contacto[10000];
        int b =1;
        int c = 1;
        while(list[b] != null){
            String[] numtels = list[b].getNumeroT();
            for (int i = 1; i <= 5; i++) {
                if(numtels[i].equals(telefono)){
                    listaContactos[c] = list[b];
                    c++;
                    break;
                }
            }
            b++;
        }
        return listaContactos;
    }
}
