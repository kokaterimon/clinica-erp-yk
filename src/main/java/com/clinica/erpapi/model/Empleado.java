package com.clinica.erpapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")
    private long idEmpleado;
    
    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "salario")
    private String salario;

    //==============================================================================// 
    
    //================================================================================ 
    // Relations
    @ManyToOne
    @JoinColumn(name = "idDistrito")
    private Distrito distrito;

    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="emparea", 
                joinColumns={@JoinColumn(name="idEmpleado")}, 
                inverseJoinColumns={@JoinColumn(name="idArea")})
    private Set<Area> areas;

    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="empeducacion", 
                joinColumns={@JoinColumn(name="idEmpleado")}, 
                inverseJoinColumns={@JoinColumn(name="idEducacion")})
    private Set<Educacion> educaciones;

    @OneToMany(mappedBy = "empleado")
    private Set<Usuario> usuarios = new HashSet<>();
    //==============================================================================// 

    //================================================================================ 
    // Getters and Setters
    public long getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getSalario() {
        return salario;
    }
    public void setSalario(String salario) {
        this.salario = salario;
    }
    public Distrito getDistrito() {
        return distrito;
    }
    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    public Set<Area> getAreas() {
        return areas;
    }
    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }
    public Set<Educacion> getEducaciones() {
        return educaciones;
    }
    public void setEducaciones(Set<Educacion> educaciones) {
        this.educaciones = educaciones;
    }
    public Set<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    //==============================================================================// 
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idEmpleado ^ (idEmpleado >>> 32));
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
        Empleado other = (Empleado) obj;
        if (idEmpleado != other.idEmpleado)
            return false;
        return true;
    }
    

    
}
