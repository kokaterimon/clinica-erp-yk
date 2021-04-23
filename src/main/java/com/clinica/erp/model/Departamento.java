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

import org.springframework.lang.NonNull;


@Entity
@Table(name = "departamento")
public class Departamento {

    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartamento")
    private Integer idDepartamento;

    @NonNull
    @Column(name = "nombDepartamento")
    private String nombDepartamento;

    @NonNull
    @Column(name = "codigo")
    private String codigo;
    //==============================================================================// 



    //================================================================================ 
    // Relations
    @OneToMany(mappedBy = "departamento")
    @JsonIgnore
    private Set<Provincia> provincias = new HashSet<>();
    //==============================================================================// 



    //================================================================================ 
    // Getters and Setters
        public Integer getIdDepartamento() {
        return idDepartamento;
    }


    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }


    public String getnombDepartamento() {
        return nombDepartamento;
    }

    public void setnombDepartamento(String nombDepartamento) {
        this.nombDepartamento = nombDepartamento;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }   
    public Set<Provincia> getProvincias() {
        return provincias;
    }
    public void setProvincias(Set<Provincia> provincias) {
        this.provincias = provincias;
    }
    //==============================================================================// 

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idDepartamento ^ (idDepartamento >>> 32));
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
        Departamento other = (Departamento) obj;
        if (idDepartamento != other.idDepartamento)
            return false;
        return true;
    }

}
