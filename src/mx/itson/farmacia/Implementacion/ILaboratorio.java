/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Implementacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mx.itson.farmacia.Entidades.DerechoHabiente;
import mx.itson.farmacia.Entidades.Doctor;
import mx.itson.farmacia.Entidades.HibernateUtil;
import mx.itson.farmacia.Entidades.Laboratorio;
import mx.itson.farmacia.Entidades.Producto;
import mx.itson.farmacia.Interfaz.LaboratorioInterfaz;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author blabla
 */
public class ILaboratorio implements LaboratorioInterfaz{
    
    
    /**
     * Método para agregar laboratorio y guardarlo en la base de datos.
     * @param lab 
     */
    @Override
    public void agregarLaboratorio(Laboratorio lab){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(lab);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Se agrego con exito el laboratorio.");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al agregar laboratorio.");
        }finally{
            session.close();
        }
    }
    
    @Override
    public List<Laboratorio> mostrarLaboratorios(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx= null;
        List<Laboratorio> lista = new ArrayList();
        try{
            tx = session.beginTransaction();
            String hql = "FROM Laboratorio";
            Query query = session.createQuery(hql);
            lista = query.list();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al mostrar laboratorios.");
        }finally{
            session.close();
        }
        
        return lista;
    }
    
    @Override
    public List<Laboratorio> buscarLaboratorio(String nombre){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Laboratorio> lista = new ArrayList();
        try{
           tx = session.beginTransaction();
           String hql = "FROM Laboratorio WHERE nombre LIKE :nombre";
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
    public Laboratorio obtenerLaboratorio(int id){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Laboratorio lab=null;
        try{
            tx = session.beginTransaction();
            lab = session.load(Laboratorio.class, id);
          
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener Laboratorio.");
        }finally{
            session.persist(lab);
        }
        return lab;
    }

    @Override
    public void agregarProductoLista(Producto pro,Laboratorio lab){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx= session.beginTransaction();
            Laboratorio lab1 = session.get(Laboratorio.class, lab.getId());
            lab1.getLista().add(pro);
            session.saveOrUpdate(lab1);
            tx.commit();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ah ocurrido un error al agregar"
                    + "derechoHabiente al doctor asignado.");
        }finally{
            session.close();
        }
        
    }
}
