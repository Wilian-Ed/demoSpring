package CRUD;

import utils.Consultas;

import java.sql.ResultSet;

public class Crear {

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

    public String NuevoUsuario(String usuario,String contra){
        return Nuevo("call CrearUsuario('"+usuario+"','"+contra+"');");
    }

    public String NuevoProducto(String nombre,int cantidad,double precioCompra,double precioVenta){
        return Nuevo("call ProductoNuevo('"+nombre+"',"+cantidad+","+precioCompra+","+precioVenta+");");
    }

    public void InsertarCompra(int id){
        Nuevo("call Comprar("+id+");");
    }
    
}