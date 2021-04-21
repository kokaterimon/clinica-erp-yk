package com.clinica.erp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "institucion")
public class Institucion {
     //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInstitucion")
    private long idInstitucion;

    @Column(name = "nombreInstitucion")
    private String nombreInstitucion;

    @Column(name = "descripcion")
    private String descripcion;
    //==============================================================================// 

    //================================================================================ 
    // Relations
    @OneToMany(mappedBy = "institucion")
    private Set<EmpInstitucion> empInstituciones = new HashSet<>();
    //==============================================================================// 

    //================================================================================ 
    // Getters and Setters
    public long getIdInstitucion() {
        return idInstitucion;
    }
    public void setIdInstitucion(long idInstitucion) {
        this.idInstitucion = idInstitucion;
    }
    public String getNombreInstitucion() {
        return nombreInstitucion;
    }
    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set<EmpInstitucion> getEmpInstituciones() {
        return empInstituciones;
    }
    public void setEmpInstituciones(Set<EmpInstitucion> empInstituciones) {
        this.empInstituciones = empInstituciones;
    } 
    //==============================================================================// 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idInstitucion ^ (idInstitucion >>> 32));
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
        Institucion other = (Institucion) obj;
        if (idInstitucion != other.idInstitucion)
            return false;
        return true;
    }
    
    
    
}
