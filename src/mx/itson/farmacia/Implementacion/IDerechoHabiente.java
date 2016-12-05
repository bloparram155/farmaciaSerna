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
import mx.itson.farmacia.Interfaz.DerechoHabienteInterfaz;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author blabla
 */
public class IDerechoHabiente implements DerechoHabienteInterfaz{
    
    @Override
    public void agregarDerechoHabiente(DerechoHabiente dh){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(dh);
            tx.commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Ah ocurrido un problema al agregar"
                    + "un derechoHabiente.");
        }finally{
            session.close();
        }
    }
    
    @Override
    public List<DerechoHabiente> mostrarDerechoHabientes(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<DerechoHabiente> lista= null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM DerechoHabiente";
            Query query = session.createQuery(hql);
            lista = query.list();
            tx.commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ah ocurrido un problema al"
                    + "mostrar los datos de derechoHabiente.");
        }finally{
            session.close();
        }
        return lista;
    }

    
    
    @Override
    public List<DerechoHabiente> buscarDerechoHabiente(String nombre){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<DerechoHabiente> lista = new ArrayList();
        try{
           tx = session.beginTransaction();
           String hql = "FROM DerechoHabiente WHERE nombre LIKE :nombre";
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
}
