/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpRol;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pojo.Rol;

/**
 *
 * @author USER
 */
@Path("rol")
public class WSRol {
    
    
    @Context
    private UriInfo context;
    
    public WSRol() {
        
    }
    
    @Path("obtenerRoles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rol> obtenerRoles() {
        return ImpRol.obtenerRoles();
    }
    
}
