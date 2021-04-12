package com.clinica.erpapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")
    private long idEmpleado;
    
    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "salario")
    private String salario;

    //==============================================================================// 
    
    //================================================================================ 
    // Relations
    @ManyToOne
    @JoinColumn(name = "idDistrito")
    private Distrito distrito;

    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="emparea", 
                joinColumns={@JoinColumn(name="idEmpleado")}, 
                inverseJoinColumns={@JoinColumn(name="idArea")})
    private Set<Area> areas;
    //==============================================================================// 
}
