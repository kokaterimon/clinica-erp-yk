package com.clinica.erp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "terminalventa")
public class TerminalVenta {

    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTerminal")
    private Integer idTerminal;

    @Column(name = "nombreTerminal")
    private String nombreTerminal;
    // ==============================================================================//


    // ================================================================================
    // Relations
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idSede")
    private Sede sede;

    @OneToMany(mappedBy = "terminalVenta")
    @JsonIgnore
    private Set<Venta> ventas = new HashSet<>();
    // ==============================================================================//


    // ================================================================================
    // Getters and Setters
    public Integer getIdTerminal() {
        return idTerminal;
    }
    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }
    public String getNombreTerminal() {
        return nombreTerminal;
    }
    public void setNombreTerminal(String nombreTerminal) {
        this.nombreTerminal = nombreTerminal;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Sede getSede() {
        return sede;
    }
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public Set<Venta> getVentas() {
        return ventas;
    }
    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }
    // ==============================================================================//
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idTerminal ^ (idTerminal >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TerminalVenta other = (TerminalVenta) obj;
        if (idTerminal != other.idTerminal)
            return false;
        return true;
    }


    

    

}
