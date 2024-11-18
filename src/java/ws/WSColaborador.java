/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpColaborador;
import java.util.List;
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
import pojo.Colaborador;
import pojo.Mensaje;

/**
 *
 * @author USER
 */

@Path("colaborador")
public class WSColaborador {
    
    @Context
    private UriInfo context;
    
    public WSColaborador(){
        
    }
    
    @Path("obtenerTodos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador> obtenerColaborador () {
        return ImpColaborador.obtenerColaboradores();
    }
    
    @Path("obtenerPorRol/{rol}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador> obtenerPorRol (@PathParam("rol") String rol) {
        //TODO
        return null;
    } 
    
    @Path("noAsignados")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador> obtenerNoAsigados () {
        //TODO
        return null;
    } 
    
    @Path("recuperarPassword")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje recuperarPassword () {
        //TODO
        return null;
    } 
    
    @Path("registrar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarColaborador (String jsonColaborador) {
        //TODO
        return null;
    } 
    
    @Path("editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarColaborador (String jsonColaborador) {
        //TODO
        return null;
    } 
    
    @Path("eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarColaborador (@PathParam ("id") String id) {
        //TODO
        return null;
    } 
    
}
