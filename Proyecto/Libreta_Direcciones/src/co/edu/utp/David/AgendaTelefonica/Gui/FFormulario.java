/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Gui;
import co.edu.utp.David.AgendaTelefonica.Archivos.AdministradorArchivos;
import co.edu.utp.David.AgendaTelefonica.Gui.FormularioEntrada.*;
import co.edu.utp.David.AgendaTelefonica.Gui.TablasDeSalida.MuestraContactos;
import co.edu.utp.David.AgendaTelefonica.Gui.TablasDeSalida.TablaBusqueda;
import co.edu.utp.David.AgendaTelefonica.Logic.Contacto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import co.edu.utp.David.AgendaTelefonica.Gui.Filtro;

/**
 *
 * @author David
 */
public class FFormulario extends JFrame {
        final private Popmenu menu = new Popmenu();
        final private PFormularioEntrada pformulario;
        private JScrollPane scroll;
        final private JTabbedPane panelPestañas;
        final private MuestraContactos mc;
        final private PFormularioEdicion pfe;
        private TablaBusqueda tablabusqueda;
        public FFormulario(){
                this.setBackground(Color.YELLOW);
                pformulario = new PFormularioEntrada();     
                panelPestañas = new JTabbedPane();
                mc = new MuestraContactos();
                pfe = new PFormularioEdicion();
                tablabusqueda = new TablaBusqueda();
                initGui();
                this.setJMenuBar(menu);
                add(panelPestañas);
                
        }
        
        private void initGui(){
                this.setTitle("Agenda Telefonica");
                this.setLayout(new BorderLayout());
                this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                setSize(700,1000);
                setActions();
        }
        private void setActions(){
           mc.getSalir().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               cerraritemActionPerformed(e, mc);
               
           }
       });
       
        pformulario.getPbotones().getSalir().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               cerraritemActionPerformed(e,pformulario);
               
           }
       });
        
         pfe.getPbotones().getSalir().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               cerraritemActionPerformed(e, pfe);
               
           }
       });
           mc.getBotonAccion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mc.actualizarTabla();
               
           }
       });
           
       menu.agregarContacto.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   agregarContactoActionPerformed(e);
               }
           });
       menu.editar_o_eliminarContacto.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   editarContactoActionPerformed(e);
               }
           });
       menu.mostrar_todosloscontactos.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   mc.actualizarTabla();
                   panelPestañas.removeAll();
                   panelPestañas.addTab("Lista Contactos",mc);    
               }
           });
        menu.Buscar_contactos.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   panelPestañas.removeAll();
                   panelPestañas.addTab("Buscar contactos",tablabusqueda);
                   
               }
           });
        menu.cerrar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                 System.exit(0);
               }
           });
        
        menu.Exportar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   try {
                       exportarContactos();
                   } catch (IOException ex) {
                       Logger.getLogger(FFormulario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           });
        
        menu.Importar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   importarContactos();

               }
           });
       
        
        tablabusqueda.getSalir().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   cerraritemActionPerformed(e,tablabusqueda);
               }
           });
        }
        
        private void agregarContactoActionPerformed(ActionEvent e){
            panelPestañas.removeAll();
            panelPestañas.addTab("Agregar Contacto", pformulario);
        }
        
        
        private void editarContactoActionPerformed(ActionEvent e){
            panelPestañas.removeAll();
            pfe.llenarjcb();
            panelPestañas.addTab("Editar/Eliminar Contactos",pfe);
        }
        
        private void cerraritemActionPerformed(ActionEvent e , Component a){
            panelPestañas.remove(a);
                   
    }
    public PFormularioEntrada getPformulario() {
        return pformulario;
    }
    
    private void importarContactos(){
        panelPestañas.removeAll();
        int select;
        JFileChooser ventana = new JFileChooser();
        File file = null;
        Filtro[] filtro = new Filtro[4];
        filtro[1] = new Filtro(".in","Archivos de entrada (*.in)");
        filtro[2] = new Filtro(".out","Archivos de salida (*.out)");
        filtro[3] = new Filtro(".txt","Archivos de texto (*.txt)");
        ventana.setAcceptAllFileFilterUsed(false);
        for (int i = 1; i <= 3; i++) {
            ventana.addChoosableFileFilter(filtro[i]);
        }
        select = ventana.showSaveDialog(ventana);
        if(select == JFileChooser.APPROVE_OPTION){
            file = ventana.getSelectedFile();
            AdministradorArchivos.importarContactos(Contacto.getArchivo(), file);
        }
        
    }
       
     private void exportarContactos() throws IOException{
        panelPestañas.removeAll();
        Filtro[] filtro = new Filtro[4];
        filtro[1] = new Filtro(".in","Archivos de entrada (*.in)");
        filtro[2] = new Filtro(".out","Archivos de salida (*.out)");
        filtro[3] = new Filtro(".txt","Archivos de texto (*.txt)");
        JFileChooser guardarComo = new JFileChooser();
        guardarComo.setAcceptAllFileFilterUsed(false);
         for (int i = 1; i <= 3; i++) {
             guardarComo.addChoosableFileFilter(filtro[i]);
         }
        guardarComo.setApproveButtonText("Guardar");
        guardarComo.showSaveDialog(null);
        if(guardarComo.getSelectedFile() != null){
            File archivo = new File(guardarComo.getSelectedFile() + ".txt");
            AdministradorArchivos.exportarContactos(Contacto.getArchivo(), archivo);
        }
    }

}
