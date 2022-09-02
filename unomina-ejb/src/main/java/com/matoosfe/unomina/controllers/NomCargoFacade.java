/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.controllers;

import com.matoosfe.unomina.entities.NomCargo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author martosfre
 */
@Stateless
public class NomCargoFacade extends AbstractFacade<NomCargo> {

    //Especificando cual es la unidad de persistencia (toda la configuración de la bdd)
    @PersistenceContext(unitName = "unominaPU")
    private EntityManager em; //Manejador 

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NomCargoFacade() {
        super(NomCargo.class); //Tabla con la cual va a operar: Clase es la tabla y el new NomCargo() -> registro
    }
    
}
