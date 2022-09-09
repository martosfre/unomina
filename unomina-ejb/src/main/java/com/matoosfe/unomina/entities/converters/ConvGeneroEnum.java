/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.entities.converters;

import com.matoosfe.unomina.entities.util.EnumGenero;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Convertidor para tipo de dato personalizado de genero, enumerado
 *
 * @author martosfre
 */
@Converter
public class ConvGeneroEnum implements AttributeConverter<EnumGenero, String> {

    @Override
    public String convertToDatabaseColumn(EnumGenero genero) {
        return genero.getValor();
    }

    @Override
    public EnumGenero convertToEntityAttribute(String generoBdd) {
        try {
            EnumGenero genero = null;
            for (EnumGenero enumGen : EnumGenero.values()) {
                if (enumGen.getValor().equals(generoBdd)) {
                    genero = enumGen;
                    break;
                }
            }
            return genero;
        } catch (Exception e) {
            return null;
        }
    }
}
