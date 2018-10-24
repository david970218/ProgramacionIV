/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Gui.TablasDeSalida;

import co.edu.utp.David.AgendaTelefonica.Archivos.AdministradorArchivos;
import co.edu.utp.David.AgendaTelefonica.Logic.Contacto;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author david_perez
 */
public class MuestraContactos extends JPanel {
    protected Contacto[] iam;
    protected JTable tabla;
    protected  JButton botonAccion,salir;
    protected JPanel pbotones;
    protected int numeroDatos;
    protected JScrollPane scroll;
    protected final String[] titulos = {"Nombre","Primer Apellido","SegundoApellido","Alias",
                            "Direccion","E-mail","Tipo","Numero 1","Tipo","Numero 2",
                            "Tipo","Numero 3","Tipo","Numero 4","Tipo" , "Numero 5"};
    public MuestraContactos(){
        initGui();
        
    }
    public MuestraContactos(Object c){
        
    }
    
    protected final String[][] llenarTabla(){
        String[][] datos = new String[10000][16];
        int a =1;
        while(iam[a] != null){
           String[] numtel = iam[a].getNumeroT(),
           ti = iam[a].getTiposnumero() ;
           datos[a-1][0] = iam[a].getNombre();
           datos[a-1][1] = iam[a].getPrimera();
           datos[a-1][2] = iam[a].getSegundoa();
           datos[a-1][3] = iam[a].getAlias();
           datos[a-1][4] = iam[a].getDireccion();
           datos[a-1][5] = iam[a].getEmail();
           datos[a-1][6] = ti[1];
           datos[a-1][7] = numtel[1];
           datos[a-1][8] = ti[2];
           datos[a-1][9] = numtel[2];
           datos[a-1][10] = ti[3];
           datos[a-1][11] = numtel[3];
           datos[a-1][12] = ti[4];
           datos[a-1][13] = numtel[4];                      
           datos[a-1][14] = ti[5];
           datos[a-1][15] = numtel[5];
           a++;                
        }
        numeroDatos = a-1;
        return datos;
    }
    
   protected void initGui(){   
       setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
       scroll = new JScrollPane();
       crearPanelBotones();
       add(scroll);
       add(pbotones);  
       //add(new JLabel(""));
       //add(new JLabel(""));
       //add(new JLabel(""));
       tabla = new JTable();
       actualizarTabla();
       
      
    }
   
   protected void llenarIam(){
       iam = AdministradorArchivos.leerArchivoSerializable(Contacto.getArchivo());
   }
   
   public final void actualizarTabla(){
        llenarIam();  
        String[][] datos = llenarTabla();
        TableModel modeloTabla = new DefaultTableModel(datos,titulos);
        tabla.setModel(modeloTabla);
        tabla.setPreferredSize(new Dimension(7,numeroDatos * 16));
        scroll.setViewportView(tabla);
        TableRowSorter ordenador = new TableRowSorter(modeloTabla);
        tabla.setRowSorter(ordenador);
   }
  
    private void crearPanelBotones(){
       salir = new JButton("Cerrar");
       pbotones = new JPanel();
       pbotones.add(salir);
       botonAccion = new JButton("Actualizar");
       pbotones.add(botonAccion);
   }
   public JButton getBotonAccion (){
       return botonAccion;
   }
   public JButton getSalir(){
       return salir;
   }
}


