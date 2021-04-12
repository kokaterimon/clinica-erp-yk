package com.clinica.erpapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private long idUsuario;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "emailUsuario")
    private String emailUsuario;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;
    //==============================================================================// 
}
