/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Colaborador;
import pojo.Mensaje;

/**
 *
 * @author USER
 */
public class ImpColaborador {

    //Obtiene un lista de todos los colaboradores registrados
    public static List<Colaborador> obtenerColaboradores() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Colaborador> colaboradores = null;
        if (conexionBD != null) {
            colaboradores = conexionBD.selectList("colaborador.obtenerColaboradores");
        }
        return colaboradores;
    }

    //Devulve la contraseña del correo ingresado
    public static String recuperarPassword(String correo) {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        String password = "";
        if (conexionBD != null) {
            password = conexionBD.selectOne("colaborador.recuperarPassword", correo);
        }
        return password;
    }

    //Obtiene un lista de colaborador por el rol asignado
    public static List<Colaborador> obtenerColaboradoresPorRol(Integer idRol) {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Colaborador> colaboradores = null;
        if (conexionBD != null) {
            colaboradores = conexionBD.selectList("colaborador.obtenerPorRol", idRol);
        }
        return colaboradores;
    }

    //Obtiene un lista de colaborador sin unidad asignada
    public static List<Colaborador> obtenerConductoresSinAsignar() {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        List<Colaborador> colaboradores = null;
        if (conexionBD != null) {
            colaboradores = conexionBD.selectList("colaborador.noAsignados");
        }
        return colaboradores;
    }

    //Registra un colaborador
    public static Mensaje registrarColaborador(Colaborador colaborador) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                int resultado = conexionBD.insert("colaborador.registrar", colaborador);
                conexionBD.commit();
                if (resultado > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Colaborador(a) registrado con éxito.");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("No se pudo registrar al colaborador(a), inténtelo más tarde.");
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

    //Editar un colaborador por id
    public static Mensaje editarColaborador(Colaborador colaborador) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                int editado = conexionBD.update("colaborador.editar", colaborador);
                conexionBD.commit();
                if (editado > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Información del colaborador: " + colaborador.getNombre() + " a sido editada.");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("El numero de personal ingresado no existe");

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

    public static Mensaje eliminarColaborador(String numeroPersonal) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("numeroPersonal", numeroPersonal);
                int editado = conexionBD.delete("colaborador.eliminar", parametros);
                conexionBD.commit();
                if (editado > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Colaborador eliminado");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("No se encontró ningun colaborador con ese N° de Personal");

                }

            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento no se puede eliminar la información.");
        }
        return respuesta;
    }

    public static Mensaje editarColaboradorUnidad(int id, Integer idUnidad) {
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();

        if (conexionBD != null) {
            try {
                Map<String, Object> params = new HashMap<>();
                params.put("id", id);
                params.put("idUnidad", idUnidad); 

                int editado = conexionBD.update("colaborador.quitarUnidad", params);
                conexionBD.commit();

                if (editado > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Información del colaborador con la unidad " + idUnidad + " ha sido editada.");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("El colaborador con el ID especificado no existe.");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje("Error al editar la información: " + e.getMessage());
            } finally {
                conexionBD.close();
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("No se pudo establecer la conexión con la base de datos.");
        }
        return respuesta;
    }

}
