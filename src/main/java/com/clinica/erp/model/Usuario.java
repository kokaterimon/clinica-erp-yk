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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario {

    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "contrasenaUsuario")
    private String contrasenaUsuario;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "emailUsuario")
    private String emailUsuario;

    @Column(name = "idEmpleado")
    private Integer idEmpleado;
    // ==============================================================================//

    // ================================================================================
    // Relations
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idEmpleado", insertable = false, updatable = false)
    private Empleado empleado;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "usuario_roles", joinColumns = { @JoinColumn(name = "idUsuario") }, inverseJoinColumns = {
            @JoinColumn(name = "idRolSistema") })
    private Set<RolSistema> roles;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private Set<TerminalVenta> terminalesVenta = new HashSet<>();
    // ==============================================================================//

    // ================================================================================
    // Getters and Setters
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
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
    public Set<TerminalVenta> getTerminalesVenta() {
        return terminalesVenta;
    }
    public void setTerminalesVenta(Set<TerminalVenta> terminalesVenta) {
        this.terminalesVenta = terminalesVenta;
    }
    public Set<RolSistema> getRoles() {
        return roles;
    }
    public void setRoles(Set<RolSistema> roles) {
        this.roles = roles;
    }
        public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }
    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }
    public Integer getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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
