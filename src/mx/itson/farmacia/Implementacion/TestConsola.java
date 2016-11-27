/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Implementacion;

import com.itson.farmacia.HibernateUtil;
import mx.itson.farmacia.Entidades.Laboratorio;
import org.hibernate.Session;

/**
 *
 * @author blabla
 */
public class TestConsola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        Laboratorio lab = new Laboratorio();
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
    }
    
}
