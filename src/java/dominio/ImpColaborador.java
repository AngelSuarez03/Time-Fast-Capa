/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Colaborador;

/**
 *
 * @author USER
 */
public class ImpColaborador {
    
    public static List<Colaborador> obtenerColaboradores(){
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Colaborador> colaboradores = null;
        if(conexionBD != null){
            colaboradores = conexionBD.selectList("colaborador.obtenerColaboradores");
        }
        return colaboradores;
    }
    
}
