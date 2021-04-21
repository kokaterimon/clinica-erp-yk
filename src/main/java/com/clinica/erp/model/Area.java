package com.clinica.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class Area {
    
    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArea")
    private long idArea;

    @Column(name = "nombreArea")
    private String nombreArea;
    //==============================================================================// 


    //================================================================================ 
    // Relations
  /*  @ManyToMany(mappedBy = "area")
    private Set<Empleado> empleados = new HashSet<>();  */ 
    //==============================================================================// 


    //================================================================================ 
    // Getters and Setters
    public long getIdArea() {
        return idArea;
    }
    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }
    public String getNombreArea() {
        return nombreArea;
    }
    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
  /*  public Set<Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }*/
    //==============================================================================// 
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idArea ^ (idArea >>> 32));
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
        Area other = (Area) obj;
        if (idArea != other.idArea)
            return false;
        return true;
    }

    
    
}
