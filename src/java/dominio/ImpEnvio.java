/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Envio;

/**
 *
 * @author USER
 */
public class ImpEnvio {
    
    public static List<Envio> obtenerEnvios() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Envio> envios = null;
        if(conexionBD != null) {
            envios = conexionBD.selectList("envio.envios");
        }
        return envios;
    }
    
    public static List<Envio> obtenerEnvioConductor() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Envio> envios = null;
        if(conexionBD != null) {
            envios = conexionBD.selectList("envio. envios");
        }
        return envios;
    }
    
}
