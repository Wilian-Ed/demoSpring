package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {

    Connection connection;

    public ResultSet Conexion(String Query){
        ConnectionDB connectionDB = new ConnectionDB();
        connection = connectionDB.getConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Query);
            return resultSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void cerrarConexion(){
        try {
            connection.close();
        } catch (SQLException throwables) {
        }
    }
}