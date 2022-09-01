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
@Table(name = "nom_empresa")
@NamedQueries({
    @NamedQuery(name = "NomEmpresa.findAll", query = "SELECT n FROM NomEmpresa n"),
    @NamedQuery(name = "NomEmpresa.findByEmprId", query = "SELECT n FROM NomEmpresa n WHERE n.emprId = :emprId"),
    @NamedQuery(name = "NomEmpresa.findByEmprRuc", query = "SELECT n FROM NomEmpresa n WHERE n.emprRuc = :emprRuc"),
    @NamedQuery(name = "NomEmpresa.findByEmprRazonSocial", query = "SELECT n FROM NomEmpresa n WHERE n.emprRazonSocial = :emprRazonSocial"),
    @NamedQuery(name = "NomEmpresa.findByEmprNombreComercial", query = "SELECT n FROM NomEmpresa n WHERE n.emprNombreComercial = :emprNombreComercial")})
public class NomEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empr_id")
    private Integer emprId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "empr_ruc")
    private String emprRuc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "empr_razon_social")
    private String emprRazonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "empr_nombre_comercial")
    private String emprNombreComercial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emprId")
    private List<NomSucursal> nomSucursalList;

    public NomEmpresa() {
    }

    public NomEmpresa(Integer emprId) {
        this.emprId = emprId;
    }

    public NomEmpresa(Integer emprId, String emprRuc, String emprRazonSocial, String emprNombreComercial) {
        this.emprId = emprId;
        this.emprRuc = emprRuc;
        this.emprRazonSocial = emprRazonSocial;
        this.emprNombreComercial = emprNombreComercial;
    }

    public Integer getEmprId() {
        return emprId;
    }

    public void setEmprId(Integer emprId) {
        this.emprId = emprId;
    }

    public String getEmprRuc() {
        return emprRuc;
    }

    public void setEmprRuc(String emprRuc) {
        this.emprRuc = emprRuc;
    }

    public String getEmprRazonSocial() {
        return emprRazonSocial;
    }

    public void setEmprRazonSocial(String emprRazonSocial) {
        this.emprRazonSocial = emprRazonSocial;
    }

    public String getEmprNombreComercial() {
        return emprNombreComercial;
    }

    public void setEmprNombreComercial(String emprNombreComercial) {
        this.emprNombreComercial = emprNombreComercial;
    }

    public List<NomSucursal> getNomSucursalList() {
        return nomSucursalList;
    }

    public void setNomSucursalList(List<NomSucursal> nomSucursalList) {
        this.nomSucursalList = nomSucursalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emprId != null ? emprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NomEmpresa)) {
            return false;
        }
        NomEmpresa other = (NomEmpresa) object;
        if ((this.emprId == null && other.emprId != null) || (this.emprId != null && !this.emprId.equals(other.emprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matoosfe.unomina.entities.NomEmpresa[ emprId=" + emprId + " ]";
    }
    
}
