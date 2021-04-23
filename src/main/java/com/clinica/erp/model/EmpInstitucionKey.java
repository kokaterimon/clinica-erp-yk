package com.clinica.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpInstitucionKey implements Serializable {
    
    @Column(name = "idInstitucion")
    Integer idInstitucion;

    @Column(name = "idEmpleado")
    Integer idEmpleado;

    public  EmpInstitucionKey() {

    }

    public EmpInstitucionKey(Integer idInstitucion, Integer idEmpleado) {
        this.idInstitucion = idInstitucion;
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    
}
