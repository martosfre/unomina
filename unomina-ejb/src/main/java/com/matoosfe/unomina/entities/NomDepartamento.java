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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author martosfre
 */
@XmlRootElement
@Entity
@Table(name = "nom_departamento")
@NamedQueries({
    @NamedQuery(name = "NomDepartamento.findAll", query = "SELECT n FROM NomDepartamento n"),
    @NamedQuery(name = "NomDepartamento.findByDepaId", query = "SELECT n FROM NomDepartamento n WHERE n.depaId = :depaId"),
    @NamedQuery(name = "NomDepartamento.findByDepaNombre", query = "SELECT n FROM NomDepartamento n WHERE n.depaNombre = :depaNombre"),
    @NamedQuery(name = "NomDepartamento.findByDepaDescripcion", query = "SELECT n FROM NomDepartamento n WHERE n.depaDescripcion = :depaDescripcion")})
public class NomDepartamento implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "depa_nombre")
    private String depaNombre;
    @Size(max = 300)
    @Column(name = "depa_descripcion")
    private String depaDescripcion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "depa_id")
    private Integer depaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depaId")
    private List<NomEmpleado> nomEmpleadoList;
    @JoinColumn(name = "suc_id", referencedColumnName = "suc_id")
    @ManyToOne(optional = false)
    private NomSucursal sucId;

    public NomDepartamento() {
    }

    public NomDepartamento(Integer depaId) {
        this.depaId = depaId;
    }

    public NomDepartamento(Integer depaId, String depaNombre) {
        this.depaId = depaId;
        this.depaNombre = depaNombre;
    }

    public Integer getDepaId() {
        return depaId;
    }

    public void setDepaId(Integer depaId) {
        this.depaId = depaId;
    }

    public String getDepaNombre() {
        return depaNombre;
    }

    public void setDepaNombre(String depaNombre) {
        this.depaNombre = depaNombre;
    }

    public String getDepaDescripcion() {
        return depaDescripcion;
    }

    public void setDepaDescripcion(String depaDescripcion) {
        this.depaDescripcion = depaDescripcion;
    }
    @XmlTransient
    public List<NomEmpleado> getNomEmpleadoList() {
        return nomEmpleadoList;
    }

    public void setNomEmpleadoList(List<NomEmpleado> nomEmpleadoList) {
        this.nomEmpleadoList = nomEmpleadoList;
    }

    public NomSucursal getSucId() {
        return sucId;
    }

    public void setSucId(NomSucursal sucId) {
        this.sucId = sucId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depaId != null ? depaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NomDepartamento)) {
            return false;
        }
        NomDepartamento other = (NomDepartamento) object;
        if ((this.depaId == null && other.depaId != null) || (this.depaId != null && !this.depaId.equals(other.depaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matoosfe.unomina.entities.NomDepartamento[ depaId=" + depaId + " ]";
    }
    
}
