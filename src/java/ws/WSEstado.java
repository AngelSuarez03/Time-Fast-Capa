/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpEstado;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pojo.Estado;

/**
 *
 * @author USER
 */
@Path("estado")
public class WSEstado {
    
    @Context
    private UriInfo context;
    
    public WSEstado() {
        
    }
    
    @Path("obtenerEstados")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> obtenerEstados() {
        return ImpEstado.obtenerEstados();
    }
    
}
