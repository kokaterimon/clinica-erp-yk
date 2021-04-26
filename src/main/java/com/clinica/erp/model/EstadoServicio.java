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
@Table(name = "estadoservicio")
public class EstadoServicio {
    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoServ")
    private Integer idEstadoServ;

    @Column(name = "nombreEst")
    private String nombreEst;
    // ==============================================================================//

    // ================================================================================
    // Relations
    @OneToMany(mappedBy = "estadoservicio")
    @JsonIgnore
    private Set<DetalleVenta> detallesVenta = new HashSet<>();
    // ==============================================================================//


    // ================================================================================
    // Getters and Setters
    public Integer getIdEstadoServ() {
        return idEstadoServ;
    }
    public void setIdEstadoServ(Integer idEstadoServ) {
        this.idEstadoServ = idEstadoServ;
    }
    public String getNombreEst() {
        return nombreEst;
    }
    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }
    public Set<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }
    public void setDetallesVenta(Set<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }    
    // ==============================================================================//

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idEstadoServ ^ (idEstadoServ >>> 32));
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
        EstadoServicio other = (EstadoServicio) obj;
        if (idEstadoServ != other.idEstadoServ)
            return false;
        return true;
    }
        
}
