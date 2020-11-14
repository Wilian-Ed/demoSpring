package com.prueba.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("v0")
public class GreetingController {

    @GetMapping(value = "/status")
    String checkStatus(){
        return "ok";
    }

    @RequestMapping("/greeting")
    public com.prueba.demo.Greeting greeting(@RequestParam(value = "user",defaultValue = "")String user,
                                             @RequestParam(value = "pass",defaultValue = "")String pas){
        com.prueba.demo.Autenticacion autenticacion = new com.prueba.demo.Autenticacion();
        return new com.prueba.demo.Greeting(String.format(autenticacion.Atenticar(user,pas)));
    }
}