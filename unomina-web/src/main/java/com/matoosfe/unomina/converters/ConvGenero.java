/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.converters;

import com.matoosfe.unomina.entities.util.EnumGenero;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author martosfre
 */
@Named("convGen")
@RequestScoped
public class ConvGenero implements Converter<EnumGenero>{

    @Override
    public EnumGenero getAsObject(FacesContext fc, UIComponent uic, String valor) {
        EnumGenero enumGen =  null;
        if(valor != null){
          for(EnumGenero genero: EnumGenero.values()){
              if(genero.getValor().equals(valor)){
                  enumGen = genero;
                  break;
              }
          }
        }
        return enumGen;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, EnumGenero genero) {
       String valor = "";
       if(genero != null){
          valor = genero.getValor();
       }
       return valor;
    }
    
}
