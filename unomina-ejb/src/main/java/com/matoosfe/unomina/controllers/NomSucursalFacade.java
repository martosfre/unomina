package com.matoosfe.unomina.controllers;

import com.matoosfe.unomina.entities.NomDepartamento;
import com.matoosfe.unomina.entities.NomSucursal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Clase para administrar las operaciones de sucursaleas
 * @author martosfre
 */
@Stateless
public class NomSucursalFacade extends AbstractFacade<NomSucursal> {

    //Especificando cual es la unidad de persistencia (toda la configuración de la bdd)
    @PersistenceContext(unitName = "unominaPU")
    private EntityManager em; //Manejador de entidades

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NomSucursalFacade() {
        super(NomSucursal.class); //Tabla con la cual va a operar: Clase es la tabla y el new NomCargo() -> registro
    }
    
    /**
     * Método para consultar los departamentos por sucursal
     * @param idSuc
     * @return 
     */
    public List<NomDepartamento> consultarDepartamentosPorSucursal(int idSuc){
        TypedQuery<NomDepartamento> conDepSuc = em.createQuery("Select dep from NomDepartamento dep"
                + " where dep.sucId.sucId =:idSuc", NomDepartamento.class);
        conDepSuc.setParameter("idSuc", idSuc);
        return conDepSuc.getResultList();
    }
    
}
