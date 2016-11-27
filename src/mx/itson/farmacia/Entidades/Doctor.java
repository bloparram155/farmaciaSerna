/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author blabla
 */
@Entity(name="Doctor")
@Table(name="Doctor")
@AttributeOverrides({
    @AttributeOverride(name="id",column= @Column(name="idDoctor")),
    @AttributeOverride(name="nombre", column = @Column(name="nombre")),
    @AttributeOverride(name="apellido", column = @Column(name="apellido")),
    @AttributeOverride(name="domicilio", column = @Column(name="domicilio")),
    @AttributeOverride(name="ciudad", column = @Column(name="ciudad")),
    @AttributeOverride(name="telefono", column = @Column(name="telefono")),
    @AttributeOverride(name="edad", column = @Column(name="edad")),
    
})
public class Doctor extends Persona{
    

    
    private String especialidad;
    private String horario;
    private List<DerechoHabiente> lista = new ArrayList<>();

   
   
    /**
     * @return the especialidad
     */
    @Column(name="especialidad")
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

   

    /**
     * @return the horario
     */
    @Column(name="horario")
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the lista
     */
    @OneToMany(mappedBy= "doctor", cascade= CascadeType.ALL, orphanRemoval = true)
    @OrderBy("afiliacion")
    public List<DerechoHabiente> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<DerechoHabiente> lista) {
        this.lista = lista;
    }

    
    
    
    
}
