/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.beans;

import com.matoosfe.unomina.beans.util.AbstractManagedBean;
import com.matoosfe.unomina.controllers.NomCargoFacade;
import com.matoosfe.unomina.controllers.NomEmpleadoFacade;
import com.matoosfe.unomina.controllers.NomSucursalFacade;
import com.matoosfe.unomina.entities.NomCargo;
import com.matoosfe.unomina.entities.NomDepartamento;
import com.matoosfe.unomina.entities.NomEmpleado;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author martosfre
 */
@Named
@SessionScoped
public class EmpleadoBean extends AbstractManagedBean implements Serializable {

    private NomEmpleado empleado;
    private NomEmpleado empleadoSel;
    private List<NomEmpleado> listaEmpleados;

    private List<SelectItem> listaSucursales;
    private Integer idSuc;
    private List<SelectItem> listaDepartamentos;
    private Integer idDep;

    private List<NomCargo> listaCargos;
    private String fotoIncognita;
    private StreamedContent fotoBinario;

    @Inject
    private NomSucursalFacade adminSucursal;
    @Inject
    private NomCargoFacade adminCargo;
    @Inject
    private NomEmpleadoFacade adminEmpleado;

    public EmpleadoBean() {
        this.empleado = new NomEmpleado();
        this.listaSucursales = new ArrayList<>();
        this.listaDepartamentos = new ArrayList<>();
        this.listaCargos = new ArrayList<>();
        this.fotoIncognita = "/resources/img/usuarioAnonimo.webp";
    }

    public NomEmpleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(NomEmpleado empleado) {
        this.empleado = empleado;
    }

    public NomEmpleado getEmpleadoSel() {
        return empleadoSel;
    }

    public void setEmpleadoSel(NomEmpleado empleadoSel) {
        this.empleadoSel = empleadoSel;
    }

    public List<NomEmpleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<NomEmpleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<SelectItem> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<SelectItem> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<SelectItem> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(List<SelectItem> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public Integer getIdSuc() {
        return idSuc;
    }

    public void setIdSuc(Integer idSuc) {
        this.idSuc = idSuc;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public List<NomCargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<NomCargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public String getFotoIncognita() {
        return fotoIncognita;
    }

    public void setFotoIncognita(String fotoIncognita) {
        this.fotoIncognita = fotoIncognita;
    }

    public StreamedContent getFotoBinario() {
        return fotoBinario;
    }

    public void setFotoBinario(StreamedContent fotoBinario) {
        this.fotoBinario = fotoBinario;
    }

    /**
     * Método para cargar las sucursales
     */
    private void cargarSucursales() {
        adminSucursal.consultarTodos().forEach(suc -> this.listaSucursales
                .add(new SelectItem(suc.getSucId(), suc.getSucNombre())));
    }

    /**
     * Método para cargar los cargos
     */
    private void cargarCargos() {
        this.listaCargos = adminCargo.consultarTodos();
    }

    /**
     * Método para cargar los departamentos por sucursal
     */
    public void cargarDepartamentosPorSucursal() {
        this.listaDepartamentos.clear();
        adminSucursal.consultarDepartamentosPorSucursal(idSuc).forEach(dep -> this.listaDepartamentos
                .add(new SelectItem(dep.getDepaId(), dep.getDepaNombre())));
    }

    /**
     * Método para guardar o actualizar
     */
    public void guardar() {
        try {
            NomDepartamento deparTmp = new NomDepartamento(idDep);
            this.empleado.setDepaId(deparTmp);
            if (empleado.getEmpId() != null) {
                //Actualizar
                adminEmpleado.actualizar(empleado);
                anadirInfo("Empleado actualizado correctamente");
            } else {
                //Guardar
                adminEmpleado.guardar(empleado);
                anadirInfo("Empleado guardado correctamente");
            }
            cargarCargos();
            resetearFormulario();
        } catch (Exception e) {
            anadirError("Error al procesar la operación:" + e.getMessage());
        }
    }

    /**
     * Método para resetear el formulario
     */
    public void resetearFormulario() {
        this.empleado = new NomEmpleado();
        this.empleadoSel = null; //No selección
    }

    /**
     * Método para subir foto
     *
     * @param event
     */
    public void subirFoto(FileUploadEvent event) {
        InputStream fis = new ByteArrayInputStream(event.getFile().getContent());
        fotoBinario = DefaultStreamedContent.builder().stream(() -> fis).build();
        this.empleado.setEmplFoto(event.getFile().getContent());
    }

    @PostConstruct
    public void inicializar() {
        cargarSucursales();
        cargarCargos();
    }
}
