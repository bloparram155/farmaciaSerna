/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Interfaz;

import java.util.List;
import mx.itson.farmacia.Entidades.Producto;

/**
 *
 * @author blabla
 */
public interface ProductoInterfaz {
    
    public void agregarProducto(Producto p);
    
    public List<Producto> obtenerProductos();
    
    public List<Producto> buscarProducto(String nombre);
}
