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
import pojo.Mensaje;

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
    
     public static Mensaje registrarCliente(Cliente cliente) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                int resultado = conexionBD.insert("cliente.insertarCliente", cliente);
                conexionBD.commit();
                if (resultado > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Cliente registrado con éxito.");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("No se pudo registrar al cliente, inténtelo más tarde.");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento el servicio no está disponible.");
        }
        return respuesta;
    }
}
