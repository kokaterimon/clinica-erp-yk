package com.clinica.erp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente")
public class Cliente {

    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Integer idCliente;

    @Column(name = "tipoCliente")// 1 cliente natural, 2 cliente juridico
    private int tipoCliente;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;
    // ==============================================================================//


    // ================================================================================
    // Relations
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private Set<Venta> ventas = new HashSet<>();
    // ==============================================================================//


    // ================================================================================
    // Getters and Setters
    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public int getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Venta> getVentas() {
        return ventas;
    }
    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }
    // ==============================================================================//
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idCliente ^ (idCliente >>> 32));
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
        Cliente other = (Cliente) obj;
        if (idCliente != other.idCliente)
            return false;
        return true;
    }
    

    
}
