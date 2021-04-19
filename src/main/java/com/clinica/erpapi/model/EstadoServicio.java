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
@Table(name = "estadoservicio")
public class EstadoServicio {
    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio")
    private long idServicio;

    @Column(name = "nombreServicio")
    private String nombreServicio;
    // ==============================================================================//


    // ================================================================================
    // Relations
    @OneToMany(mappedBy = "estadoservicio")
    private Set<DetalleVenta> detallesVenta = new HashSet<>();
    // ==============================================================================//
    
    
    // ================================================================================
    // Getters and Setters
    public long getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
    }
    public String getNombreServicio() {
        return nombreServicio;
    }
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
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
        result = prime * result + (int) (idServicio ^ (idServicio >>> 32));
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
        if (idServicio != other.idServicio)
            return false;
        return true;
    }


    

}
