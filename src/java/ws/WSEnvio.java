/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpEnvio;
import dominio.ImpPosee;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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

/**
 *
 * @author USER
 */

@Path("envio")
public class WSEnvio {
    
    @Context
    private UriInfo context;
    
    public WSEnvio() {
        
    }
    
    @Path("obtenerEnvios")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Envio> obtenerEnvios() {
        return ImpEnvio.obtenerEnvios();
    }
    
    @Path("obtenerEnviosColaborador/{idColaborador}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Envio> obtenerEnviosColaborador(@PathParam("idColaborador") Integer idColaborador) {
        if(idColaborador > 0 && idColaborador != null)
            return ImpEnvio.obtenerEnvioConductor(idColaborador);
        throw new BadRequestException();
    }
    
    @Path("obtenerPorEstatus/{idEstatus}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Envio> obtenerPorEstatus(@PathParam("idEstatus") Integer idEstatus) {
        if(idEstatus > 0 && idEstatus != null)
            return ImpEnvio.obtenerPorEstatus(idEstatus);
        throw new BadRequestException();
    }
    
    @Path("actualizarEstatus")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje actualizarEstatus(@FormParam("idEstatus") Integer idEstatus, @FormParam("id") Integer id) {
        if(idEstatus != null && id != null)
            return ImpEnvio.actualizarEstatus(idEstatus, id);
        throw new BadRequestException();
    }
    
    @Path("crearEnvio")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje crearEnvio(String jsonEnvio) {
        try {
            Gson gson = new Gson();
            Envio envio = gson.fromJson(jsonEnvio, Envio.class);
            return ImpEnvio.crearEnvio(envio);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }
    
    @Path("actualizarEnvio")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje actualizarEnvio(String jsonEnvio) {
        try {
            Gson gson = new Gson();
            Envio envio = gson.fromJson(jsonEnvio, Envio.class);
            return ImpEnvio.modificarEnvio(envio);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }
    
}
