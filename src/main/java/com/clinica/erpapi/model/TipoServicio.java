package com.clinica.erpapi.model;

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
@Table(name = "tiposervicio")
public class TipoServicio {

    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoServicio")
    private long idTipoServicio;

    @Column(name = "nombreTipoServicio")
    private String nombreTipoServicio;
    // ==============================================================================//


    // ================================================================================
    // Relations
    @OneToMany(mappedBy = "tiposervicio")
    private Set<Servicio> servicios = new HashSet<>();
    // ==============================================================================//
    
    
    //================================================================================ 
    // Getters and Setters
    public long getIdTipoServicio() {
        return idTipoServicio;
    }
    public void setIdTipoServicio(long idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }
    public String getNombreTipoServicio() {
        return nombreTipoServicio;
    }
    public void setNombreTipoServicio(String nombreTipoServicio) {
        this.nombreTipoServicio = nombreTipoServicio;
    }
    public Set<Servicio> getServicios() {
        return servicios;
    }
    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }
    //===============================================================================//  


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idTipoServicio ^ (idTipoServicio >>> 32));
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
        TipoServicio other = (TipoServicio) obj;
        if (idTipoServicio != other.idTipoServicio)
            return false;
        return true;
    }

    

}
