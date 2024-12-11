/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author USER
 */
public class Envio {
    
    private Integer id;
    private String numeroGuia;
    private String calle;
    private String colonia;
    private Integer numero;
    private String cp;
    private String cuidad;
    private Float costo;
    private String destino;
    private String motivo;
    
    public Envio() {
    
    }

    public Envio(Integer id, String numeroGuia, String calle, String colonia, Integer numero, String cp, String cuidad, Float costo, String destino, String motivo) {
        this.id = id;
        this.numeroGuia = numeroGuia;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.cp = cp;
        this.cuidad = cuidad;
        this.costo = costo;
        this.destino = destino;
        this.motivo = motivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
}
