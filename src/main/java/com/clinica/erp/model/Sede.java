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
@Table(name = "sede")
public class Sede {

    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSede")
    private long idSede;

    @Column(name = "nombreSede")
    private String nombreSede;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;
    // ==============================================================================//

    // ================================================================================
    // Relations
    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "sede")
    private Set<TerminalVenta> terminalesVenta = new HashSet<>();
    // ==============================================================================//


    //================================================================================ 
    // Getters and Setters
    public long getIdSede() {
        return idSede;
    }
    public void setIdSede(long idSede) {
        this.idSede = idSede;
    }
    public String getNombreSede() {
        return nombreSede;
    }
    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public Set<TerminalVenta> getTerminalesVenta() {
        return terminalesVenta;
    }
    public void setTerminalesVenta(Set<TerminalVenta> terminalesVenta) {
        this.terminalesVenta = terminalesVenta;
    }
    // ==============================================================================//


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idSede ^ (idSede >>> 32));
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
        Sede other = (Sede) obj;
        if (idSede != other.idSede)
            return false;
        return true;
    }


    

    
    

}
