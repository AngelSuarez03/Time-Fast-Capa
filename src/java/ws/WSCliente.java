/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpCliente;
import dominio.ImpColaborador;
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
import pojo.Cliente;
import pojo.Colaborador;
import pojo.Mensaje;

/**
 *
 * @author reyes
 */
@Path("cliente")
public class WSCliente {

    @Context
    private UriInfo context;

    public WSCliente() {

    }

    @Path("obtenerClientes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> obtenerCliente() {
        return ImpCliente.obtenerClientes();
    }

    @Path("registrarCliente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarCliente(String jsonCliente) {
        try {
            Gson gson = new Gson();
            Cliente cliente = gson.fromJson(jsonCliente, Cliente.class);
            return ImpCliente.registrarCliente(cliente);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }

    @Path("editarCliente")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarCliente(String jsonCliente) {
        try {
            Gson gson = new Gson();
            Cliente cliente = gson.fromJson(jsonCliente, Cliente.class);
            return ImpCliente.editarClente(cliente);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }
    
    @Path("eliminarCliente/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarCliente(@PathParam("id") Integer id) {
        if (id != null) {
            return ImpCliente.eliminarCliente(id);
        }
        throw new BadRequestException();
    }
    
}
