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
@Table(name = "tiempoproceso")
public class TiempoProceso {
    
    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTiempoProc")
    private long idTiempoProc;

    @Column(name = "nombretp")
    private String nombretp;
    // ==============================================================================//


    // ================================================================================
    // Relations
    @OneToMany(mappedBy = "tiempoProc")
    private Set<Servicio> servicios = new HashSet<>();
    // ==============================================================================//


    //================================================================================ 
    // Getters and Setters
    public long getIdTiempoProc() {
        return idTiempoProc;
    }
    public void setIdTiempoProc(long idTiempoProc) {
        this.idTiempoProc = idTiempoProc;
    }
    public String getNombretp() {
        return nombretp;
    }
    public void setNombretp(String nombretp) {
        this.nombretp = nombretp;
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
