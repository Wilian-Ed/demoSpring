package CRUD;

import com.prueba.demo.Products;
import utils.Consultas;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Leer {
    Consultas consultas = new Consultas();

    public List ConsultarProductos(){
        List<Products> arrayList = new ArrayList<>();
        String Query="call TodosProductos();";
        ResultSet resultSet=consultas.Conexion(Query);
        if (resultSet!=null)
        {
            try{
                while (resultSet.next()){
                    Products products = new Products();
                    products.setId(resultSet.getInt("IdProducto"));
                            products.setNombre(resultSet.getString("Nombre"));
                            products.setCantidad(resultSet.getInt("Cantidad"));
                            products.setPrecioC(resultSet.getDouble("PrecioCompra"));
                            products.setPrecioV(resultSet.getDouble("PrecioVenta"));
                            arrayList.add(products);
                }
                consultas.cerrarConexion();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public List ConsultarComprasGlobales(){
        List<Products> arrayList = new ArrayList<>();
        String Query="call ventasGlobales();";
        ResultSet resultSet=consultas.Conexion(Query);
        if (resultSet!=null)
        {
            try{
                while (resultSet.next()){
                    Products products = new Products();
                    products.setId(resultSet.getInt("IdCompra"));
                    products.setNombre(resultSet.getString("Nombre"));
                    products.setPrecioC(resultSet.getDouble("PrecioCompra"));
                    products.setPrecioV(resultSet.getInt("Cantidad"));
                    arrayList.add(products);
                }
                consultas.cerrarConexion();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public double ConsultarPromedioProduct(){
        Crear crear = new Crear();
        String text=crear.Nuevo("promedio()");
        return Double.parseDouble(text);
    }

    public List ConsultarCompraProducto(){
        List<Products> arrayList = new ArrayList<>();
        String Query="call ventaProducto();";
        ResultSet resultSet=consultas.Conexion(Query);
        if (resultSet!=null)
        {
            try{
                while (resultSet.next()){
                    Products products = new Products();
                    products.setId(resultSet.getInt("IdCompra"));
                    products.setNombre(resultSet.getString("Nombre"));
                    products.setPrecioC(resultSet.getDouble("PrecioCompra"));
                    products.setPrecioV(resultSet.getInt("Cantidad"));
                    arrayList.add(products);
                }
                consultas.cerrarConexion();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public ArrayList ConsultarVentas(){
        ArrayList<String> arrayList = null;
        String Query="call ConsVentas();";
        ResultSet resultSet=consultas.Conexion(Query);
        if (resultSet!=null)
        {
            try{
                while (resultSet.next()){
                    arrayList.add(
                            resultSet.getString("IdFactura")+"#"+
                                    resultSet.getString("Fecha")+"#"+
                                    resultSet.getString("IdUsuario")+"#"+
                                    resultSet.getString("Total")
                    );
                }
                consultas.cerrarConexion();
            }catch (Exception e){
                e.printStackTrace();
                consultas.cerrarConexion();
            }
        }
        return arrayList;
    }

    public ArrayList ConsultarCompras(){
        ArrayList<String> arrayList = null;
        String Query="call ConsCompras();";
        ResultSet resultSet=consultas.Conexion(Query);
        if (resultSet!=null)
        {
            try{
                while (resultSet.next()){
                    arrayList.add(
                            resultSet.getString("IdCompra")+"#"+
                                    resultSet.getString("IdUsuario")+"#"+
                                    resultSet.getString("Fecha")
                    );
                }
                consultas.cerrarConexion();
            }catch (Exception e){
                e.printStackTrace();
                consultas.cerrarConexion();
            }
        }
        return arrayList;
    }


    public int ConsultarNumeros(String query){
        int resultado=0;
        ResultSet resultSet=consultas.Conexion(query);
        try{
            if (resultSet!=null&&resultSet.next()){
                resultado=resultSet.getInt("resultado");
                consultas.cerrarConexion();
                return resultado;
            }else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            consultas.cerrarConexion();
            return 0;
        }
    }

    public int TotalVentas(){
        return ConsultarNumeros("call TotalVentas();");
    }
}