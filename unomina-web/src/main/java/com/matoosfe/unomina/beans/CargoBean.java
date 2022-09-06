/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.beans;

import com.matoosfe.unomina.beans.util.AbstractManagedBean;
import com.matoosfe.unomina.controllers.NomCargoFacade;
import com.matoosfe.unomina.entities.NomCargo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author martosfre
 */
@Named
@ViewScoped
public class CargoBean extends AbstractManagedBean implements Serializable {

    private NomCargo cargo; // Guardar o Actualizar
    private NomCargo cargoSel; //Selecccionar el cargo desde la tabla
    private List<NomCargo> listaCargos; //Desplegar los cargos en la tabla

    @Inject //Luego del constructor
    private NomCargoFacade adminCargo;

    public CargoBean() {
        this.cargo = new NomCargo(); //Encerando un registro de la tabla
        this.listaCargos = new ArrayList<>(); //Encerando la lista
    }

    public NomCargo getCargo() {
        return cargo;
    }

    public void setCargo(NomCargo cargo) {
        this.cargo = cargo;
    }

    public NomCargo getCargoSel() {
        return cargoSel;
    }

    public void setCargoSel(NomCargo cargoSel) {
        this.cargoSel = cargoSel;
    }

    public List<NomCargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<NomCargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    /**
     * Método para guardar o actualizar
     */
    public void guardar() {
        try {
            if (cargo.getCargId() != null) {
                //Actualizar
                adminCargo.actualizar(cargo);
                anadirInfo("Cargo actualizado correctamente");
            } else {
                //Guardar
                adminCargo.guardar(cargo);
                anadirInfo("Cargo guardado correctamente");
            }
            cargarCargos();
            resetearFormulario();
        } catch (Exception e) {
            anadirError("Error al procesar la operación:" + e.getMessage());
        }
    }

    /**
     * Método para cargar los cargos
     */
    private void cargarCargos() {
        this.listaCargos = adminCargo.consultarTodos();
    }

    /**
     * Método para seleccionar un cargo
     *
     * @param ev
     */
    public void seleccionarFila(SelectEvent<NomCargo> ev) {
        this.cargoSel = ev.getObject();
    }

    /**
     * Método para cargar el cargo seleccionado
     */
    public void editar() {
        if (cargoSel != null) {
            this.cargo = cargoSel;
        } else {
            anadirError("Se debe seleccionar un cargo");
        }
    }

    /**
     * Método para eliminar un cargo
     */
    public void eliminar() {
        try {
            if (cargoSel != null) {
                adminCargo.eliminar(cargoSel);
                cargarCargos();
                resetearFormulario();
            } else {
                anadirError("Se debe seleccionar un cargo");
            }
        } catch (Exception e) {
            anadirError("Error al eliminar:" + e.getMessage());
        }
    }

    /**
     * Método para resetear el formulario
     */
    public void resetearFormulario() {
        this.cargo = new NomCargo();
        this.cargoSel = null; //No selección
    }

    /**
     * Método para inicializar el formulario
     */
    @PostConstruct
    public void inicializar() {
        cargarCargos();
    }

}
