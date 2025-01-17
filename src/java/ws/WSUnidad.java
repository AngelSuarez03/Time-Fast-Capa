/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpUnidad;
import java.util.List;
import java.util.Map;
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
import pojo.Mensaje;
import pojo.Unidad;

/**
 *
 * @author USER
 */
@Path("unidad")
public class WSUnidad {

    @Context
    private UriInfo context;

    public WSUnidad() {

    }

    @Path("obtenerUnidades")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Unidad> obtenerUnidades() {
        return ImpUnidad.obtenerUnidades();
    }

    @Path("obtenerUnidadesEstatus/{estado}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Unidad> obtenerUnidadesPorEstatus(@PathParam ("estado") String estado) {
        if( estado != null)
            return ImpUnidad.obtenerUnidadesPorEstatus(estado);
        throw new BadRequestException();
    }
    
    @Path("obtenerUnidadesDisponibles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Unidad> obtenerUnidadesDisponibles() {
        return ImpUnidad.obtenerUnidadesDisponibles();
    }

    @Path("registrar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarUnidad(String jsonUnidad) {
        try {
            Gson gson = new Gson();
            Unidad unidad = gson.fromJson(jsonUnidad, Unidad.class);
            return ImpUnidad.registrarUnidad(unidad);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }

    @Path("editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarUnidad(String jsonUnidad) {
        try {
            Gson gson = new Gson();
            Unidad unidad = gson.fromJson(jsonUnidad, Unidad.class);
            return ImpUnidad.editarUnidad(unidad);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }

    @Path("eliminar/{vin}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarUnidad(@PathParam("vin") String vin) {
        if (vin != null && !vin.isEmpty()) {
            return ImpUnidad.eliminarUnidad(vin);
        }
        throw new BadRequestException();
    }

    @Path("editarEstadoUnidad")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarUnidadColaborador(String jsonParams) {
        try {
            Gson gson = new Gson();
            Map<String, Object> params = gson.fromJson(jsonParams, Map.class);

            Integer id = (params.get("id") instanceof Double) ? ((Double) params.get("id")).intValue() : (Integer) params.get("id");
            String estado = params.get("estado") == null ? null
                    : (params.get("estado") instanceof Double ? String.valueOf((Double) params.get("estado")) : (String) params.get("estado"));
            return ImpUnidad.editarEstadoUnidad(id, estado);
        } catch (Exception e) {
            throw new BadRequestException("Datos de entrada inválidos.");
        }
    }
}
