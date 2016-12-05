/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Interfaz;

import java.util.List;
import mx.itson.farmacia.Entidades.Salida;

/**
 *
 * @author blabla
 */
public interface SalidaInterfaz {
    
    
    public void agregarSalida(Salida s);
    
    public List<Salida> mostrarSalidas();
    
}
