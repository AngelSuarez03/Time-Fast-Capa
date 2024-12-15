/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.HashMap;
import java.util.LinkedHashMap;
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

    public static Mensaje editarClente(Cliente cliente) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                int editado = conexionBD.update("cliente.actualizarCliente", cliente);
                conexionBD.commit();
                if (editado > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Información del colaborador: " + cliente.getNombre() + " ha sido editada.");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("El cliente ingresado no existe");

                }

            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento no se puede editar la información.");
        }
        return respuesta;
    }
    
    public static Mensaje eliminarCliente(Integer id) {
        Mensaje msj = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                int resultado = conexionBD.delete("cliente.eliminarCliente", id);
                conexionBD.commit();
                if (resultado > 0) {
                    msj.setError(false);
                    msj.setMensaje("Cliente (a) eliminado con exito.");
                } else {
                    msj.setError(true);
                    msj.setMensaje("No se pudo eliminar al cliente(a), intente nuevamente");
                }
            } catch (Exception e) {
                msj.setError(true);
                msj.setMensaje(e.getMessage());
            }
        } else {
            msj.setError(true);
            msj.setMensaje("Por el momento no está disponible.");
        }

        return msj;
    }

}
