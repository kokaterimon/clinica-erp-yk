package com.clinica.erp.model;

import java.util.Date;
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
@Table(name = "venta")
public class Venta {

    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Integer idVenta;

    @Column(name = "nroFactura")
    private String nroFactura;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "idCliente")
    private Integer idCliente;

    @Column(name = "idTerminal")
    private Integer idTerminal;
    // ==============================================================================//



    // ================================================================================
    // Relations
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idCliente", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idTerminal", insertable = false, updatable = false)
    private TerminalVenta terminalVenta;

    @OneToMany(mappedBy = "venta")
    private Set<DetalleVenta> detallesVenta = new HashSet<>();
    // ==============================================================================//



    // ================================================================================
    // Getters and Setters
    public Integer getIdVenta() {
        return idVenta;
    }
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public String getNroFactura() {
        return nroFactura;
    }
    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public Integer getIdTerminal() {
        return idTerminal;
    }
    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public TerminalVenta getTerminalVenta() {
        return terminalVenta;
    }
    public void setTerminalVenta(TerminalVenta terminalVenta) {
        this.terminalVenta = terminalVenta;
    }
    public Set<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }
    public void setDetallesVenta(Set<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }
    // ==============================================================================//


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idVenta ^ (idVenta >>> 32));
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
        Venta other = (Venta) obj;
        if (idVenta != other.idVenta)
            return false;
        return true;
    }
    
}
