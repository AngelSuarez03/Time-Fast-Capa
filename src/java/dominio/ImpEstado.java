/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Estado;

/**
 *
 * @author USER
 */
public class ImpEstado {
    
    public static List<Estado> obtenerEstados() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Estado> estados = null;
        if( conexionBD != null ) {
            estados = conexionBD.selectList("estado.obtenerEstados");
        }
        return estados;
    }
    
}
