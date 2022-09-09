/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.controllers;

import com.matoosfe.unomina.entities.NomEmpleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Clase para administrar las operaciones de empleado
 *
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

    /**
     * Método para buscar empleados por su identificación o apellido o una parte
     *
     * @param identificacionApellido
     * @return
     */
    public List<NomEmpleado> buscarEmpleados(String identificacionApellido) {
//        TypedQuery<NomEmpleado> conEmp =  em.createQuery("Select  emp from NomEmpleado emp"
//                + " where emp.emplIdentificacion like :valorBusqueda or "
//                + " emp.emplApellidoPaterno like :valorBusqueda", NomEmpleado.class);
//        TypedQuery<NomEmpleado> conEmp =  em.createQuery(""
//                + "Select new com.matoosfe.unomina.entities.NomEmpleado(emp.empId,"
//                + " emp.emplNombres, emp.emplApellidoPaterno, emp.emplApellidoMaterno,"
//                + " emp.emplIdentificacion, emp.emplFechaIngreso,\n" +
//"                   emp.emplFechaSalida, emp.emplFoto, emp.cargId, emp.depaId) "
//                + " from NomEmpleado emp"
//                + " where emp.emplIdentificacion like :valorBusqueda or "
//                + " emp.emplApellidoPaterno like :valorBusqueda", NomEmpleado.class);
//        TypedQuery<NomEmpleado> conEmp =  em.createQuery("Select emp from NomEmpleado emp"
//                + " where emp.emplIdentificacion like :valorBusqueda or "
//                + " emp.emplApellidoPaterno like :valorBusqueda", NomEmpleado.class);
        Query conEmp = em.createNativeQuery("select ne.* \n"
                + "from nom_empleado ne \n"
                + "where (ne.empl_identificacion like ?1 or \n"
                + "       ne.empl_apellido_paterno like ?2)", NomEmpleado.class);
        if (identificacionApellido.equals("")) {
//            conEmp.setParameter("valorBusqueda", "%%");
            conEmp.setParameter(1, "%%");
            conEmp.setParameter(2, "%%");

        } else {
//            conEmp.setParameter("valorBusqueda", "%" + identificacionApellido + "%");
            conEmp.setParameter(1, "%" + identificacionApellido + "%");
            conEmp.setParameter(2, "%" + identificacionApellido + "%");
        }

        return conEmp.getResultList();
    }

}
