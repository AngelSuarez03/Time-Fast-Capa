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
import pojo.Mensaje;
import pojo.Unidad;

/**
 *
 * @author USER
 */
public class ImpUnidad {
    
    //Obtener todas las unidades
    public static List<Unidad> obtenerUnidades() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Unidad> unidades = null;
        if(conexionBD != null)
            unidades = conexionBD.selectList("unidad.obtenerUnidades");
        return unidades;
    }
    
    //Obtener todas las unidades dependiendo del estatus que reciba
    public static List<Unidad> obtenerUnidadesPorEstatus(String estatus) {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Unidad> unidades = null;
        if(conexionBD != null)
            unidades = conexionBD.selectList("unidad.obtenerUnidadesPorEstatus",estatus);
        return unidades;
    }
    
    //Registra una unidad
    public static Mensaje registrarUnidad(Unidad unidad){
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD != null){
            try {
                int resultado = conexionBD.insert("unidad.registrar",unidad);
                conexionBD.commit();
                if(resultado > 0){
                    respuesta.setError(false);
                    respuesta.setMensaje("Unidad registrada con éxito.");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("No se pudo registrar la unidad, inténtelo más tarde.");
                }
            } catch (Exception e){  
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento el servicio no está disponible.");
        }
        return respuesta;
    }
    
    //Editar una unidad por id
    public static Mensaje editarUnidad(Unidad unidad){
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD != null){
            try {
                int editado = conexionBD.update("unidad.editar", unidad);
                conexionBD.commit();
                if(editado > 0){
                    respuesta.setError(false);
                    respuesta.setMensaje("Información de la unidad actualizada");
                }else {
                    respuesta.setError(true);
                    respuesta.setMensaje("No es posible editar la unidad");
                    
                }
                
            } catch (Exception e){  
                    respuesta.setError(true);
                    respuesta.setMensaje(e.getMessage());
            }
        }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("Por el momento no se puede editar la información.");
        }
        return respuesta;
    }
    
    //Eliminar una unidad dependiendo del VII que reciba
    public static Mensaje eliminarUnidad(String vin) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD != null){
            try {
                HashMap<String,String> parametros = new LinkedHashMap<>();
                parametros.put("vin", vin);
                int editado = conexionBD.delete("unidad.eliminar", parametros);
                conexionBD.commit();
                if(editado > 0){
                    respuesta.setError(false);
                    respuesta.setMensaje("Unidad eliminada");
                }else {
                    respuesta.setError(true);
                    respuesta.setMensaje("No se encontró ninguna unidad con ese Numero de Identificación Vehicular");
                    
                }
                
            } catch (Exception e){  
                    respuesta.setError(true);
                    respuesta.setMensaje(e.getMessage());
            }
        }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("Por el momento no se puede eliminar la información.");
        }
        return respuesta;
    }
    
}
