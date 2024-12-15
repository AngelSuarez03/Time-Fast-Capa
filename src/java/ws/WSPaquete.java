/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpPaquete;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pojo.Paquete;

/**
 *
 * @author USER
 */
@Path("paquete")
public class WSPaquete {
    
    @Context
    private UriInfo context;

    public WSPaquete() {
        
    }
    
    @Path("obtenerPaquetes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paquete> obtenerPaquetes() {
        return ImpPaquete.obtenerPaquetes();
    }
    
    @Path("obtenerPaquetesEnvio/{idEnvio}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paquete> obtenerPaquetesEnvio(@PathParam ("idEnvio") Integer idEnvio) {
        if (idEnvio != null || idEnvio > 0)
            return ImpPaquete.obtenerPaquetesEnvios(idEnvio);
        throw new BadRequestException();
    }
    
}
