package com.clinica.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "emp_institucion")
public class EmpInstitucion implements Serializable{
    
    //================================================================================ 
    // Columns
    @EmbeddedId
    EmpInstitucionKey id;

    @Column(name = "fechaInicio")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date fechaInicio;

    @Column(name = "fechaFin")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date fechaFin;

    @Column(name = "archivo")
    private String archivo;
    //==============================================================================// 

    //================================================================================ 
    // Relations
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idInstitucion", insertable = false, updatable = false)
    private Institucion institucion;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idEmpleado", insertable = false, updatable = false)
    private Empleado empleado;
    //==============================================================================//

    //================================================================================ 
    // Getters and Setters  
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public EmpInstitucionKey getId() {
        return id;
    }
    public void setId(EmpInstitucionKey id) {
        this.id = id;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getArchivo() {
        return archivo;
    }
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    public Institucion getInstitucion() {
        return institucion;
    }
    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }    
    //==============================================================================//
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        EmpInstitucion other = (EmpInstitucion) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

    
}
