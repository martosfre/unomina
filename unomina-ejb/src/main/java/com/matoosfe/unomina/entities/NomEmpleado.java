/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author martosfre
 */
@Entity
@Table(name = "nom_empleado")
@NamedQueries({
    @NamedQuery(name = "NomEmpleado.findAll", query = "SELECT n FROM NomEmpleado n"),
    @NamedQuery(name = "NomEmpleado.findByEmpId", query = "SELECT n FROM NomEmpleado n WHERE n.empId = :empId"),
    @NamedQuery(name = "NomEmpleado.findByEmplNombres", query = "SELECT n FROM NomEmpleado n WHERE n.emplNombres = :emplNombres"),
    @NamedQuery(name = "NomEmpleado.findByEmplApellidoPaterno", query = "SELECT n FROM NomEmpleado n WHERE n.emplApellidoPaterno = :emplApellidoPaterno"),
    @NamedQuery(name = "NomEmpleado.findByEmplApellidoMaterno", query = "SELECT n FROM NomEmpleado n WHERE n.emplApellidoMaterno = :emplApellidoMaterno"),
    @NamedQuery(name = "NomEmpleado.findByEmplIdentificacion", query = "SELECT n FROM NomEmpleado n WHERE n.emplIdentificacion = :emplIdentificacion"),
    @NamedQuery(name = "NomEmpleado.findByEmplFechaIngreso", query = "SELECT n FROM NomEmpleado n WHERE n.emplFechaIngreso = :emplFechaIngreso"),
    @NamedQuery(name = "NomEmpleado.findByEmplFechaSalida", query = "SELECT n FROM NomEmpleado n WHERE n.emplFechaSalida = :emplFechaSalida"),
    @NamedQuery(name = "NomEmpleado.findByEmplFechaReingreso", query = "SELECT n FROM NomEmpleado n WHERE n.emplFechaReingreso = :emplFechaReingreso"),
    @NamedQuery(name = "NomEmpleado.findByEmplGenero", query = "SELECT n FROM NomEmpleado n WHERE n.emplGenero = :emplGenero")})
public class NomEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emp_id")
    private Integer empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "empl_nombres")
    private String emplNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "empl_apellido_paterno")
    private String emplApellidoPaterno;
    @Size(max = 25)
    @Column(name = "empl_apellido_materno")
    private String emplApellidoMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "empl_identificacion")
    private String emplIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empl_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date emplFechaIngreso;
    @Column(name = "empl_fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date emplFechaSalida;
    @Column(name = "empl_fecha_reingreso")
    @Temporal(TemporalType.DATE)
    private Date emplFechaReingreso;
    @Lob
    @Column(name = "empl_foto")
    private byte[] emplFoto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "empl_genero")
    private String emplGenero;
    @JoinColumn(name = "carg_id", referencedColumnName = "carg_id")
    @ManyToOne(optional = false)
    private NomCargo cargId;
    @JoinColumn(name = "depa_id", referencedColumnName = "depa_id")
    @ManyToOne(optional = false)
    private NomDepartamento depaId;

    public NomEmpleado() {
    }

    public NomEmpleado(Integer empId) {
        this.empId = empId;
    }

    public NomEmpleado(Integer empId, String emplNombres, String emplApellidoPaterno, String emplIdentificacion, Date emplFechaIngreso, String emplGenero) {
        this.empId = empId;
        this.emplNombres = emplNombres;
        this.emplApellidoPaterno = emplApellidoPaterno;
        this.emplIdentificacion = emplIdentificacion;
        this.emplFechaIngreso = emplFechaIngreso;
        this.emplGenero = emplGenero;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmplNombres() {
        return emplNombres;
    }

    public void setEmplNombres(String emplNombres) {
        this.emplNombres = emplNombres;
    }

    public String getEmplApellidoPaterno() {
        return emplApellidoPaterno;
    }

    public void setEmplApellidoPaterno(String emplApellidoPaterno) {
        this.emplApellidoPaterno = emplApellidoPaterno;
    }

    public String getEmplApellidoMaterno() {
        return emplApellidoMaterno;
    }

    public void setEmplApellidoMaterno(String emplApellidoMaterno) {
        this.emplApellidoMaterno = emplApellidoMaterno;
    }

    public String getEmplIdentificacion() {
        return emplIdentificacion;
    }

    public void setEmplIdentificacion(String emplIdentificacion) {
        this.emplIdentificacion = emplIdentificacion;
    }

    public Date getEmplFechaIngreso() {
        return emplFechaIngreso;
    }

    public void setEmplFechaIngreso(Date emplFechaIngreso) {
        this.emplFechaIngreso = emplFechaIngreso;
    }

    public Date getEmplFechaSalida() {
        return emplFechaSalida;
    }

    public void setEmplFechaSalida(Date emplFechaSalida) {
        this.emplFechaSalida = emplFechaSalida;
    }

    public Date getEmplFechaReingreso() {
        return emplFechaReingreso;
    }

    public void setEmplFechaReingreso(Date emplFechaReingreso) {
        this.emplFechaReingreso = emplFechaReingreso;
    }

    public byte[] getEmplFoto() {
        return emplFoto;
    }

    public void setEmplFoto(byte[] emplFoto) {
        this.emplFoto = emplFoto;
    }

    public String getEmplGenero() {
        return emplGenero;
    }

    public void setEmplGenero(String emplGenero) {
        this.emplGenero = emplGenero;
    }

    public NomCargo getCargId() {
        return cargId;
    }

    public void setCargId(NomCargo cargId) {
        this.cargId = cargId;
    }

    public NomDepartamento getDepaId() {
        return depaId;
    }

    public void setDepaId(NomDepartamento depaId) {
        this.depaId = depaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NomEmpleado)) {
            return false;
        }
        NomEmpleado other = (NomEmpleado) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matoosfe.unomina.entities.NomEmpleado[ empId=" + empId + " ]";
    }
    
}
