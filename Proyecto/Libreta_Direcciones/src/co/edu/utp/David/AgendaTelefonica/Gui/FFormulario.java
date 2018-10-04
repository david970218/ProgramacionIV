/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Gui;
import co.edu.utp.David.AgendaTelefonica.Gui.FormularioEntrada.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

/**
 *
 * @author David
 */
public class FFormulario extends JFrame {
        final private PFormularioEntrada pformulario;
        private JScrollPane scroll;
        final private JTabbedPane panelPestañas;
        
        public FFormulario(){
                this.setBackground(Color.YELLOW);
                initGui();
                pformulario = new PFormularioEntrada();     
                panelPestañas = new JTabbedPane();
                panelPestañas.addTab("Agregar Contacto", pformulario);
                add(panelPestañas);
        }
        
        private void initGui(){
                this.setTitle("Agenda Telefonica");
                this.setLayout(new BorderLayout());
                this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                setSize(400,300);   
        }

    public PFormularioEntrada getPformulario() {
        return pformulario;
    }
        

}
