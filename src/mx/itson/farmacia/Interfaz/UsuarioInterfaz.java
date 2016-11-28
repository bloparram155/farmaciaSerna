/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Interfaz;

import java.util.List;
import mx.itson.farmacia.Entidades.Persona;
import mx.itson.farmacia.Entidades.Usuario;

/**
 *
 * @author blabla
 */
public interface UsuarioInterfaz {
    
    /**
     * Método que recibe un Objeto Usuario con sus respectivos atributos 
     * para ser guardado mediante Hibernate.
     * @param p
     */
    public void agregarUsuario(Persona p);
    
    /**
     * Método que trae todos los registros de la tabla Usuario y los mete en una
     * lista de tipo Usuario para ser utilizada en una tabla y mostrar los 
     * atributos.
     * @return List<Usuario> 
     */
    public List<Usuario> mostrarUsuarios();

    
    public Usuario persistirUsuario(String nombreUsuario, String contraseña);
    

}
