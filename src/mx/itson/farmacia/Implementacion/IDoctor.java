/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Implementacion;

import java.util.ArrayList;
import mx.itson.farmacia.Entidades.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import mx.itson.farmacia.Entidades.DerechoHabiente;
import mx.itson.farmacia.Entidades.Doctor;
import mx.itson.farmacia.Entidades.Laboratorio;
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
            JOptionPane.showMessageDialog(null, "Se agrego con exito al doctor.");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Ah ocurrido un problema al agregar"
                    + "doctor.");
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
            Doctor dr1 = session.load(Doctor.class, dr.getId());
            dr1.getLista().add(dh);
            tx.commit();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ah ocurrido un error al agregar"
                    + "derechoHabiente al doctor asignado.");
        }finally{
            session.close();
        }
        
    }
    
    @Override
    public List<Doctor> buscarDoctor(String nombre){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Doctor> lista = new ArrayList();
        try{
           tx = session.beginTransaction();
           String hql = "FROM Doctor WHERE nombre LIKE :nombre";
           Query query = session.createQuery(hql);
           query.setParameter("nombre", nombre);
           lista = query.list();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Usuario inexistente");
        }finally{
            session.close();
        }
        return lista;
    }
    
    @Override
    public Doctor obtenerDoctor(int id){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Doctor dr=null;
        try{
            tx = session.beginTransaction();
            dr = session.get(Doctor.class, id);
          
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener Laboratorio.");
        }finally{
            session.persist(dr);
        }
        return dr;
    }
    
}
