/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author david_perez
 */
public class Popmenu extends JMenuBar {
    public  JMenu menu = new JMenu("Menu");
    public JMenuItem agregarContacto, editar_o_eliminarContacto,
        mostrar_todosloscontactos,Buscar_contactos ,Importar,Exportar,cerrar;
    
    public Popmenu(){
        super();
        this.agregarContacto = new JMenuItem("Crear Contacto");
        this.editar_o_eliminarContacto = new JMenuItem("Editar/Eliminar");
        this.mostrar_todosloscontactos = new JMenuItem("Mostrar Contactos Actuales");
        this.Buscar_contactos = new JMenuItem("Buscar Contactos");
        this.Importar = new JMenuItem("Importar");
        this.Exportar = new JMenuItem("Exportar");
        this.cerrar = new JMenuItem("Cerrar");
        menu.add(this.agregarContacto);
        menu.add(this.editar_o_eliminarContacto);
        menu.add(this.mostrar_todosloscontactos);
        menu.add(this.Buscar_contactos);
        menu.add(Importar);
        menu.add(Exportar);
        menu.add(cerrar);
        this.add(menu);
    }
        
        
        
        
    }

