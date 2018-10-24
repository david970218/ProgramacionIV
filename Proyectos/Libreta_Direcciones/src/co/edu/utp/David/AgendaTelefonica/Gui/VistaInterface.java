/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Gui;

import co.edu.utp.David.AgendaTelefonica.Gui.FormularioEntrada.PFormularioEntrada;
import co.edu.utp.David.AgendaTelefonica.Logic.Controlador;

/**
 *
 * @author david_perez
 */
public interface VistaInterface {
    public PFormularioEntrada getPformulario();
    public void setControlador(Controlador c);
}
