/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpLogin;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pojo.LoginColaborador;

/**
 *
 * @author USER
 */
@Path("login")
public class WSLogin {
    
    @Context
    private UriInfo context;

    public WSLogin() {
        
    }
    
    @Path("validarCredenciales")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public LoginColaborador inicioSesionColaborador (@FormParam("numeroPersonal") String numeroPersonal, @FormParam("password") String password) {
        return ImpLogin.validarColaborador(numeroPersonal, password);
    }
    
}
