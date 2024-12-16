/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Mensaje;
import pojo.Paquete;

/**
 *
 * @author USER
 */
public class ImpPaquete {
    
    public static List<Paquete> obtenerPaquetes() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Paquete> paquetes = null;
        if ( conexionBD != null ) {
            paquetes = conexionBD.selectList("paquete.obtenerPaquetes");
        }
        return paquetes;
    }
    
    public static List<Paquete> obtenerPaquetesEnvios(Integer idEnvio) {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Paquete> paquetes = null;
        if ( conexionBD != null ) {
            paquetes = conexionBD.selectList("paquete.obtenerPaquetesEnvio", idEnvio);
        }
        return paquetes;
    }
    
    public static Mensaje crearPaquete(Paquete paquete) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                int resultado = conexionBD.insert("paquete.crearPaquete", paquete);
                conexionBD.commit();
                if (resultado > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Paquete registrado con éxito al envio.");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("Verifique la información ingresada");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento el servicio no está disponible.");
        }
        return respuesta;
    }
    
    public static Mensaje actualizarPaquete(Paquete paquete) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                int resultado = conexionBD.update("paquete.actualizarPaquete", paquete);
                conexionBD.commit();
                if (resultado > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Paquete actualizado con éxito.");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("El paquete no existe, por favor verifique la información.");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento el servicio no está disponible.");
        }
        return respuesta;
    }
    
    public static Mensaje eliminarPaquete(Integer id) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                int resultado = conexionBD.delete("paquete.eliminarPaquete", id);
                conexionBD.commit();
                if (resultado > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Paquete eliminado con éxito.");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("El paquete no existe.");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento el servicio no está disponible.");
        }
        return respuesta;
    }
    
}
