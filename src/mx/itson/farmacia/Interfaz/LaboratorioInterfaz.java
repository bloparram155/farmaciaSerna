/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Interfaz;

import java.util.List;
import mx.itson.farmacia.Entidades.Laboratorio;
import mx.itson.farmacia.Entidades.Producto;

/**
 *
 * @author blabla
 */
public interface LaboratorioInterfaz {
    
    public void agregarLaboratorio(Laboratorio lab);
    
    public List<Laboratorio> mostrarLaboratorios();
    
    public List<Laboratorio> buscarLaboratorio(String nombre);
    
    public Laboratorio obtenerLaboratorio(int id);
    
    public void agregarProductoLista(Producto pro,Laboratorio lab);
}
