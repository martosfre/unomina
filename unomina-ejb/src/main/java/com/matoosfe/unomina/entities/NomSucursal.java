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
@Table(name = "nom_sucursal")
@NamedQueries({
    @NamedQuery(name = "NomSucursal.findAll", query = "SELECT n FROM NomSucursal n"),
    @NamedQuery(name = "NomSucursal.findBySucId", query = "SELECT n FROM NomSucursal n WHERE n.sucId = :sucId"),
    @NamedQuery(name = "NomSucursal.findBySucNombre", query = "SELECT n FROM NomSucursal n WHERE n.sucNombre = :sucNombre"),
    @NamedQuery(name = "NomSucursal.findBySucDireccion", query = "SELECT n FROM NomSucursal n WHERE n.sucDireccion = :sucDireccion"),
    @NamedQuery(name = "NomSucursal.findBySucTelefonoConv", query = "SELECT n FROM NomSucursal n WHERE n.sucTelefonoConv = :sucTelefonoConv"),
    @NamedQuery(name = "NomSucursal.findBySucCorreo", query = "SELECT n FROM NomSucursal n WHERE n.sucCorreo = :sucCorreo"),
    @NamedQuery(name = "NomSucursal.findByLocaId", query = "SELECT n FROM NomSucursal n WHERE n.locaId = :locaId")})
public class NomSucursal implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "suc_nombre")
    private String sucNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "suc_direccion")
    private String sucDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "suc_telefono_conv")
    private String sucTelefonoConv;
    @Size(max = 50)
    @Column(name = "suc_correo")
    private String sucCorreo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loca_id")
    private int locaId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "suc_id")
    private Integer sucId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucId")
    private List<NomDepartamento> nomDepartamentoList;
    @JoinColumn(name = "empr_id", referencedColumnName = "empr_id")
    @ManyToOne(optional = false)
    private NomEmpresa emprId;

    public NomSucursal() {
    }

    public NomSucursal(Integer sucId) {
        this.sucId = sucId;
    }

    public NomSucursal(Integer sucId, String sucNombre, String sucDireccion, String sucTelefonoConv, int locaId) {
        this.sucId = sucId;
        this.sucNombre = sucNombre;
        this.sucDireccion = sucDireccion;
        this.sucTelefonoConv = sucTelefonoConv;
        this.locaId = locaId;
    }

    public Integer getSucId() {
        return sucId;
    }

    public void setSucId(Integer sucId) {
        this.sucId = sucId;
    }

    public String getSucNombre() {
        return sucNombre;
    }

    public void setSucNombre(String sucNombre) {
        this.sucNombre = sucNombre;
    }

    public String getSucDireccion() {
        return sucDireccion;
    }

    public void setSucDireccion(String sucDireccion) {
        this.sucDireccion = sucDireccion;
    }

    public String getSucTelefonoConv() {
        return sucTelefonoConv;
    }

    public void setSucTelefonoConv(String sucTelefonoConv) {
        this.sucTelefonoConv = sucTelefonoConv;
    }

    public String getSucCorreo() {
        return sucCorreo;
    }

    public void setSucCorreo(String sucCorreo) {
        this.sucCorreo = sucCorreo;
    }

    public int getLocaId() {
        return locaId;
    }

    public void setLocaId(int locaId) {
        this.locaId = locaId;
    }
    @XmlTransient
    public List<NomDepartamento> getNomDepartamentoList() {
        return nomDepartamentoList;
    }

    public void setNomDepartamentoList(List<NomDepartamento> nomDepartamentoList) {
        this.nomDepartamentoList = nomDepartamentoList;
    }

    public NomEmpresa getEmprId() {
        return emprId;
    }

    public void setEmprId(NomEmpresa emprId) {
        this.emprId = emprId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sucId != null ? sucId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NomSucursal)) {
            return false;
        }
        NomSucursal other = (NomSucursal) object;
        if ((this.sucId == null && other.sucId != null) || (this.sucId != null && !this.sucId.equals(other.sucId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matoosfe.unomina.entities.NomSucursal[ sucId=" + sucId + " ]";
    }
}
