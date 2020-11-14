package com.prueba.demo;

import utils.Consultas;

import java.sql.ResultSet;

public class Autenticacion {

    Consultas consultas = new Consultas();

    public String Nuevo(String query){
        String resultado=null;
        ResultSet resultSet=consultas.Conexion(query);
        try{
            if (resultSet!=null&&resultSet.next()){
                resultado=resultSet.getString("resultado");
                consultas.cerrarConexion();
                return resultado;
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            consultas.cerrarConexion();
            return null;
        }
    }

    public String Atenticar(String name,String pass){
        if(Nuevo("call VerificarUsuario('"+name+"','"+pass+"');").contains("1")){
            return "true";
        }else
            return "false";
    }
}