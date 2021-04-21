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

@Entity
@Table(name = "distrito")
public class Distrito {
    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDistrito")
    private long idDistrito;
    
    @Column(name = "nombreDistrito")
    private String nombreDistrito;
    //==============================================================================// 

    //================================================================================ 
    // Relations
    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private Provincia provincia;

    @OneToMany(mappedBy = "distrito")
    private Set<Direccion> direcciones = new HashSet<>();
    //==============================================================================// 

    //================================================================================ 
    // Getters and Setters
    public long getIdDistrito() {
        return idDistrito;
    }
    public void setIdDistrito(long idDistrito) {
        this.idDistrito = idDistrito;
    }
    public String getNombreDistrito() {
        return nombreDistrito;
    }
    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }
    public Provincia getProvincia() {
        return provincia;
    }
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    public Set<Direccion> getDirecciones() {
        return direcciones;
    }
    public void setDirecciones(Set<Direccion> direcciones) {
        this.direcciones = direcciones;
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
