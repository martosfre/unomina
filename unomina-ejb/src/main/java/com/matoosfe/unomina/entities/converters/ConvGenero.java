/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.entities.converters;

import java.sql.SQLException;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.postgresql.util.PGobject;

/**
 * Convertidor para tipo de dato personalizado de genero, enumerado
 *
 * @author martosfre
 */
@Converter
public class ConvGenero implements AttributeConverter<String, PGobject> {

    @Override
    public PGobject convertToDatabaseColumn(String genero) {
        try {
            PGobject po = new PGobject();
            po.setType("genero");
            po.setValue(genero);
            return po;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public String convertToEntityAttribute(PGobject po) {
        try {
            return po.getValue();
        } catch (Exception e) {
            return null;
        }
    }
}
