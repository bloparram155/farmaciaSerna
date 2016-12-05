/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Entidades;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author blabla
 */
@Entity(name="Usuario")
@Table(name="Usuario")
@AttributeOverrides({
    @AttributeOverride(name="id",column= @Column(name="idUsuario")),
    @AttributeOverride(name="nombre", column = @Column(name="nombre")),
    @AttributeOverride(name="apellido", column = @Column(name="apellido")),
    @AttributeOverride(name="domicilio", column = @Column(name="domicilio")),
    @AttributeOverride(name="ciudad", column = @Column(name="ciudad")),
    @AttributeOverride(name="telefono", column = @Column(name="telefono")),
    @AttributeOverride(name="edad", column = @Column(name="edad")),
    
})
public class Usuario extends Persona {
    
    
    private String usuarioLogin;
    private String contraseña;

    
    
 
    /**
     * Método para crear objeto de clase sin parámetros.
     */
    public Usuario(){
        
    }
    
    public Usuario(String nombre, String apellido, String domicilio, String ciudad, 
            String telefono, int edad, String usuarioLogin, String contraseña){
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.edad = edad;
        this.usuarioLogin = usuarioLogin;
        this.contraseña = contraseña;
    }
    /**
     * @return the usuarioLogin
     */
    @Column(name="usuarioLogin",length=45)
    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    /**
     * @param usuarioLogin the usuarioLogin to set
     */
    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    /**
     * @return the contraseña
     */
    @Column(name="contraseña", length= 45)
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
    @Override
    public String toString(){
        return nombre;
    }
 
    
}
