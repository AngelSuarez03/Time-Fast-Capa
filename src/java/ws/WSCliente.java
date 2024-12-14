/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpCliente;
import dominio.ImpColaborador;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pojo.Cliente;
import pojo.Colaborador;

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
  
}
