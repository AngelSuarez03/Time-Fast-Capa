/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpColaborador;
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

    public WSColaborador() {

    }

    @Path("obtenerColaboradores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador> obtenerColaborador() {
        return ImpColaborador.obtenerColaboradores();
    }

    @Path("obtenerColaboradoresRol/{idRol}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador> obtenerPorRol(@PathParam("idRol") Integer idRol) {
        if (idRol != null && idRol > 0) {
            return ImpColaborador.obtenerColaboradoresPorRol(idRol);
        }
        throw new BadRequestException();
    }

    @Path("obtenerColaboradoresNoAsignados")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador> obtenerNoAsigados() {
        return ImpColaborador.obtenerConductoresSinAsignar();
    }
    
    @Path("obtenerConductoresAsignados")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador> obtenerAsigados() {
        return ImpColaborador.obtenerConductorAsignado();
    }

    @Path("recuperarContrasenia/{correo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String recuperarPassword(@PathParam("correo") String correo) {
        if (correo != null) {
            return ImpColaborador.recuperarPassword(correo);
        }
        throw new BadRequestException();
    }

    @Path("registrarColaborador")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarColaborador(String jsonColaborador) {
        try {
            Gson gson = new Gson();
            Colaborador colaborador = gson.fromJson(jsonColaborador, Colaborador.class);
            return ImpColaborador.registrarColaborador(colaborador);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }

    @Path("editarColaborador")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarColaborador(String jsonColaborador) {
        try {
            Gson gson = new Gson();
            Colaborador colaborador = gson.fromJson(jsonColaborador, Colaborador.class);
            return ImpColaborador.editarColaborador(colaborador);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }

    @Path("eliminarColaborador/{numeroPersonal}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarColaborador(@PathParam("numeroPersonal") String numeroPersonal) {
        if (numeroPersonal != null && !numeroPersonal.isEmpty()) {
            return ImpColaborador.eliminarColaborador(numeroPersonal);
        }
        throw new BadRequestException();
    }

    @Path("editarUnidadColaborador")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarUnidadColaborador(String jsonParams) {
        try {
            Gson gson = new Gson();
            Map<String, Object> params = gson.fromJson(jsonParams, Map.class);

            Integer id = (params.get("id") instanceof Double) ? ((Double) params.get("id")).intValue() : (Integer) params.get("id");
            Integer idUnidad = params.get("idUnidad") == null ? null
                    : (params.get("idUnidad") instanceof Double ? ((Double) params.get("idUnidad")).intValue() : (Integer) params.get("idUnidad"));

            return ImpColaborador.editarColaboradorUnidad(id, idUnidad);
        } catch (Exception e) {
            throw new BadRequestException("Datos de entrada inválidos.");
        }
    }

}
