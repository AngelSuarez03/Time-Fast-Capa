/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Cliente;
import pojo.Colaborador;

/**
 *
 * @author reyes
 */
public class ImpCliente {
    
    public static List<Cliente> obtenerClientes() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Cliente> clientes = null;
        if (conexionBD != null) {
            clientes = conexionBD.selectList("cliente.obtenerClientes");
        }
        return clientes;
    }
    
}
