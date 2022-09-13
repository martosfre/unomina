/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author martosfre
 */
@FacesValidator("valCorreo")
public class ValCorreo implements Validator<String>{

    @Override
    public void validate(FacesContext fc, UIComponent uic, String correo) throws ValidatorException {
        if(!correo.matches("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}")){
            FacesMessage mensaje = new FacesMessage("Correo no válido");
            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(mensaje);
        }
    }
    
}
