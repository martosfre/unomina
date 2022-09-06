/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.beans.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author martosfre
 */
public abstract class AbstractManagedBean {

    /**
     * Método para añadir un mensaje de información
     * @param mensaje 
     */
    public void anadirInfo(String mensaje) {
        anadirMensaje(mensaje, FacesMessage.SEVERITY_INFO);
    }

    /**
     * Método para añadir un mensaje de error
     * @param mensaje 
     */
    public void anadirError(String mensaje) {
        anadirMensaje(mensaje, FacesMessage.SEVERITY_ERROR);
    }

    /**
     * Método para añadir un mensaje
     * @param mensaje
     * @param severidad 
     */
    private void anadirMensaje(String mensaje, FacesMessage.Severity severidad) {
        FacesMessage mensajeJSF = new FacesMessage();
        mensajeJSF.setSummary(mensaje);
        mensajeJSF.setSeverity(severidad);
        FacesContext.getCurrentInstance().addMessage(null, mensajeJSF);
    }

}
