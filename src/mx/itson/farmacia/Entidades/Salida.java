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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author blabla
 */
@Entity(name="Salida")
@Table(name="Salida")
public class Salida {
    
    private int idSalida;
    private List<Producto> lista = new ArrayList<>();
    private Doctor doctor;
    private DerechoHabiente derechoHabiente;
    private Usuario usuario;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idSalida")
    public int getId() {
        return idSalida;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.idSalida = id;
    }

    /**
     * @return the lista
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval= true)
    @OrderBy("nombre")
    public List<Producto> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

    /**
     * @return the doctor
     */
    @OneToOne
    @JoinColumn(name = "idDoctor")
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
     * @return the derechoHabiente
     */
    @OneToOne
    @JoinColumn(name = "idDerechoHabiente")
    public DerechoHabiente getDerechoHabiente() {
        return derechoHabiente;
    }

    /**
     * @param derechoHabiente the derechoHabiente to set
     */
    public void setDerechoHabiente(DerechoHabiente derechoHabiente) {
        this.derechoHabiente = derechoHabiente;
    }

    /**
     * @return the usuario
     */
    @OneToOne
    @JoinColumn(name = "idUsuario")
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    
    
    
}
