/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Estatus;

/**
 *
 * @author USER
 */
public class ImpEstatus {
    
    public static List<Estatus> obtenerEstatus() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Estatus> estatus = null;
        if( conexionBD != null ) {
            estatus = conexionBD.selectList("estatus.obtenerEstatus");
        }
        return estatus;
    }
    
}
