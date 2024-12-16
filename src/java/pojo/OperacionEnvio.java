/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Roberto
 */
public class OperacionEnvio {
    
    private Boolean error;
    private String mensaje;
    private Envio envio;

    public OperacionEnvio() {
    }

    public OperacionEnvio(Boolean error, String mensaje, Envio envio) {
        this.error = error;
        this.mensaje = mensaje;
        this.envio = envio;
    }

    public Boolean getError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }
    
    
}
