/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Gui.FormularioEntrada;
import co.edu.utp.David.AgendaTelefonica.Gui.ComboBoxT;
import co.edu.utp.David.AgendaTelefonica.Gui.PBotonesE;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author David
 */
public class PFormularioEntrada extends JPanel {
        private JButton plus , minus;
        int contadortel;
        private ComboBoxT[] cbt;
        private PBotonesE pbotones;        
        final private JLabel[] numerotelefonico,vacios;
        final private JTextField[] numerotelefonicotf;
        private JLabel nombre,primerapellido,segundoapellido,correoelectronico,direccion,alias;
        private JTextField nombretf,primerapellidotf,segundoapellidotf,correoelectronicotf,direcciontf,aliastf;

    public PBotonesE getPbotones() {
        return pbotones;
    }
        public PFormularioEntrada(){
                super();
                contadortel = 1; 
                vacios = new JLabel[6];
                cbt = new ComboBoxT[6];
               
                numerotelefonico = new JLabel[6];
                numerotelefonicotf = new JTextField[6];
                initGui();   
        }

        private void initGui(){
                setLayout(new GridLayout(0,3,1,3)) ;
                this.agregarCampos();
                pbotones = new PBotonesE();
                add(pbotones);
                this.setBackground(Color.BLACK);
                setAction();
        } 
        
        private void cbtActionPerformed(ActionEvent evt , int aux){
                  if(cbt[aux].getSelectedItem().equals("Otro")){
                        String otro = JOptionPane.showInputDialog("Nombre del Campo Personalizado");
                        if(otro != null || !otro.equals(""))
                            cbt[aux].addItem(otro);
                       
                        
                        cbt[aux].setSelectedIndex(0);
                  }
        }
        
        private void cbtAction(){
                cbt[contadortel].addActionListener(new ActionListener(){
                @Override
                        public void actionPerformed(ActionEvent evt){
                                cbtActionPerformed(evt, contadortel);
                         }
        });
        }

        public void setAction(){
            
                pbotones.getLimpiar().addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent evt){
                                limpiarActionPerformed(evt);
                         }
                });
                plus.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent evt){
                                 plusActionPerformed(evt);
                        }
                });
                minus.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent evt){
                                minusActionPerformed(evt);
                        }
                });
        }

        private void minusActionPerformed(ActionEvent evt){
                  if(contadortel > 1){
                       if(!numerotelefonicotf[contadortel].getText().equals("")){
                            int action;
                            action = JOptionPane.showConfirmDialog(this,"Seguro que quiere eliminar el numero en el campo Numero Telefonico " + contadortel,"Warning",
                            JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                            if(action == JOptionPane.YES_OPTION){
                                minusActionPerformedAux();
                            }
                        }
                  else
                       minusActionPerformedAux();        
                }
        }

         private void minusActionPerformedAux()
         {
             remove(numerotelefonico[contadortel]);
            numerotelefonico[contadortel] = null;
            remove(cbt[contadortel]);
            cbt[contadortel] = null;
            remove(numerotelefonicotf[contadortel]);
            numerotelefonicotf[contadortel] = null;
            contadortel -=1;
            numerotelefonicotf[contadortel].setEditable(true);
            actualizarPantalla();
         }
        /**
         * la funcion limpiarActionPerformed(ActionEvent evt) es la que limpia los campos de texto para corregir todos los campos 
         * desde cero
        */
        public void limpiarActionPerformed(ActionEvent evt) {
                nombretf.setText("");
                aliastf.setText("");
                primerapellidotf.setText("");
                segundoapellidotf.setText("");
                direcciontf.setText("");
                correoelectronicotf.setText("");
                numerotelefonicotf[1].setText("");          
                 numerotelefonicotf[1].setEditable(true);
                 cbt[1].setSelectedIndex(0);
                //*********************************************************************************************************************************
                //En estas lineas se eliminan todos los campos Numero telefonicos Creados con el boton plus 
                //para dejar solo el primero creado por defecto  
                int a = 2;
                while(a <= 5){
                        if(numerotelefonico[a] == null )
                                break;
                        else{
                                remove(cbt[a]);
                                cbt[a]=null;
                                remove(numerotelefonico[a]);
                                numerotelefonico[a] = null;
                                remove(numerotelefonicotf[a]);
                                numerotelefonicotf[a] = null;
                          }
                          a+=1;
                }
                //**********************************************************************************************************************************
                //se reinicia el contador de numeros telefonicos a 1 para volver a crear si es necesario mas campos numeros telefonicos
                contadortel = 1;
                actualizarPantalla();
                // borrarBotones();
                // colocarBotones();
                //**********************************************************************************************************************************
        }


        /**
         * la funcion plusActionPerformed es la que agrega mas campos de numero Telefonico
         * al presionar el boton '+'
         * */


        private void plusActionPerformed(ActionEvent evt){
            if(numerotelefonicotf[contadortel].getText().equals("")){
                JOptionPane.showMessageDialog(this,"Para agregar mas numeros telefonicos primero debe agregar un numero telefonico en el campo Numero Telefonico " 
                + contadortel,"Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                contadortel+=1;
                if(contadortel < 6) {
                        numerotelefonicotf[contadortel-1].setEditable(false);
                        borrarBotones();
                        crearCampoTel();
                        colocarBotones();
                        actualizarPantalla();
                }
                }
                if(contadortel == 6)
                        contadortel = 5;
        }
        
        private void cambiarColor(Component c){
            c.setForeground(Color.WHITE);
        }
        /**
         * Esta funcion agregarCampos es la que como su nombre dice agrega los campos de texto y label al panel de formulario 
         * entrada
         */

         private void agregarCampos(){
                {
                nombre = new JLabel();
                nombre.setText("Nombre *");
                cambiarColor(nombre);
                add(nombre);
                add(new JLabel());
                nombretf = new JTextField();
                add(nombretf);
                }
                 {
                primerapellido = new JLabel();
                primerapellido.setText("Primer apellido");
                cambiarColor(primerapellido);
                add(primerapellido);
                add(new JLabel());
                primerapellidotf = new JTextField();
                add(primerapellidotf);
                }
                 {
                segundoapellido = new JLabel();
                segundoapellido.setText("Segundo Apellido");
                 cambiarColor(segundoapellido);
                add(segundoapellido);
                add(new JLabel());
                segundoapellidotf = new JTextField();
                add(segundoapellidotf);
                }
                 {
                alias = new JLabel("Apodo");
                cambiarColor(alias);
                add(alias);
                add(new JLabel());
                aliastf = new JTextField();
                add(aliastf);
                }
                {
                direccion = new JLabel("Domicilio");
                 cambiarColor(direccion);
                add(direccion);
                add(new JLabel());
                direcciontf = new JTextField();
                add(direcciontf);
                }
                {
                correoelectronico = new JLabel();
                correoelectronico.setText("E-mail");
                 cambiarColor(correoelectronico);
                add(correoelectronico);
                add(new JLabel());
                correoelectronicotf = new JTextField();
                add(correoelectronicotf);
                }
                {
                numerotelefonico[1] = new JLabel("Numero Telefonico 1 *");
                cambiarColor(numerotelefonico[1]);       
                add(numerotelefonico[1]);
                cbt[1] = new ComboBoxT();
                add(cbt[1]);
                numerotelefonicotf[1] = new JTextField();
                add(numerotelefonicotf[1]);
                crearPlus();
                add(plus);
                crearMinus();
                add(minus);
                cbtAction();
                }    
        }
         /**
          * las funciones CrearcampoTel  Y crearPlus estan a parte de todas las funciones por si se necesita crear mas 
          * campos del mismo tipo
          */ 
         private void crearCampoTel(){
        {
                cbt[contadortel] = new ComboBoxT();
               numerotelefonico[contadortel] = new JLabel();
               numerotelefonico[contadortel].setText("Numero Telefonico " + contadortel);
                cambiarColor(numerotelefonico[contadortel]);
               add(numerotelefonico[contadortel]);
               add(cbt[contadortel]);
               numerotelefonicotf[contadortel] = new JTextField();
               add(numerotelefonicotf[contadortel]);
               cbtAction();
           }
         }
        private void borrarBotones(){
             remove(plus);
             remove(minus);
             remove(pbotones);
         }

        private void colocarBotones(){
                add(plus);
                add(minus);
                add(pbotones);
        }
         private void crearPlus(){
                plus= new JButton();
                plus.setText("+");
                plus.setBackground(Color.gray);
        }
          private void crearMinus(){
                minus= new JButton();
                minus.setText("-");
                minus.setBackground(Color.gray);
        }

         public void actualizarPantalla(){ 
                SwingUtilities.updateComponentTreeUI(this); 
        }
        
         public PBotonesE getPanelBotones(){
             return pbotones;
         }
         
         public String[][] getComponentes(){
            String[][] componentes;
            componentes = new String[4][];
            componentes[1] = new String[7];
            Arrays.fill(componentes[1],"");
            for (int i = 2; i <=3; i++) {
                    componentes[i] = new String[6];
                    Arrays.fill(componentes[i],"");
            }
            {
                componentes[1][1] = nombretf.getText();
                componentes[1][2] = primerapellidotf.getText();
                componentes[1][3] = segundoapellidotf.getText();
                componentes[1][4] = aliastf.getText();
                componentes[1][5] = direcciontf.getText();
                componentes[1][6] = correoelectronicotf.getText();
            }
            {
                for (int i = 1; i <= 5; i++) {
                    if(numerotelefonicotf[i] == null || numerotelefonicotf[i].getText().equals("") )
                        break;
                    
                    else
                    {
                        componentes[2][i] = (String) cbt[i].getSelectedItem();
                        componentes[3][i] = numerotelefonicotf[i].getText();
                    }
                }
            }
            return componentes;
         }
    
    public boolean isContact(){
        return (!(numerotelefonicotf[1].getText().equals("")) && 
                !(nombretf.getText().equals("")));
    }
}