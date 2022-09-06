/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.beans;

import com.matoosfe.unomina.entities.NomCargo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author martosfre
 */
@Named
@ViewScoped
public class CargoBean implements Serializable{
    private NomCargo cargo;
    private NomCargo cargoSel;
    private List<NomCargo> listaCargos;

    public CargoBean() {
        this.cargo = new NomCargo();
        this.listaCargos = new ArrayList<>();
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
     * Método para resetear el formulario
     */
    public void resetearFormulario(){
        this.cargo = new NomCargo();
        this.cargoSel = null;
    }
    
    /**
     * Método para inicializar el formulario
     */
    public void inicializar(){
        
    }
    
    
}
