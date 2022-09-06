/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named; //CDI

/**
 *
 * @author martosfre
 */
@Named
@SessionScoped
public class LoginBean implements Serializable{
    private String nombreUsu;
    private String claveUsu;

    public LoginBean() {
        this.nombreUsu = "admin";
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getClaveUsu() {
        return claveUsu;
    }

    public void setClaveUsu(String claveUsu) {
        this.claveUsu = claveUsu;
    }
    
    /**
     * Método para validar el usuario
     * @return 
     */
    public String validarUsuario(){
        if(nombreUsu.equals("admin") && claveUsu.equals("1234")){
            return "principal"; //Regla de navegación
        }else{
            FacesMessage mensaje = new FacesMessage();
            mensaje.setSummary("Credenciales Incorrectas");
            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            
            return null; //Ir a la misma página
        }
        
    }
    
}
