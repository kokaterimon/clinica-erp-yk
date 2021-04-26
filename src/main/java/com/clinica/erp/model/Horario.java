package com.clinica.erp.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "horario")
public class Horario {
    
    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHorario")
    private Integer idHorario;
    
    @Column(name = "diaInicio")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date diaInicio;

    @Column(name = "diaFin")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date diaFin;

    @Column(name = "horaEntrada")
    private Time horaEntrada;

    @Column(name = "horaSalida")
    private Time horaSalida;

    @Column(name = "idEmpleado")
    private Integer idEmpleado;
    //==============================================================================// 



    //================================================================================ 
    // Relations
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idEmpleado", insertable = false,updatable = false)
    private Empleado empleado;
    //==============================================================================//


    //================================================================================ 
    // Getters and Setters
    public Integer getIdHorario() {
        return idHorario;
    }
    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }
    public Date getDiaInicio() {
        return diaInicio;
    }
    public void setDiaInicio(Date diaInicio) {
        this.diaInicio = diaInicio;
    }
    public Date getDiaFin() {
        return diaFin;
    }
    public void setDiaFin(Date diaFin) {
        this.diaFin = diaFin;
    }
    public Time getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public Time getHoraSalida() {
        return horaSalida;
    }
    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }   
    public Integer getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    //==============================================================================//
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idHorario ^ (idHorario >>> 32));
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
        Horario other = (Horario) obj;
        if (idHorario != other.idHorario)
            return false;
        return true;
    }

}
