/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.converters;

import com.matoosfe.unomina.controllers.NomCargoFacade;
import com.matoosfe.unomina.entities.NomCargo;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author martosfre
 */
@Named("convCargo")
@RequestScoped
public class ConvCargo implements Converter<NomCargo>{

    @Inject
    private NomCargoFacade adminCargo;
    
    //Viene de la pantalla
    @Override
    public NomCargo getAsObject(FacesContext fc, UIComponent uic, String valorPantalla) {
       NomCargo cargo = null;
       if(valorPantalla != null){
           cargo = adminCargo.consultarPorId(Integer.parseInt(valorPantalla));
       }
       return cargo;
    }

    //Viene de la bdd
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, NomCargo valorBdd) {
        String idCargo = "";
        if(valorBdd != null){
            idCargo = valorBdd.getCargId().toString();
        }
        return idCargo;
    }
    
    
}
