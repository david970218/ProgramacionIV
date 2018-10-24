/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Gui.TablasDeSalida;

import co.edu.utp.David.AgendaTelefonica.Logic.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author david_perez
 */
public final class TablaBusqueda extends MuestraContactos {
   private final JComboBox jcb;
   private JTextField jtf;
   private String busqueda;
   
   public TablaBusqueda(){
       super(null);
       jcb = new mijcombobox();
       initGui();
       setActions();
       
   }
   
   private void setActions(){
       jcb.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               jcbActionPerformed();
           } 
       });
       
        botonAccion.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               botonAccionActionPerformed();
           }
   });
   }
   
   private void botonAccionActionPerformed(){
       busqueda = jtf.getText();
       if(!busqueda.equals("")){
           llenarIam();
           actualizarTabla();
       }
   }
   
   private void jcbActionPerformed() {
               if(jcb.getSelectedItem().equals("Nombre"))
                    Logica.setBusqueda(new BusquedaPorNombre());
               if(jcb.getSelectedItem().equals("Primer Apellido"))
                   Logica.setBusqueda(new BusquedaPorPrimerApellido());
               if(jcb.getSelectedItem().equals("Segundo Apellido"))
                   Logica.setBusqueda(new BusquedaPorSegundoApellido());
               if(jcb.getSelectedItem().equals("Alias"))
                   Logica.setBusqueda(new BusquedaPorAlias());
               if(jcb.getSelectedItem().equals("Direccion"))
                   Logica.setBusqueda(new BusquedaPorDomicilio());
               if(jcb.getSelectedItem().equals("E-mail"))
                   Logica.setBusqueda(new BusquedaPorEmail());
               if(jcb.getSelectedItem().equals("Numero Telefono"))
                   Logica.setBusqueda(new BusquedaPorNumeroTelefonico()); 
           }
   
   
   
    @Override
    protected void initGui(){
      setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
       scroll = new JScrollPane();
       pbotones = new JPanel();
        crearPanelBotones();
        add(scroll);
        pbotones.setSize(10, 300);
        add(pbotones);
       tabla = new JTable();
       actualizarTabla();
    }
    
   @Override
    protected void llenarIam(){
        iam = new Contacto[10000];
        if(Logica.getSearch() != null){
            super.iam = Logica.buscar(busqueda);
        }
    }

    private void crearPanelBotones() {
       botonAccion = new JButton("Buscar");
       salir = new JButton("Cerrar");
       pbotones.setLayout(null);
       pbotones.add(jcb);
       jcb.setBounds(WIDTH, 15, 150, 16);
       jtf = new JTextField();
       jtf.setBounds(165, 16, 150, 16);
       pbotones.add(jtf);
       pbotones.add(botonAccion);
       botonAccion.setBounds(165+150+15, 16, 100, 16);
       pbotones.add(salir);
       salir.setBounds(165+150+15 +100+15, 16, 100, 16);
    }
}
