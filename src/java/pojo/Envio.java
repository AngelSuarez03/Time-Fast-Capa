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
    private String ciudad;
    private Float costo;
    private String destino;
    private String motivo;
    private Integer idColaborador;
    private String colaborador;
    private Integer idCliente;
    private String cliente;
    private String correo;
    private String telefono;
    private Integer idEstatus;
    private String estatus;
    
    public Envio() {
    
    }

    public Envio(Integer id, String numeroGuia, String calle, String colonia, Integer numero, String cp, String ciudad, Float costo, String destino, String motivo, Integer idColaborador, String colaborador, Integer idCliente, String cliente, String correo, String telefono, Integer idEstatus, String estatus) {
        this.id = id;
        this.numeroGuia = numeroGuia;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.cp = cp;
        this.ciudad = ciudad;
        this.costo = costo;
        this.destino = destino;
        this.motivo = motivo;
        this.idColaborador = idColaborador;
        this.colaborador = colaborador;
        this.idCliente = idCliente;
        this.cliente = cliente;
        this.correo = correo;
        this.telefono = telefono;
        this.idEstatus = idEstatus;
        this.estatus = estatus;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    

}
