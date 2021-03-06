package com.clinica.erp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "distrito")
public class Distrito {
    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDistrito")
    private Integer idDistrito;
    
    @Column(name = "nombDistrito")
    private String nombDistrito;

    @Column(name = "idProvincia")
    private Integer idProvincia;
    //==============================================================================// 

    //================================================================================ 
    // Relations
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idProvincia", insertable = false, updatable = false)
    private Provincia provincia;

    @OneToMany(mappedBy = "distrito")
    @JsonIgnore
    private Set<Empleado> empleados = new HashSet<>();

    
    //==============================================================================// 

    //================================================================================ 
    // Getters and Setters
    public Integer getIdDistrito() {
        return idDistrito;
    }
    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }
    public String getnombDistrito() {
        return nombDistrito;
    }
    public void setnombDistrito(String nombDistrito) {
        this.nombDistrito = nombDistrito;
    } 
    public Set<Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }
    public Integer getIdProvincia() {
        return idProvincia;
    }
    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }
    public Provincia getProvincia() {
        return provincia;
    }
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    //==============================================================================// 


    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idDistrito ^ (idDistrito >>> 32));
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
        Distrito other = (Distrito) obj;
        if (idDistrito != other.idDistrito)
            return false;
        return true;
    }
    
    
    
}
