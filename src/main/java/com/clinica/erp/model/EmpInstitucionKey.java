package com.clinica.erp.model;

import java.io.Serializable;

import javax.persistence.Column;

public class EmpInstitucionKey implements Serializable {
    @Column(name = "idInstitucion")
    Long idInstitucion;

    @Column(name = "idEmpleado")
    Long idEmpleado;
}
