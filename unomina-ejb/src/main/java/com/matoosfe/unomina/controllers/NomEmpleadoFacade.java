/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.controllers;

import com.matoosfe.unomina.entities.NomEmpleado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase para administrar las operaciones de empleado
 * @author martosfre
 */
@Stateless
public class NomEmpleadoFacade extends AbstractFacade<NomEmpleado> {
    
    @PersistenceContext(unitName = "unominaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NomEmpleadoFacade() {
        super(NomEmpleado.class); //Llamando al constructor de la clase padre
    }
    
    
    
}
