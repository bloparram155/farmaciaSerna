/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Implementacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mx.itson.farmacia.Entidades.Doctor;
import mx.itson.farmacia.Entidades.HibernateUtil;
import mx.itson.farmacia.Entidades.Producto;
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
            JOptionPane.showMessageDialog(null, "Se agrego con exito la salida.");
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
    public Salida obtenerSalida(int id){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Salida> lista = new ArrayList();
        Salida lab=null;
        try{
            tx = session.beginTransaction();
            String hql ="FROM Salida WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            lista = query.list();
            for(Salida s : lista){
                lab = new Salida(s.getDoctor(), s.getDerechoHabiente(), s.getUsuario(), s.getTotal());
            }
            tx.commit();
          
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener Salida");
        }finally{
            session.persist(lab);
        }
        return lab;
    }
    
    /**
     * Método para filtrar busqueda de salidas por Doctor
     * @param id
     * @return 
     */
    @Override
    public List<Salida> buscarSalidaDoctor(int id){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Salida> lista = new ArrayList();
        try{
           tx = session.beginTransaction();
           String hql = "FROM Salida WHERE idDoctor LIKE :idDoctor";
           Query query = session.createQuery(hql);
           query.setParameter("idDoctor", id);
           lista = query.list();
           
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Producto inexistente");
        }finally{
            session.close();
        }
        return lista;
    }
    
    @Override
    public List<Salida> buscarSalidaHabiente(int id){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Salida> lista = new ArrayList();
        try{
           tx = session.beginTransaction();
           String hql = "FROM Salida WHERE idDerechoHabiente LIKE :idDerechoHabiente";
           Query query = session.createQuery(hql);
           query.setParameter("idDerechoHabiente", id);
           lista = query.list();
           
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Producto inexistente");
        }finally{
            session.close();
        }
        return lista;
    }
    
     @Override
    public List<Salida> buscarSalidaUsuario(int id){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Salida> lista = new ArrayList();
        try{
           tx = session.beginTransaction();
           String hql = "FROM Salida WHERE idUsuario LIKE :idUsuario";
           Query query = session.createQuery(hql);
           query.setParameter("idUsuario", id);
           lista = query.list();
           
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Producto inexistente");
        }finally{
            session.close();
        }
        return lista;
    }
     @Override
    public void agregarProductoSalida(Salida sa,List<Producto> lista){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx= session.beginTransaction();
            Salida dr1 = session.get(Salida.class, sa.getId());
            for(Producto p : lista){
                dr1.getLista().add(p);
            }
            
            tx.commit();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ah ocurrido un error al agregar"
                    + "producto a la salida.");
        }finally{
            session.close();
        }
        
    }
}
