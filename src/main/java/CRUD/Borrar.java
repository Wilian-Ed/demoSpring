package CRUD;

public class Borrar {

    public String EliminarProducto(String nombre){
        Crear crear = new Crear();
        return crear.Nuevo("call EliminarProducto('"+nombre+"');");
    }

    public String EliminarCompra(String idCompra){
        Crear crear = new Crear();
        return crear.Nuevo("call EliminarCompra('"+idCompra+"');");
    }

    public String EliminarVenta(String facturas){
        Crear crear = new Crear();
        return crear.Nuevo("call EliminarProducto('"+facturas+"');");
    }
}