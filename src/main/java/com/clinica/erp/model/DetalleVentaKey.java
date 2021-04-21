package com.clinica.erp.model;

import java.io.Serializable;

import javax.persistence.Column;

public class DetalleVentaKey  implements Serializable  {
    @Column(name = "idVenta")
    Long idVenta;

    @Column(name = "idServicio")
    Long idServicio;
}
