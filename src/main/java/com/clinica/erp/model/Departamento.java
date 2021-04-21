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
@Table(name = "departamento")
public class Departamento {

    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartamento")
    private long idDepartamento;

    @Column(name = "nombreDepartamento")
    private String nombreDepartamento;
    //==============================================================================// 

    //================================================================================ 
    // Relations
    @OneToMany(mappedBy = "departamento")
    private Set<Provincia> provincias = new HashSet<>();
    //==============================================================================// 

    //================================================================================ 
    // Getters and Setters
    public long getIdDepartamento() {
        return idDepartamento;
    }
    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    //==============================================================================// 


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idDepartamento ^ (idDepartamento >>> 32));
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
        Departamento other = (Departamento) obj;
        if (idDepartamento != other.idDepartamento)
            return false;
        return true;
    }

}
