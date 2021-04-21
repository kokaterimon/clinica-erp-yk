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
@Table(name = "provincia")
public class Provincia {

    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProvincia")
    private long idProvincia;
    
    @Column(name = "nombreProvincia")
    private String nombreProvincia;
    //==============================================================================// 

    //================================================================================ 
    // Relations
    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private Departamento departamento;

    @OneToMany(mappedBy = "provincia")
    private Set<Distrito> distritos = new HashSet<>();
    //==============================================================================// 

    //================================================================================ 
    // Getters and Setters
    public long getIdProvincia() {
        return idProvincia;
    }
    public void setIdProvincia(long idProvincia) {
        this.idProvincia = idProvincia;
    }
    public String getNombreProvincia() {
        return nombreProvincia;
    }
    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
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
