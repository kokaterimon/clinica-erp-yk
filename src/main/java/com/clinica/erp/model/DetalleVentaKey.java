package com.clinica.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetalleVentaKey  implements Serializable  {
    @Column(name = "idVenta")
    Integer idVenta;

    @Column(name = "idServicio")
    Integer idServicio;

    public  DetalleVentaKey() {

    }

    public DetalleVentaKey(Integer idVenta, Integer idServicio) {
        this.idVenta = idVenta;
        this.idServicio = idServicio;
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

    
}
