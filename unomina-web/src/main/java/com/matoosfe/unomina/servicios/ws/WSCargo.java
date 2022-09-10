/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.matoosfe.unomina.servicios.ws;

import com.matoosfe.unomina.controllers.NomCargoFacade;
import com.matoosfe.unomina.entities.NomCargo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author martosfre
 */

/*
 * Anotación para especificar que la clase se trata de un servicio web SOAP.
 * Si no se utiliza el atributo name, el nombre del servicio será el nombre
 *  de la clase con el sufijo Service
 */
@WebService(name = "ServiceCargo")
public class WSCargo {

    @Resource
    WebServiceContext wsctx;

    @Inject
    private NomCargoFacade adminCargo;

    /**
     * Método para imprimir el nombre enviado como parámetro.
     *
     * @WebMethod es para configurar el nombre del método, si no se utiliza el
     * atributo operation name, el nombre de la operación es el nombre del
     * método. De igual manera para especificar el nombre de los parámetros se
     * utiliza la anotación @WebParam
     * @param txt
     * @return
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod
    public String guardarCargo(NomCargo cargo) {
        String mensaje =  null;
        try {
            MessageContext mctx = wsctx.getMessageContext();

            Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
            List<String> usuario = (List<String>) http_headers.get("username");
            List<String> password = (List<String>) http_headers.get("password");

            if (usuario != null && usuario.get(0).equals("mtoscano") && password != null && password.get(0).equals("1234")) {

                adminCargo.guardar(cargo);
                mensaje = "Cargo guardado correctamente";
                return mensaje;
            } else {
                return "Usuario Incorrecto";
            }
        } catch (Exception e) {
            mensaje = "Error al guardar un cargo:" + e.getMessage();
        }
        return mensaje;
    }

    @WebMethod
    public String actualizarCargo(NomCargo cargo) {
        String mensaje = null;
        try {
            adminCargo.actualizar(cargo);
            mensaje = "Cargo guardado correctamente";
        } catch (Exception e) {
            mensaje = "Error al guardar un cargo:" + e.getMessage();
        }
        return mensaje;
    }

    @WebMethod
    public String eliminar(@WebParam(name = "idCar") Integer idCar) {
        String mensaje = null;
        try {
            adminCargo.eliminar(adminCargo.consultarPorId(idCar));
            mensaje = "Cargo eliminado correctamente";
        } catch (Exception e) {
            mensaje = "Error al eliminar un cargo:" + e.getMessage();
        }
        return mensaje;
    }

    @WebMethod(operationName = "consultarTodos")
    public List<NomCargo> consultar() throws Exception {
        List<NomCargo> cargos = new ArrayList<>();
        try {
            cargos = adminCargo.consultarTodos();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return cargos;
    }
}
