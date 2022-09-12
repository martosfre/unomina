/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matoosfe.unomina.servicios.rs;

import com.matoosfe.unomina.controllers.NomEmpleadoFacade;
import com.matoosfe.unomina.entities.NomEmpleado;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author martosfre
 */
@Path("empleado-rs")
public class RSEmpleadoService {

    @Inject
    private NomEmpleadoFacade adminEmpleado;

    @PATCH
    @Path("/{id}")
    public String subirImagen(File fotoEmpleado, @PathParam("id") Integer id) {
        try {
            NomEmpleado empleado = adminEmpleado.consultarPorId(id);
            empleado.setEmplFoto(Files.readAllBytes(Paths.get(fotoEmpleado.getPath())));
            adminEmpleado.actualizar(empleado);
            return "Imagen cargada correctamente";
        } catch (IOException e) {
            return "Erorr al subir imagen:" + e.getMessage();
        }
    }
    
    @GET
    @Path("/{id}")
    public File descargarImagen(@PathParam("id") Integer id) {
        try {
            NomEmpleado empleado = adminEmpleado.consultarPorId(id);
            java.nio.file.Path path = Paths.get("/Users/martosfre/Downloads/fotoEmpleado");

            return Files.write(path, empleado.getEmplFoto()).toFile();
        } catch (Exception e) {
            return null;
        }
    }
}
