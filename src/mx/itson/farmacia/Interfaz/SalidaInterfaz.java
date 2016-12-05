/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Interfaz;

import java.util.List;
import mx.itson.farmacia.Entidades.Producto;
import mx.itson.farmacia.Entidades.Salida;

/**
 *
 * @author blabla
 */
public interface SalidaInterfaz {
    
    
    public void agregarSalida(Salida s);
    
    public List<Salida> mostrarSalidas();
    
    public Salida obtenerSalida(int id);
    
    public List<Salida> buscarSalidaDoctor(int id);
    
    public void agregarProductoSalida(Salida sa,List<Producto> lista);
    
    public List<Salida> buscarSalidaHabiente(int id);
    
    public List<Salida> buscarSalidaUsuario(int id);
    
}
