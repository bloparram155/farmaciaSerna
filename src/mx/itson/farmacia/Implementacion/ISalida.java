/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Implementacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mx.itson.farmacia.Entidades.HibernateUtil;
import mx.itson.farmacia.Entidades.Salida;
import mx.itson.farmacia.Interfaz.SalidaInterfaz;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Pablo Parra
 */
public class ISalida implements SalidaInterfaz{
    
    @Override
    public void agregarSalida(Salida s){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(s);
            tx.commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Ah ocurrido un problema al agregar"
                    + "salida.");
        }finally{
            session.close();
        }
    }
    
    @Override
    public List<Salida> mostrarSalidas(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx= null;
        List<Salida> lista = new ArrayList();
        try{
            tx = session.beginTransaction();
            String hql = "FROM Salida";
            Query query = session.createQuery(hql);
            lista = query.list();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al mostrar salidas.");
        }finally{
            session.close();
        }
        
        return lista;
    }
    
    @Override
    public Salida obtenerLaboratorio(int id){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Salida lab=null;
        try{
            tx = session.beginTransaction();
            lab = session.load(Salida.class, id);
          
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener Salida");
        }finally{
            session.persist(lab);
        }
        return lab;
    }
}
