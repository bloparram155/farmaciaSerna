/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Entidades;

import java.util.ArrayList;
import java.util.List;
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
@Entity(name="Laboratorio")
@Table(name="Laboratorio")
public class Laboratorio {
    
    
    private int idLaboratorio;
    private String nombre;
    private String domicilio;
    private String ciudad;
    private List<Producto> lista = new ArrayList<>();

    
    /**
     * Método para crear objetos de clase sin parámetros.
     */
    public Laboratorio(){
        
    }
    
    public Laboratorio(String nombre, String domicilio, String ciudad){
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
    }
    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idLaboratorio")
    public int getId() {
        return idLaboratorio;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.idLaboratorio = id;
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

    /**
     * @return the domicilio
     */
    @Column(name="domicilio", length=45)
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the ciudad
     */
    @Column(name="ciudad", length= 45)
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the lista
     */
    @OneToMany(mappedBy= "laboratorio", cascade= CascadeType.ALL, orphanRemoval=true)
    @OrderBy("precioUnitario")
    public List<Producto> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
}
