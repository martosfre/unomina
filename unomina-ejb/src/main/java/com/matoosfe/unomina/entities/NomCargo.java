/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Bean Validation - Especificación Java que establece constrainst
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author martosfre
 */
 // Obligatoria
@Entity
/* Opcional, se coloca cuando el nombre de la tabla es diferente a la nombre de la clase. 
   Permite identificar otros atributos como por ejemplo el schema que pertene, indexes y constraints
*/


@Table(name = "nom_cargo") 
//Opcional: Sirve para definir consultas generales que se realizan sobre la tabla con frecuencia.
@NamedQueries({
    @NamedQuery(name = "NomCargo.findAll", query = "SELECT n FROM NomCargo n"),
    @NamedQuery(name = "NomCargo.findByCargId", query = "SELECT n FROM NomCargo n WHERE n.cargId = :cargId"),
    @NamedQuery(name = "NomCargo.findByCargNombre", query = "SELECT n FROM NomCargo n WHERE n.cargNombre = :cargNombre"),
    @NamedQuery(name = "NomCargo.findByCargDescripcion", query = "SELECT n FROM NomCargo n WHERE n.cargDescripcion = :cargDescripcion")})
public class NomCargo implements Serializable { //Permite que el objeto con sus valores se trasmita de manera integra

    private static final long serialVersionUID = 1L;
    //Obligatorio: Especifica el atributo o propiedad que es la clave primaria (PK)
    @Id
    //Obligatorio para campos autogenerados: Especifica la manera de como se crea la clave primaria (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Opcional: Especifica a que columna de la tabla se va a mapear el atributo y se coloca cuando el nombre de la columna sea diferente al del atributo.
    @Column(name = "carg_id")
    private Integer cargId;
     //Opcional: Se especifica cuando el campo es requerida
    @Basic(optional = false)
    //Opcional: Especifica que el campo no sea nulo - Bean Validation
    @NotNull
    //Opcional: Especifica el tamaño del campo
    @Size(min = 1, max = 100)
    @Column(name = "carg_nombre")
    private String cargNombre;
    @Size(max = 300)
    @Column(name = "carg_descripcion")
    private String cargDescripcion;
    
    /*
        Relaciones JPA: Bidireccionales( Se mapea en las dos clases). Las relaciones se leen desde la clase
        1 a N -> @OneToMany - mappedBy:Representa el nombre del atributo en el otro lado de la relación.
        N a 1 -> @ManyToOne
        N a M -> @ManyToMany
    
    */
    @OneToMany(mappedBy = "cargId")
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
    
    // Determina cuales son los atributos utilizados para diferenciar un objeto de objeto
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

    //Método utilizado para sobreescribir la impresión de un objeto
    @Override
    public String toString() {
        return "com.matoosfe.unomina.entities.NomCargo[ cargId=" + cargId + " ]";
    }
    
}
