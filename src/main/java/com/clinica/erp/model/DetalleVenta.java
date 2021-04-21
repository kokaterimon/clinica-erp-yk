package com.clinica.erp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleventa")
public class DetalleVenta {

    // ================================================================================
    // Columns
    @EmbeddedId
    private DetalleVentaKey id;

    @Column(name = "cantidad")
    private String cantidad;
    // ==============================================================================//



    // ================================================================================
    // Relations
    @ManyToOne
    @JoinColumn(name = "idVenta", insertable = false, updatable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idServicio", insertable = false, updatable = false)
    private Servicio servicio;

    @ManyToOne
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
