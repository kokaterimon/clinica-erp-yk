package com.clinica.erpapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empinstitucion")
public class EmpInstitucion {
    
    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpInstitucion")
    private long idEmpInstitucion;
    
    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Column(name = "fechaFin")
    private Date fechaFin;

    @Column(name = "archivo")
    private String archivo;
    //==============================================================================// 

    //================================================================================ 
    // Relations
    @ManyToOne
    @JoinColumn(name = "idInstitucion")
    private Institucion institucion;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;
    //==============================================================================//

    //================================================================================ 
    // Getters and Setters
    public long getIdEmpInstitucion() {
        return idEmpInstitucion;
    }
    public void setIdEmpInstitucion(long idEmpInstitucion) {
        this.idEmpInstitucion = idEmpInstitucion;
    }
    public Date getFechaInicio() {
        return fechaInicio;
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
        result = prime * result + (int) (idEmpInstitucion ^ (idEmpInstitucion >>> 32));
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
        if (idEmpInstitucion != other.idEmpInstitucion)
            return false;
        return true;
    }

    
    

    
}
