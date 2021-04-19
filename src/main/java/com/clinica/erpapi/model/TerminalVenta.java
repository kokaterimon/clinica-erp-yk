package com.clinica.erpapi.model;

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

@Entity
@Table(name = "terminalventa")
public class TerminalVenta {

    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTerminal")
    private long idTerminal;

    @Column(name = "nombreTerminal")
    private String nombreTerminal;
    // ==============================================================================//


    // ================================================================================
    // Relations
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idSede")
    private Sede sede;

    @OneToMany(mappedBy = "terminalventa")
    private Set<Venta> ventas = new HashSet<>();
    // ==============================================================================//


    // ================================================================================
    // Getters and Setters
    public long getIdTerminal() {
        return idTerminal;
    }
    public void setIdTerminal(long idTerminal) {
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
