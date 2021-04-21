package com.clinica.erp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private long idUsuario;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "emailUsuario")
    private String emailUsuario;
    // ==============================================================================//

    // ================================================================================
    // Relations
    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "usuarioroles", joinColumns = { @JoinColumn(name = "idUsuario") }, inverseJoinColumns = {
            @JoinColumn(name = "idRolSistema") })
    private Set<RolSistema> rolSistemas;

    @OneToMany(mappedBy = "usuario")
    private Set<TerminalVenta> terminalesVenta = new HashSet<>();
    // ==============================================================================//


    //================================================================================ 
    // Getters and Setters
    public long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getEmailUsuario() {
        return emailUsuario;
    }
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Set<RolSistema> getRolSistemas() {
        return rolSistemas;
    }
    public void setRolSistemas(Set<RolSistema> rolSistemas) {
        this.rolSistemas = rolSistemas;
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
        result = prime * result + (int) (idUsuario ^ (idUsuario >>> 32));
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
        Usuario other = (Usuario) obj;
        if (idUsuario != other.idUsuario)
            return false;
        return true;
    }


    


}
