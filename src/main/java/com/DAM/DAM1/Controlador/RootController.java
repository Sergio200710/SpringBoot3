package com.DAM.DAM1.Controlador;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public Map<String, String> bienvenida() {
        Map<String, String> respuesta = new LinkedHashMap<>();
        respuesta.put("alumno", "Sergio");
        respuesta.put("proyecto", "Proyecto Cinema 1º DAM");
        respuesta.put("estado", "Activo y funcionando");
        return respuesta;
    }
}
