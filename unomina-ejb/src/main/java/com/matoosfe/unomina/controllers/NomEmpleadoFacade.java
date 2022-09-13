/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.controllers;

import com.matoosfe.unomina.entities.NomCargo;
import com.matoosfe.unomina.entities.NomDepartamento;
import com.matoosfe.unomina.entities.NomEmpleado;
import com.matoosfe.unomina.entities.util.EnumGenero;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase para administrar las operaciones de empleado
 *
 * @author martosfre
 */
//@TransactionManagement(TransactionManagementType.BEAN) //Tx Manual
@TransactionManagement(TransactionManagementType.CONTAINER) //Tx Automático, por defecto
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

    public void guardarCargoEmpleadoTx() {
        NomCargo cargo = new NomCargo();
        cargo.setCargNombre("CargoTx");
        cargo.setCargDescripcion("Cargo TX Descripción");
        em.persist(cargo);

        NomDepartamento departamento = new NomDepartamento(1);
        crearEmpleado(cargo, departamento);
    }

    //Comit y si falla se hace rollback
    private void crearEmpleado(NomCargo cargo, NomDepartamento departamento) {
        NomEmpleado empleado = new NomEmpleado();
        empleado.setCargId(cargo);
        empleado.setDepaId(departamento);
        empleado.setEmplNombres("Evelyn Maritza");
        empleado.setEmplApellidoPaterno("Ruíz");
        empleado.setEmplApellidoMaterno("Cruz");
        empleado.setEmplGenero(EnumGenero.FEMENINO.getValor());
        empleado.setEmplIdentificacion("1715234126");
        empleado.setEmplFechaIngreso(new Date());

        em.persist(empleado);
    }

    public void guardarCargoEmpleadoTxManual() {
        try {
            em.getTransaction().begin();
            NomCargo cargo = new NomCargo();
            cargo.setCargNombre("CargoTx");
            cargo.setCargDescripcion("Cargo TX Descripción");
            em.persist(cargo);

            NomDepartamento departamento = new NomDepartamento(1);
            crearEmpleado(cargo, departamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

}
