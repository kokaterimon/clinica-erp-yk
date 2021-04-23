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
@Table(name = "provincia")
public class Provincia {

    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProvincia")
    private Integer idProvincia;
    
    @Column(name = "nombProvincia")
    private String nombProvincia;
    
    @Column(name = "idDepartamento")
    private Integer idDepartamento;
    //==============================================================================// 


    //================================================================================ 
    // Relations
        @ManyToOne
        @JsonIgnore
        @JoinColumn(name = "idDepartamento", insertable = false, updatable = false)
        private Departamento departamento;

        @OneToMany(mappedBy = "provincia")
        @JsonIgnore
        private Set<Distrito> distritos = new HashSet<>();
    //==============================================================================// 


    //================================================================================ 
    // Getters and Setters
    public Integer getIdProvincia() {
        return idProvincia;
    }
    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }
    public String getnombProvincia() {
        return nombProvincia;
    }
    public void setnombProvincia(String nombProvincia) {
        this.nombProvincia = nombProvincia;
    }
    public Integer getIdDepartamento() {
        return idDepartamento;
    }
    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }    
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public Set<Distrito> getDistritos() {
        return distritos;
    }
    public void setDistritos(Set<Distrito> distritos) {
        this.distritos = distritos;
    }
    //==============================================================================//

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idProvincia ^ (idProvincia >>> 32));
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
        Provincia other = (Provincia) obj;
        if (idProvincia != other.idProvincia)
            return false;
        return true;
    } 

}
