/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author martosfre
 */
@Entity
@Table(name = "nom_cargo")
@NamedQueries({
    @NamedQuery(name = "NomCargo.findAll", query = "SELECT n FROM NomCargo n"),
    @NamedQuery(name = "NomCargo.findByCargId", query = "SELECT n FROM NomCargo n WHERE n.cargId = :cargId"),
    @NamedQuery(name = "NomCargo.findByCargNombre", query = "SELECT n FROM NomCargo n WHERE n.cargNombre = :cargNombre"),
    @NamedQuery(name = "NomCargo.findByCargDescripcion", query = "SELECT n FROM NomCargo n WHERE n.cargDescripcion = :cargDescripcion")})
public class NomCargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carg_id")
    private Integer cargId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "carg_nombre")
    private String cargNombre;
    @Size(max = 300)
    @Column(name = "carg_descripcion")
    private String cargDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargId")
    private List<NomEmpleado> nomEmpleadoList;

    public NomCargo() {
    }

    public NomCargo(Integer cargId) {
        this.cargId = cargId;
    }

    public NomCargo(Integer cargId, String cargNombre) {
        this.cargId = cargId;
        this.cargNombre = cargNombre;
    }

    public Integer getCargId() {
        return cargId;
    }

    public void setCargId(Integer cargId) {
        this.cargId = cargId;
    }

    public String getCargNombre() {
        return cargNombre;
    }

    public void setCargNombre(String cargNombre) {
        this.cargNombre = cargNombre;
    }

    public String getCargDescripcion() {
        return cargDescripcion;
    }

    public void setCargDescripcion(String cargDescripcion) {
        this.cargDescripcion = cargDescripcion;
    }

    public List<NomEmpleado> getNomEmpleadoList() {
        return nomEmpleadoList;
    }

    public void setNomEmpleadoList(List<NomEmpleado> nomEmpleadoList) {
        this.nomEmpleadoList = nomEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargId != null ? cargId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NomCargo)) {
            return false;
        }
        NomCargo other = (NomCargo) object;
        if ((this.cargId == null && other.cargId != null) || (this.cargId != null && !this.cargId.equals(other.cargId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matoosfe.unomina.entities.NomCargo[ cargId=" + cargId + " ]";
    }
    
}
