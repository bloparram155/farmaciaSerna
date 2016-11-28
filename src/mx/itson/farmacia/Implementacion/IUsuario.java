/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Implementacion;

import com.itson.farmacia.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import mx.itson.farmacia.Entidades.Persona;
import mx.itson.farmacia.Entidades.Usuario;
import mx.itson.farmacia.Interfaz.UsuarioInterfaz;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author blabla
 */
public class IUsuario implements UsuarioInterfaz {
    
    
    @Override
    public void agregarUsuario(Persona p){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            
            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Ah ocurrido un problema al agregar"
                    + "un usuario.");
        }finally{
            session.close();
        }
    }

    @Override
    public List<Usuario> mostrarUsuarios(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Usuario> lista= null;
        try{
            tx= session.beginTransaction();
            String hql = "FROM Usuario";
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
    
    
}
