/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Implementacion;

import mx.itson.farmacia.Entidades.HibernateUtil;
import mx.itson.farmacia.Entidades.DerechoHabiente;
import mx.itson.farmacia.Entidades.Doctor;
import mx.itson.farmacia.Entidades.Laboratorio;
import mx.itson.farmacia.Entidades.Persona;
import mx.itson.farmacia.Entidades.Producto;
import mx.itson.farmacia.Entidades.Usuario;
import mx.itson.farmacia.Interfaz.DerechoHabienteInterfaz;
import mx.itson.farmacia.Interfaz.DoctorInterfaz;
import mx.itson.farmacia.Interfaz.UsuarioInterfaz;
import mx.itson.farmacia.Interfaz.ValidacionInterfaz;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author blabla
 */
public class TestConsola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Session sessionUser = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        tx = sessionUser.beginTransaction();
        Laboratorio lab = sessionUser.load(Laboratorio.class, 13);
        for(Producto pro : lab.getLista()){
            System.out.println(pro.getNombre());
        }
        tx.commit();
        sessionUser.close();
        
        /*
        Usuario user = new Usuario();
        Doctor dr = new Doctor();
        DerechoHabiente dh = new DerechoHabiente();
        IUsuario us = new IUsuario();
        DoctorInterfaz idr = new IDoctor();
        DerechoHabienteInterfaz dhi = new IDerechoHabiente();
        UsuarioInterfaz usi = new IUsuario();
        //ValidacionInterfaz vai = new IValidacion();
        */
       
        /*
        Crea objeto de Usuario
        user.setNombre("Miguel");
        user.setApellido("Laprada");
        user.setDomicilio("San Vicente");
        user.setCiudad("Guaymas");
        user.setEdad(23);
        user.setTelefono("6221047534");
        user.setUsuarioLogin("lapras");
        user.setContraseña("789");
        
        us.agregarUsuario(user);*/
        
        /*
        Crea objeto de Doctor
        dr.setNombre("Hannibal");
        dr.setApellido("Lecter");
        dr.setDomicilio("San Carlos");
        dr.setCiudad("Guaymas");
        dr.setEdad(50);
        dr.setTelefono("6221564896");
        dr.setEspecialidad("Cirujano");
        dr.setHorario("10AM-4PM");
        
        idr.agregarDoctor(dr);
        */
        
        /*
        dh.setNombre("Jesus");
        dh.setApellido("Guereña");
        dh.setDomicilio("San Carlos");
        dh.setCiudad("Guaymas");
        dh.setEdad(19);
        dh.setTelefono("6221547854");
        dh.setAfiliacion(5642376);
        dh.setDoctor(dr1);
        dh.setDependencia("ISSTESON");
        dh.setFechaIngreso("27/11/2016");
    
        dhi.agregarDerechoHabiente(dh);
        idr.agregarDerechoHabienteLista(dh, dr1);
        
        */
        
       /* boolean stat = vai.validarCredenciales("bloparram", "12");
        System.out.println(stat);
        */
    }
    
}
