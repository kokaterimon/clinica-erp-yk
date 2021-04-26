package com.clinica.erp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalleventa")
public class DetalleVenta {

    // ================================================================================
    // Columns
    @EmbeddedId
    private DetalleVentaKey id;

    @Column(name = "idVenta", insertable = false, updatable = false)
    private Integer idVenta;

    @Column(name = "idServicio", insertable = false, updatable = false)
    private Integer idServicio;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "idEstadoServ")
    private Integer idEstadoServ;
    // ==============================================================================//

    // ================================================================================
    // Relations
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idVenta", insertable = false, updatable = false)
    private Venta venta;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idServicio", insertable = false, updatable = false)
    private Servicio servicio;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idEstadoServ", insertable = false, updatable = false)
    private EstadoServicio estadoservicio;
    // ==============================================================================//

    // ================================================================================
    // Getters and Setters
    public DetalleVentaKey getId() {
        return id;
    }
    public void setId(DetalleVentaKey id) {
        this.id = id;
    }
    public String getCantidad() {
        return cantidad;
    }
    public Integer getIdVenta() {
        return idVenta;
    }
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public Integer getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }
    public Integer getIdEstadoServ() {
        return idEstadoServ;
    }
    public void setIdEstadoServ(Integer idEstadoServ) {
        this.idEstadoServ = idEstadoServ;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public Venta getVenta() {
        return venta;
    }
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public EstadoServicio getEstadoservicio() {
        return estadoservicio;
    }
    public void setEstadoservicio(EstadoServicio estadoservicio) {
        this.estadoservicio = estadoservicio;
    }
    // ==============================================================================//

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        DetalleVenta other = (DetalleVenta) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    // ==============================================================================//

}
