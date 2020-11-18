package com.prueba.demo;

import CRUD.Crear;
import CRUD.Leer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("v0")
public class GreetingController {


    @GetMapping(value = "/status")
    String checkStatus(){
        return "ok";
    }

    @RequestMapping("/autenticar")
    public com.prueba.demo.Greeting greeting(@RequestParam(value = "user",defaultValue = "")String user,
                                             @RequestParam(value = "pass",defaultValue = "")String pas){
        com.prueba.demo.Autenticacion autenticacion = new com.prueba.demo.Autenticacion();
        return new com.prueba.demo.Greeting(String.format(autenticacion.Atenticar(user,pas)));
    }//asd

    @GetMapping(value="/product")
    public List<Products> getProduct(){
        Leer leer = new Leer();
        return leer.ConsultarProductos();
    }

    @GetMapping(value="/vent-glob")
    public List<Products> getVentGlob(){
        Leer leer = new Leer();
        return leer.ConsultarComprasGlobales();
    }

    @GetMapping(value="/vent-prod")
    public List<Products> getVentProduct(){
        Leer leer = new Leer();
        return leer.ConsultarCompraProducto();
    }

    @GetMapping(value="/prom")
    public Double getPromProduct(){
        Leer leer = new Leer();
        return leer.ConsultarPromedioProduct();
    }


    @GetMapping("/compra")
    public Greeting greeting(@RequestParam(value = "id",defaultValue = "")int id){
        Crear crear = new Crear();
        crear.InsertarCompra(id);
        return new Greeting("Hecho");
    }

    @GetMapping("/nuevo_product")
    public String setProduct(
            @RequestParam(value = "nombre",defaultValue = "")String nombre,
            @RequestParam(value = "cantidad",defaultValue = "")int cantidad,
            @RequestParam(value = "precio",defaultValue = "")double precio
    ) {//a
        Crear crear = new Crear();
        crear.NuevoProducto(nombre,cantidad,precio,0);
        return "Hecho";
    }
}