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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author blabla
 */
@Entity(name="DerechoHabiente")
@Table(name="Derechohabiente")
@AttributeOverrides({
    @AttributeOverride(name="id",column= @Column(name="idDerechoHabiente")),
    @AttributeOverride(name="nombre", column = @Column(name="nombre")),
    @AttributeOverride(name="apellido", column = @Column(name="apellido")),
    @AttributeOverride(name="domicilio", column = @Column(name="domicilio")),
    @AttributeOverride(name="ciudad", column = @Column(name="ciudad")),
    @AttributeOverride(name="telefono", column = @Column(name="telefono")),
    @AttributeOverride(name="edad", column = @Column(name="edad")),
    
})
public class DerechoHabiente extends Persona {
    
    
    private int afiliacion;
    private Doctor doctor;
    private String dependencia;
    private String fechaIngreso;

    
    /**
     * Método para crear objeto de la clase sin parámetros.
     */
    public DerechoHabiente(){
        
    }
    
    /**
     * Método para crear objeto de la clase con parámetros.
     * @param id
     * @param nombre
     * @param apellido
     * @param domicilio
     * @param ciudad
     * @param telefono
     * @param edad
     * @param afiliacion
     * @param dependencia
     * @param fechaIngreso 
     */
    public DerechoHabiente (String nombre, String apellido, String domicilio,
            String ciudad, String telefono, int edad, int afiliacion,Doctor doctor,String dependencia,
            String fechaIngreso){
        super();
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.edad = edad;
        this.afiliacion = afiliacion;
        this.doctor = doctor;
        this.dependencia = dependencia;
        this.fechaIngreso = fechaIngreso;
        
    }
    
    /**
     * @return the afiliacion
     */
    @Column(name="afiliacion",length=45)
    public int getAfiliacion() {
        return afiliacion;
    }

    /**
     * @param afiliacion the afiliacion to set
     */
    public void setAfiliacion(int afiliacion) {
        this.afiliacion = afiliacion;
    }

    /**
     * @return the doctor
     */
    @ManyToOne
    @JoinColumn(name="idDoctor",
            foreignKey = @ForeignKey(name="idDoctor"))
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    
    /**
     * @return the dependencia
     */
    @Column(name="dependencia",length=45)
    public String getDependencia() {
        return dependencia;
    }

    /**
     * @param dependencia the dependencia to set
     */
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    /**
     * @return the fechaIngreso
     */
    @Column(name="fechaIngreso", length=45)
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    

    
    
}
