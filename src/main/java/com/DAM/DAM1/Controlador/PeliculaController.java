package com.DAM.DAM1.Controlador;

import com.DAM.DAM1.Dominio.Pelicula;
import com.DAM.DAM1.Servicio.PeliculaServicio;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/pelicula", "/peliculas"})
@AllArgsConstructor
public class PeliculaController {

    private final PeliculaServicio servicio;

    @GetMapping
    public List<Pelicula> listar() {
        return servicio.obtenerTodas();
    }

    @PostMapping
    public ResponseEntity<Pelicula> guardar(@Valid @RequestBody Pelicula pelicula) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardar(pelicula));
    }
}
