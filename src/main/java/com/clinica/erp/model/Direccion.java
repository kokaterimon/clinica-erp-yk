package com.clinica.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion {
    
    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDireccion")
    private long idDireccion;
    
    @Column(name = "direccion")
    private String direccion;
    //==============================================================================// 

    //================================================================================ 
    // Relations
    @ManyToOne
    @JoinColumn(name = "idDistrito")
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;
    //==============================================================================//

    //================================================================================ 
    // Getters and Setters
    public long getIdDireccion() {
        return idDireccion;
    }
    public void setIdDireccion(long idDireccion) {
        this.idDireccion = idDireccion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Distrito getDistrito() {
        return distrito;
    }
    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    //==============================================================================//


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idDireccion ^ (idDireccion >>> 32));
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
        Direccion other = (Direccion) obj;
        if (idDireccion != other.idDireccion)
            return false;
        return true;
    }

    
    

    
}
