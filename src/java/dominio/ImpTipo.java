/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Tipo;

/**
 *
 * @author USER
 */
public class ImpTipo {
    
    public static List<Tipo> obtenerTipos() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Tipo> tipos = null;
        if(conexionBD != null)
            tipos = conexionBD.selectList("tipo.obtenerTipos");
        return tipos;
    }
    
}
