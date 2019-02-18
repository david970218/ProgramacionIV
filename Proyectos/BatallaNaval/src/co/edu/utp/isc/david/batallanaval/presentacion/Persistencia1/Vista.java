/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1;

import co.edu.utp.isc.david.batallanaval.presentacion.PJuego;
import co.edu.utp.isc.david.batallanaval.presentacion.SolCOM;

/**
 *
 * @author david
 */
public interface Vista {
    public PJuego getPJuego();
    public void setControlador(ControladorMenu c);
    public SolCOM getSolCom();
}
