/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
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
    
}
