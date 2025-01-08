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
import pojo.Posee;

/**
 *
 * @author USER
 */
public class ImpPosee {
    
    public static Mensaje historialEstatus(Posee posee) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD != null){
            try {
                int resultado = conexionBD.insert("posee.historialEstatus", posee);
                conexionBD.commit();
                if(resultado > 0){
                    respuesta.setMensaje("Actualización añadida al historial");
                    respuesta.setError(false);
                } else {
                    respuesta.setMensaje("La actualización no se puede añadir");
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
    
    public static List<Posee> obtenerHistorialPorIdEnvio(Integer idEnvio) {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Posee> historiales = null;
        if ( conexionBD != null ) {
            historiales = conexionBD.selectList("posee.obtenerHistorialPorIdEnvio", idEnvio);
        }
        return historiales;
    }
    
}
