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

@Entity
@Table(name = "horario")
public class Horario {
    
    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHorario")
    private long idHorario;
    
    @Column(name = "diaInicio")
    private Date diaInicio;

    @Column(name = "diaFin")
    private Date diaFin;

    @Column(name = "horaEntrada")
    private Time horaEntrada;

    @Column(name = "horaSalida")
    private Time horaSalida;
    //==============================================================================// 



    //================================================================================ 
    // Relations
    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;
    //==============================================================================//


    //================================================================================ 
    // Getters and Setters
    public long getIdHorario() {
        return idHorario;
    }
    public void setIdHorario(long idHorario) {
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
