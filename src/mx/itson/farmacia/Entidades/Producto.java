/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Entidades;

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
@Entity(name="Producto")
@Table(name="Producto")
public class Producto {
    
    private int idProducto;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;
    private Laboratorio laboratorio;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="idProducto")
    public int getId() {
        return idProducto;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.idProducto = id;
    }

    /**
     * @return the descripcion
     */
    @Column(name="descripcion",length=150)
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

    /**
     * @return the precioUnitario
     */
    @Column(name="precioUnitario",length= 5)
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * @return the laboratorio
     */
    @ManyToOne
    @JoinColumn(name="idLaboratorio",
            foreignKey = @ForeignKey(name="idLaboratorio"))
    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    /**
     * @param laboratorio the laboratorio to set
     */
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
   
    /**
     * @return the cantidad
     */
    @Column(name="cantidad",length=10)
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the nombre
     */
    @Column(name="nombre",length=45)
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    
    
}
