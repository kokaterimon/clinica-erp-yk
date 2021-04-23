package com.clinica.erp.model;

import java.io.Serializable;

import javax.persistence.Column;

public class DetalleVentaKey  implements Serializable  {
    @Column(name = "idVenta")
    Integer idVenta;

    @Column(name = "idServicio")
    Integer idServicio;
}
