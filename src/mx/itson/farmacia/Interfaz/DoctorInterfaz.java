/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Interfaz;

import java.util.List;
import mx.itson.farmacia.Entidades.DerechoHabiente;
import mx.itson.farmacia.Entidades.Doctor;

/**
 *
 * @author blabla
 */
public interface DoctorInterfaz {
    
    public void agregarDoctor(Doctor p);
    
    public List<Doctor> mostrarDoctores();
    
    public void agregarDerechoHabienteLista(DerechoHabiente dh,Doctor dr);
    
    public List<Doctor> buscarDoctor(String nombre);
    
    public Doctor obtenerDoctor(int id);
    
}
