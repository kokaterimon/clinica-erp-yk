package com.clinica.erpapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "educacion")
public class Educacion {
     //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEducacion")
    private long idEducacion;

    @Column(name = "nombreEducacion")
    private String nombreEducacion;

    @Column(name = "descripcion")
    private String descripcion;
    //==============================================================================// 

    //================================================================================ 
    // Relations
    @ManyToMany(mappedBy = "educacion")
    private Set<Empleado> empleados = new HashSet<>();   
    //==============================================================================// 

    //================================================================================ 
    // Getters and Setters
    public long getIdEducacion() {
        return idEducacion;
    }
    public void setIdEducacion(long idEducacion) {
        this.idEducacion = idEducacion;
    }
    public String getNombreEducacion() {
        return nombreEducacion;
    }
    public void setNombreEducacion(String nombreEducacion) {
        this.nombreEducacion = nombreEducacion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set<Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }
    //==============================================================================// 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idEducacion ^ (idEducacion >>> 32));
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
        Educacion other = (Educacion) obj;
        if (idEducacion != other.idEducacion)
            return false;
        return true;
    }

    
}
