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
import mx.itson.farmacia.Interfaz.ProductoInterfaz;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author blabla
 */
public class IProducto implements ProductoInterfaz{
    
    
    @Override
    public void agregarProducto(Producto p){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            
            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Ah ocurrido un problema al agregar"
                    + "producto.");
        }finally{
            session.close();
        }
    }
    
    
    @Override
    public List<Producto> obtenerProductos(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Producto> lista = new ArrayList();
        try{
            tx = session.beginTransaction();
            String hql = "FROM Producto";
            Query query = session.createQuery(hql);
            lista = query.list();
            tx.commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al mostrar los productos.");
        }finally{
            session.close();
        }
        return lista;
    }
    
    @Override
    public List<Producto> buscarProducto(String nombre){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Producto> lista = new ArrayList();
        try{
           tx = session.beginTransaction();
           String hql = "FROM Producto WHERE nombre LIKE :nombre";
           Query query = session.createQuery(hql);
           query.setParameter("nombre", nombre);
           lista = query.list();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Producto inexistente");
        }finally{
            session.close();
        }
        return lista;
    }
    
    @Override
    public Producto obtenerProducto(int id){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Producto dr=null;
        try{
            tx = session.beginTransaction();
            dr = session.get(Producto.class, id);
          
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener producto.");
        }finally{
            session.persist(dr);
        }
        return dr;
    }
    
    @Override
    public void actualizarProducto(Producto p){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "UPDATE Producto set cantidad = :cantidad WHERE idProducto = :idProducto";
            Query query = session.createQuery(hql);
            query.setParameter("cantidad", p.getCantidad());
            query.setParameter("idProducto", p.getId());
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al actualizar registro de producto");
        }finally{
            session.close();
        }
    }
    
}
