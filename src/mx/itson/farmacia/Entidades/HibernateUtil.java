/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Entidades;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author blabla
 */
public class HibernateUtil {
    
     static SessionFactory sessionFactory ;

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory() ;
		} catch (HibernateException ex) {
			System.out.println("Imposible relizar la conexiÃ³n con el servicio: " + ex) ;
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory ;
	}
    
}
