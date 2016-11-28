/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Implementacion;

import com.itson.farmacia.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import mx.itson.farmacia.Entidades.DerechoHabiente;
import mx.itson.farmacia.Entidades.Doctor;
import mx.itson.farmacia.Entidades.Persona;
import mx.itson.farmacia.Entidades.Usuario;
import mx.itson.farmacia.Interfaz.DoctorInterfaz;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author blabla
 */
public class IDoctor implements DoctorInterfaz {
    
    
    @Override
    public void agregarDoctor(Doctor p){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            
            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Ah ocurrido un problema al agregar"
                    + "un doctor.");
        }finally{
            session.close();
        }
    }

    @Override
    public List<Doctor> mostrarDoctores(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Doctor> lista= null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Doctor";
            Query query = session.createQuery(hql);
            lista = query.list();
            tx.commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ah ocurrido un problema al"
                    + "mostrar los datos de usuarios.");
        }finally{
            session.close();
        }
        return lista;
    }
    
    @Override
    public void agregarDerechoHabienteLista(DerechoHabiente dh,Doctor dr){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx= session.beginTransaction();
            dr.getLista().add(dh);
            tx.commit();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ah ocurrido un error al agregar"
                    + "derechoHabiente al doctor asignado.");
        }finally{
            session.close();
        }
        
    }
}
