/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpTipo;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pojo.Tipo;

/**
 *
 * @author USER
 */
@Path("tipo")
public class WSTipo {
    
    
    @Context
    private UriInfo context;
    
    public WSTipo() {
        
    }
    
    @Path("obtenerTipos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tipo> obtenerTipos() {
        return ImpTipo.obtenerTipos();
    }
    
}
