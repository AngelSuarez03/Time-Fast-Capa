/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Envio;
import pojo.Mensaje;
import pojo.OperacionEnvio;

/**
 *
 * @author USER
 */
public class ImpEnvio {

    public static List<Envio> obtenerEnvios() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Envio> envios = null;
        if (conexionBD != null) {
            envios = conexionBD.selectList("envio.envios");
        }
        return envios;
    }

    public static List<Envio> obtenerEnvioConductor(Integer idColaborador) {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Envio> envios = null;
        if (conexionBD != null) {
            envios = conexionBD.selectList("envio.obtenerEnviosColaborador", idColaborador);
        }
        return envios;
    }
    
    public static List<Envio> obtenerPorEstatus(Integer idEstatus) {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Envio> envios = null;
        if (conexionBD != null) {
            envios = conexionBD.selectList("envio.obtenerPorEstatus", idEstatus);
        }
        return envios;
    }

    public static Mensaje actualizarEstatus(Integer idEstatus, Integer id) {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        Mensaje respuesta = new Mensaje();
        if (conexionBD != null) {
            try {
                HashMap<String, Integer> parametros = new LinkedHashMap<>();
                parametros.put("idEstatus", idEstatus);
                parametros.put("id", id);
                int actualizado = conexionBD.update("envio.actualizarEstatus", parametros);
                conexionBD.commit();
                if (actualizado > 0) {
                    respuesta.setMensaje("Estatus Actualizado");
                    respuesta.setError(false);
                } else {
                    respuesta.setMensaje("El estatus no es válido | El envio no existe");
                    respuesta.setError(true);
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento no se puede actualizar la información.");
        }
        return respuesta;
    }
    
    public static Mensaje crearEnvio(Envio envio){
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD != null){
            try {
                int resultado = conexionBD.insert("envio.insertar", envio);
                conexionBD.commit();
                if(resultado > 0){
                    respuesta.setMensaje("Envío creado, gracias por su preferencia");
                    respuesta.setError(false);
                } else {
                    respuesta.setMensaje("El envío ya existe, por favor verifique los datos");
                    respuesta.setError(true);
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento no se puede actualizar la información.");
        }
        return respuesta;
    }
    
    public static Mensaje modificarEnvio(Envio envio){
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD != null){
            try {
                int resultado = conexionBD.update("envio.actualizarEnvio", envio);
                conexionBD.commit();
                if(resultado > 0){
                    respuesta.setMensaje("Envío actualizado, gracias por su preferencia");
                    respuesta.setError(false);
                } else {
                    respuesta.setMensaje("El envío no existe, por favor verifique los datos");
                    respuesta.setError(true);
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento no se puede actualizar la información.");
        }
        return respuesta;
    }

    public static OperacionEnvio obtenerEnvioNoGuia(String numeroGuia){
        
        OperacionEnvio respuesta = new OperacionEnvio();
        
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD != null){
            try{
                HashMap<String,String> parametros = new LinkedHashMap<>();
                parametros.put("numeroGuia",numeroGuia);
                System.out.println(parametros);
                Envio envio = conexionBD.selectOne("envio.obtenerPorNoGuia",parametros);
                if(envio != null){
                    respuesta.setError(false);
                    respuesta.setMensaje("Datos del envio: " +envio.getNumeroGuia());
                    respuesta.setEnvio(envio);
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("Numero de guia incorrecto");
                }
            }catch(Exception e){
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento no se puede consultar la informaciÃ³n.");
        }
        return respuesta;
    }
}
