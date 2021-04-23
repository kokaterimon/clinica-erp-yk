package com.clinica.erp.model;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "empleado")
public class Empleado {
    //================================================================================ 
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")
    private Integer idEmpleado;

    @Column(name = "dni")
    private String dni;
    
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

    @Column(name = "fechaNacimiento")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date fechaNacimiento;

    @Column(name = "fechaInicio")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date fechaInicio;

    @Column(name = "fechaFin")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date fechaFin;

    @Column(name = "estado")
    private String estado;

    //==============================================================================// 
    

    //================================================================================ 
    // Relations  
    @ManyToOne
    @JoinColumn(name = "idDistrito")
    @JsonIgnore
    private Distrito distrito;

    @OneToMany(mappedBy = "empleado")
    private Set<EmpInstitucion> empInstituciones = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="emp_area", 
                joinColumns={@JoinColumn(name="idEmpleado")}, 
                inverseJoinColumns={@JoinColumn(name="idArea")})
    private Set<Area> areas;   

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name="emp_institucion", 
                joinColumns={@JoinColumn(name="idEmpleado")}, 
                inverseJoinColumns={@JoinColumn(name="idInstitucion")})
    private Set<Institucion> instituciones;   

    @OneToMany(mappedBy = "empleado")
    @JsonIgnore
    private Set<Usuario> usuarios = new HashSet<>();

    @OneToMany(mappedBy = "empleado")
    @JsonIgnore
    private Set<Horario> horarios = new HashSet<>();
    //==============================================================================// 
    
    
    //================================================================================ 
    // Getters and Setters
    public Integer getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
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
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set<EmpInstitucion> getEmpInstituciones() {
        return empInstituciones;
    }
    public void setEmpInstituciones(Set<EmpInstitucion> empInstituciones) {
        this.empInstituciones = empInstituciones;
    }
    public Set<Area> getAreas() {
        return areas;
    }
    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }
    public Set<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public Distrito getDistrito() {
        return distrito;
    }
    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    public Set<Institucion> getInstituciones() {
        return instituciones;
    }
    public void setInstituciones(Set<Institucion> instituciones) {
        this.instituciones = instituciones;
    }
    public Set<Horario> getHorarios() {
        return horarios;
    }
    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
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
