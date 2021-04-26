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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "servicio")
public class Servicio {

    // ================================================================================
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio")
    private Integer idServicio;

    @Column(name = "nombreServicio")
    private String nombreServicio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precioReferencia")
    private String precioReferencia;

    @Column(name = "precio")
    private String precio;

    @Column(name = "tiempoProceso")
    private String tiempoProceso;
    
    @Column(name = "idTipoServio")
    private Integer idTipoServio;

    @Column(name = "idMuestra")
    private Integer idMuestra;

    @Column(name = "idTiempoProc")
    private Integer idTiempoProc;
    // ==============================================================================//

    // ================================================================================
    // Relations
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idTipoServio", insertable = false,updatable = false)
    private TipoServicio tipoServicio;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idMuestra", insertable = false,updatable = false)
    private Muestra muestra;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idTiempoProc", insertable = false,updatable = false)
    private TiempoProceso tiempoProc;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private Set<DetalleVenta> detallesVenta = new HashSet<>();
    // ==============================================================================//
    
    
    // ================================================================================
    // Getters and Setters
    public Integer getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }
    public String getNombreServicio() {
        return nombreServicio;
    }
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getPrecioReferencia() {
        return precioReferencia;
    }
    public void setPrecioReferencia(String precioReferencia) {
        this.precioReferencia = precioReferencia;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public String getTiempoProceso() {
        return tiempoProceso;
    }
    public void setTiempoProceso(String tiempoProceso) {
        this.tiempoProceso = tiempoProceso;
    }
    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    public Muestra getMuestra() {
        return muestra;
    }
    public void setMuestra(Muestra muestra) {
        this.muestra = muestra;
    }
    public TiempoProceso getTiempoProc() {
        return tiempoProc;
    }
    public void setTiempoProc(TiempoProceso tiempoProc) {
        this.tiempoProc = tiempoProc;
    }
    public Set<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }
    public void setDetallesVenta(Set<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }
    public Integer getIdTipoServio() {
        return idTipoServio;
    }
    public void setIdTipoServio(Integer idTipoServio) {
        this.idTipoServio = idTipoServio;
    }
    public Integer getIdMuestra() {
        return idMuestra;
    }
    public void setIdMuestra(Integer idMuestra) {
        this.idMuestra = idMuestra;
    }
    public Integer getIdTiempoProc() {
        return idTiempoProc;
    }
    public void setIdTiempoProc(Integer idTiempoProc) {
        this.idTiempoProc = idTiempoProc;
    }
    // ==============================================================================//
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idServicio ^ (idServicio >>> 32));
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
        Servicio other = (Servicio) obj;
        if (idServicio != other.idServicio)
            return false;
        return true;
    }
    
}
