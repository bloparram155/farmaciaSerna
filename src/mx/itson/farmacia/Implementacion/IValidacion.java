/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Implementacion;

import javax.swing.JOptionPane;
import mx.itson.farmacia.Entidades.Usuario;
import mx.itson.farmacia.Interfaz.UsuarioInterfaz;
import mx.itson.farmacia.Interfaz.ValidacionInterfaz;

/**
 *
 * @author blabla
 */
public class IValidacion implements ValidacionInterfaz {
    
    @Override
    public boolean validarCredenciales(String x, String y){
        UsuarioInterfaz usi = new IUsuario();
        boolean status = false;
        try{
            Usuario user= usi.persistirUsuario(x, y);
            if(user.getUsuarioLogin().equals(x)||user.getContraseña().equals(y)){
                JOptionPane.showMessageDialog(null, "Te as loggeado con éxito.");
                status=true;
            }else{
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            }
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Ah ocurrido un problema al"
                        + "validar las credenciales de login.");
        }
        return status;
    }
    
}
