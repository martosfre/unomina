/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.matoosfe.unomina.entities.util;

/**
 *
 * @author martosfre
 */
public enum EnumGenero {
    MASCULINO("M"), FEMENINO("F"), INDEFINIDO("I");
    
    private String genero;
    
    private EnumGenero(String genero){
        this.genero = genero;
    }
    
    public String getValor(){
        return this.genero;
    }
}
