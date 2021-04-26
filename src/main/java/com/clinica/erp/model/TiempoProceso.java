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
@Table(name = "tiempoproceso")
public class TiempoProceso {
    
    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTiempoProc")
    private Integer idTiempoProc;

    @Column(name = "nombreTiempoProc")
    private String nombreTiempoProc;
    // ==============================================================================//


    // ================================================================================
    // Relations
    @OneToMany(mappedBy = "tiempoProc")
    @JsonIgnore
    private Set<Servicio> servicios = new HashSet<>();
    // ==============================================================================//


    //================================================================================ 
    // Getters and Setters
    public Integer getIdTiempoProc() {
        return idTiempoProc;
    }
    public void setIdTiempoProc(Integer idTiempoProc) {
        this.idTiempoProc = idTiempoProc;
    }
    public String getNombreTiempoProc() {
        return nombreTiempoProc;
    }
    public void setNombreTiempoProc(String nombreTiempoProc) {
        this.nombreTiempoProc = nombreTiempoProc;
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
        result = prime * result + (int) (idTiempoProc ^ (idTiempoProc >>> 32));
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
        TiempoProceso other = (TiempoProceso) obj;
        if (idTiempoProc != other.idTiempoProc)
            return false;
        return true;
    } 
}
