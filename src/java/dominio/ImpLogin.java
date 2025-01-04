/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.HashMap;
import java.util.LinkedHashMap;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Colaborador;
import pojo.LoginColaborador;

/**
 *
 * @author USER
 */
public class ImpLogin {
    
    //Validacion credenciales colaborador
    public static LoginColaborador validarColaborador(String noPersonal, String password){
        LoginColaborador respuesta = new LoginColaborador();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD != null){
            try {
                HashMap<String,String> parametros = new LinkedHashMap<>();
                parametros.put("numeroPersonal", noPersonal);
                parametros.put("password", password);
                Colaborador colaborador = conexionBD.selectOne("login.colaborador", parametros);
                if(colaborador != null){
                    respuesta.setError(false);
                    respuesta.setMensaje("Credenciales correctas del colaborador " + colaborador.getNombre());
                    respuesta.setColaborador(colaborador);
                }else {
                    respuesta.setError(true);
                    respuesta.setMensaje("No. de personal y / o  password incorrectos");
                }
                
            } catch (Exception e){  
                    respuesta.setError(true);
                    respuesta.setMensaje(e.getMessage());
            }
        }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("Por el momento no se puede consultar la información.");
        }
        return respuesta;
    }
    
}
