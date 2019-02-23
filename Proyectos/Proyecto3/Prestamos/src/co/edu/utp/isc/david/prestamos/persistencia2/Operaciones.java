/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.prestamos.persistencia2;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author david
 */
class Operaciones {
    private SessionFactory sf;
    private Session session ;
    private Transaction tx;
    private static Operaciones instance;
    private Operaciones(){
        
    }
    
    public static Operaciones getInstance(){
        if(instance == null){
            instance = new Operaciones();
        }
        return instance;
    }
    
    private void beginT(){
        sf = NewHibernateUtil.getSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
    }
    
    public boolean save(Object o){
        try {
            beginT();
        session.saveOrUpdate(o);
        tx.commit();
        
        } catch (Exception e) {
            session.close();
            return false;
        }
        
        session.close();
        return true;
    }
    
    public Object uniqueResult(String query){
        beginT();
        Query consulta = session.createQuery(query);
        Object result = consulta.uniqueResult();
        session.close();
        return result;
    }
    
    public ArrayList multipleResult(String query){
        beginT();
        ArrayList result;
        Query consulta = session.createQuery(query);
        result = (ArrayList) consulta.list();
        session.close();
        return result;
    }
    
}
