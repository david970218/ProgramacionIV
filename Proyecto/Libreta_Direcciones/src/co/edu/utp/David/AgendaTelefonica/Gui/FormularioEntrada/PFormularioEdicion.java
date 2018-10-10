/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Gui.FormularioEntrada;

import co.edu.utp.David.AgendaTelefonica.Archivos.AdministradorArchivos;
import co.edu.utp.David.AgendaTelefonica.Logic.Contacto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author david_perez
 */
public  class PFormularioEdicion extends PFormularioEntrada{
        private Contacto[] listaContactos;
        private JTextField[] listaTextFields;
        private JComboBox jcb;
        private int referencia = 0;
        public PFormularioEdicion(){
            initGUI2();
            renameButton();
        }
        
        private void initGUI2(){
            actualizarListaContactos();
            agregarComponentesAdicionales();
            listaTextFields = new JTextField[12];
            llenarListaComponentes();
            setActions();
        }
        
        private void agregarComponentesAdicionales(){
            jcb = new JComboBox();
            llenarjcb();
            add(jcb);
        }
        
        public void llenarjcb(){
           int a = 1;
           actualizarListaContactos();
           remove(jcb);
           jcb = new JComboBox();
            while(listaContactos[a] != null){
                jcb.addItem(listaContactos[a].toString2());
                a++;
            }
            add(jcb);
            super.actualizarPantalla();
            setActions();
        }
        private void actualizarListaContactos(){
            listaContactos = AdministradorArchivos.leerArchivoSerializable
            (Contacto.getArchivo());
        }
        
        private void llenarListaComponentes(){
            listaTextFields[1] = super.getNombretf();
            listaTextFields[2] = super.getPrimerapellidotf();
            listaTextFields[3] = super.getSegundoapellidotf();
            listaTextFields[4] = super.getAliastf();
            listaTextFields[5] = super.getDirecciontf();
            listaTextFields[6] = super.getCorreoelectronicotf();
            actualizarCamposTelefonicos();
        }
        
        private void actualizarCamposTelefonicos(){
            int a = 7;
            while(a <= 11){
                listaTextFields[a] = super.getCampoTelefonico(a-6);
                a++;
            }
        }
        
        private void setEditable(boolean edit){
            int a = 1;
            while(a <= 12 && listaTextFields[a] != null){
                listaTextFields[a].setEditable(edit);
                a++;
            }
        }
        
        private void renameButton(){
            super.getPanelBotones().getAgregar().setText("Editar");
            super.getPanelBotones().getLimpiar().setText("Eliminar");
        }
        
        private void setActions(){
            jcb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jcbActionPerformed(e);
                   
                }
            });
            
            super.getPbotones().getAgregar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        editarActionPerformed(e);
                    } catch (IOException ex) {
                        Logger.getLogger(PFormularioEdicion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        
        private void editarActionPerformed(ActionEvent e) throws IOException{
            if(referencia != 0){
                listaContactos[referencia].setNombre(listaTextFields[1].getText());
                listaContactos[referencia].setPrimera(listaTextFields[2].getText());
                listaContactos[referencia].setSegundoa(listaTextFields[3].getText());
                listaContactos[referencia].setAlias(listaTextFields[4].getText());
                listaContactos[referencia].setDireccion(listaTextFields[5].getText());
                listaContactos[referencia].setEmail(listaTextFields[6].getText());
                String[] numeros = new String[6],
                         tiposnumeros = new String[6];
                Arrays.fill(numeros, "");
                Arrays.fill(tiposnumeros, "");
                int a = 7;
                while(a < 12 && listaTextFields[a] != null){
                    numeros[a-6] = listaTextFields[a].getText();
                    tiposnumeros[a-6] = (String)super.getJcb(a-6).getSelectedItem();
                    a++;
                }
                listaContactos[referencia].setNumeroT(numeros);
                listaContactos[referencia].setTiposnumero(tiposnumeros);
                AdministradorArchivos.LimpiarArchivo(Contacto.getArchivo());
                Contacto.guardarListaContacto(listaContactos);
                actualizarListaContactos();
                llenarjcb();
                referencia = 0;
                super.limpiarActionPerformed(e);
            }
            
        }
        @Override
        protected void minusActionPerformed(ActionEvent evt){
            super.minusActionPerformed(evt);
            this.actualizarCamposTelefonicos();
        } 
        
        @Override
        public void limpiarActionPerformed(ActionEvent evt){
           if(referencia != 0){
            super.limpiarActionPerformed(evt);
            listaContactos[referencia].setToDelete();
            Contacto.guardarEnArchivo(listaContactos);
            referencia = 0;
            this.actualizarListaContactos();
            this.llenarjcb();
            }
           
        }
        
        @Override
        protected void plusActionPerformed(ActionEvent evt){
            remove(jcb);
            super.plusActionPerformed(evt);
            this.actualizarCamposTelefonicos();
            add(jcb);
        }
        private void jcbActionPerformed(ActionEvent e){
            String seleccion = (String) jcb.getSelectedItem();
            eliminarJtfs();
            int a = 1;
            while(listaContactos[a] != null){
                if(listaContactos[a].toString2().equals(seleccion)){
                    llenarFormulario(listaContactos[a]);
                    referencia = a;
                    break;
                }
                a++;
            }
        }
        private void eliminarJtfs(){
            listaTextFields[7].setEditable(true);
            int a = 8;
            super.limpiarActionPerformed(null);
            while(a < 12 && listaTextFields[a] != null){
                remove(listaTextFields[a]);
                listaTextFields[a] = null;
                a++;
            }
            super.actualizarPantalla();
            super.setContadorOne();
        }
        
        private void llenarFormulario(Contacto a){
            String[] numeroTel = a.getNumeroT(),tiposnumeros = a.getTiposnumero();
            eliminarJtfs();
            listaTextFields[1].setText(a.getNombre()); 
            listaTextFields[2].setText(a.getPrimera());
            listaTextFields[3].setText(a.getSegundoa());
            listaTextFields[4].setText(a.getAlias());
            listaTextFields[5].setText(a.getDireccion());
            listaTextFields[6].setText(a.getEmail());
            listaTextFields[7].setText(numeroTel[1]);
            super.setSelectedItem(tiposnumeros[1]);
            int b = 8;
            while(b <= 11 && !numeroTel[b-6].equals("")){
                super.borrarBotones();
                remove(jcb);
                super.setContadortel();
                super.crearCampoTel();
                this.actualizarCamposTelefonicos();
                listaTextFields[b].setText(numeroTel[b-6]);
                super.setSelectedItem(tiposnumeros[b-6]);
                super.colocarBotones();
                add(jcb);
                b++;
            }
            

        }
}
        