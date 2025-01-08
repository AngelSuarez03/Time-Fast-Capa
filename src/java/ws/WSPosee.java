/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpPosee;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pojo.Mensaje;
import pojo.Posee;

/**
 *
 * @author USER
 */
@Path("posee")
public class WSPosee {
    
    @Context
    private UriInfo context;
    
    public WSPosee() {
        
    }
    
    @Path("historialEstatus")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje historialEstatus (String jsonPosee){
        try {
            Gson gson = new Gson();
            Posee posee = gson.fromJson(jsonPosee, Posee.class);
            return ImpPosee.historialEstatus(posee);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }
    
    @Path("obtenerHistorialPorIdEnvio/{idEnvio}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Posee> obtenerPaquetesEnvio(@PathParam ("idEnvio") Integer idEnvio) {
        if (idEnvio != null || idEnvio > 0)
            return ImpPosee.obtenerHistorialPorIdEnvio(idEnvio);
        throw new BadRequestException();
    }
}
