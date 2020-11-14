package CRUD;

public class Actualizar {

public String actualizarProducto(String nombre,int cant,double pC,double pV){
    Crear crear = new Crear();
    return crear.Nuevo("call ActualizarProducto('"+nombre+"',"+cant+","+pC+","+pV+");");
}
}