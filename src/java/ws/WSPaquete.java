/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpEnvio;
import dominio.ImpPaquete;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pojo.Envio;
import pojo.Mensaje;
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
    
    @Path("eliminarPaquete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarPaquete(@PathParam ("id") Integer id) {
        if (id != null || id > 0)
            return ImpPaquete.eliminarPaquete(id);
        throw new BadRequestException();
    }
    
    @Path("crearPaquete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje crearPaquete(String jsonPaquete) {
        try {
            Gson gson = new Gson();
            Paquete paquete = gson.fromJson(jsonPaquete, Paquete.class);
            return ImpPaquete.crearPaquete(paquete);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }
    
    @Path("actualizarPaquete")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje actualizarPaquete(String jsonPaquete) {
        try {
            Gson gson = new Gson();
            Paquete paquete = gson.fromJson(jsonPaquete, Paquete.class);
            return ImpPaquete.actualizarPaquete(paquete);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }
    
}
