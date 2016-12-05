/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Interfaz;

import java.util.List;

import mx.itson.farmacia.Entidades.*;

/**
 *
 * @author blabla
 */
public interface DerechoHabienteInterfaz {
    
      public void agregarDerechoHabiente(DerechoHabiente dh);
      
      public List<DerechoHabiente> mostrarDerechoHabientes();

      public List<DerechoHabiente> buscarDerechoHabiente(String nombre);
}
