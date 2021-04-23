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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "muestra")
public class Muestra {

    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMuestra")
    private Integer idMuestra;

    @Column(name = "nombreMuestra")
    private String nombreMuestra;
    // ==============================================================================//


    // ================================================================================
    // Relations
    @OneToMany(mappedBy = "muestra")
    @JsonIgnore
    private Set<Servicio> servicios = new HashSet<>();
    // ==============================================================================//


    //================================================================================ 
    // Getters and Setters
    public Integer getIdMuestra() {
        return idMuestra;
    }
    public void setIdMuestra(Integer idMuestra) {
        this.idMuestra = idMuestra;
    }
    public String getNombreMuestra() {
        return nombreMuestra;
    }
    public void setNombreMuestra(String nombreMuestra) {
        this.nombreMuestra = nombreMuestra;
    }
    public Set<Servicio> getServicios() {
        return servicios;
    }
    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }
    // ==============================================================================//

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idMuestra ^ (idMuestra >>> 32));
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
        Muestra other = (Muestra) obj;
        if (idMuestra != other.idMuestra)
            return false;
        return true;
    }


    
    
        
}
