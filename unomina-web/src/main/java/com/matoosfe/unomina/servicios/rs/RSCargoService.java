/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.servicios.rs;

import com.matoosfe.unomina.controllers.NomCargoFacade;
import com.matoosfe.unomina.entities.NomCargo;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author martosfre
 */
@Path("cargo-rs")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class RSCargoService {

    @Inject
    private NomCargoFacade adminCargo;

    @POST
    @Path("/opeGua")
    public String guardar(NomCargo cargo) {
        try {
            adminCargo.guardar(cargo);
            return "Cargo guardado correctamente";
        } catch (Exception e) {
            return "Error al guardar el cargo:" + e.getMessage();
        }
    }

    @PUT
    public String actualizar(NomCargo cargo) {
        try {
            adminCargo.actualizar(cargo);
            return "Cargo actualizado correctamente";
        } catch (Exception e) {
            return "Error al actualizar el cargo:" + e.getMessage();
        }
    }

    @PATCH
    public String actualizarParcial(NomCargo cargo) {
        try {
            adminCargo.actualizar(cargo);
            return "Cargo actualizado correctamente";
        } catch (Exception e) {
            return "Error al actualizar el cargo:" + e.getMessage();
        }
    }

    @GET
    public List<NomCargo> consultarTodos() {
        return adminCargo.consultarTodos();
    }

    @GET
    @Path("/{id}")
    public NomCargo consultarPorId(@PathParam("id") Integer id) {
        return adminCargo.consultarPorId(id);
    }

    @DELETE
    @Path("/{id}")
    public String eliminar(@PathParam("id") Integer id) {
        try {
            adminCargo.eliminar(adminCargo.consultarPorId(id));
            return "Cargo eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar el cargo:" + e.getMessage();
        }
    }

}
