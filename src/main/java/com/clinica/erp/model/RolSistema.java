package com.clinica.erp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rolsistema")
public class RolSistema {

    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRolSistema")
    private Integer idRolSistema;

    @Column(name = "nombreRol")
    private String nombreRol;
    // ==============================================================================//

    //================================================================================ 
    // Relations
    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios = new HashSet<>();   
    //==============================================================================//

    //================================================================================ 
    // Getters and Setters
    public Integer getIdRolSistema() {
        return idRolSistema;
    }
    public void setIdRolSistema(Integer idRolSistema) {
        this.idRolSistema = idRolSistema;
    }
    public String getNombreRol() {
        return nombreRol;
    }
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    public Set<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    //==============================================================================//
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idRolSistema ^ (idRolSistema >>> 32));
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
        RolSistema other = (RolSistema) obj;
        if (idRolSistema != other.idRolSistema)
            return false;
        return true;
    }

    
}
