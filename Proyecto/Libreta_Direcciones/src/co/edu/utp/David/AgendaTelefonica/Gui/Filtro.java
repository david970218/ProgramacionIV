/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Archivos;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author david_perez
 */
public class Filtro extends FileFilter{
    private String ext;
    private String description;

    public Filtro(String ext, String description) {
        this.ext = ext;
        this.description = description;
    }

    

    
    @Override
    public boolean accept(File f) {
        return (f.getName().toLowerCase().endsWith(ext) || f.isDirectory() ) ;  
                
        }

    @Override
    public String getDescription() {
        return this.description;
    }
    
}
