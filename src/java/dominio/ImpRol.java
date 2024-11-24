/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Rol;

/**
 *
 * @author USER
 */
public class ImpRol {
    
    public static List<Rol> obtenerRoles() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Rol> roles = null;
        if(conexionBD != null)
            roles = conexionBD.selectList("rol.obtenerRoles");
        return roles;
    }
    
}
