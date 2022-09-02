/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.controllers;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author martosfre
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass; //Tabla

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    //Este método será implementado de manera obligatoria en las clases  hijas
    protected abstract EntityManager getEntityManager();

    /**
     * Método para guardar una entidad (registro)
     * @param entity 
     */
    public void guardar(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     * Método para actualizar una entidad
     * @param entity 
     */
    public void actualizar(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * Método para eliminar una entidad
     * @param entity 
     */
    public void eliminar(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Método para consultar por su identificador
     * @param id
     * @return 
     */
    public T consultarPorId(Object id) {
        return getEntityManager().find(entityClass, id); //Clase (Tablas), id (PK)
    }

    /**
     * Métdoo para consultar todos, el tipo de consulta es usando CRITERIA API
     * @return 
     */
    public List<T> consultarTodos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList(); //Devolver más de un registro (List)
    }

    /**
     * Método para consultar por rango
     * @param range
     * @return 
     */
    public List<T> consultarPorRango(int[] range) { //5 [0]- 10[1] 
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1); //Máximo de resultados: 10 -  5 + 1 = 6
        q.setFirstResult(range[0]); //5
        return q.getResultList();
    }

    /**
     * Método para cpntar los registros de una tabla
     * @return 
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
