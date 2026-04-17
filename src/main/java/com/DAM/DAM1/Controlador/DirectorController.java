package com.DAM.DAM1.Controlador;

import com.DAM.DAM1.Dominio.Director;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectorController {

    private final List<Director> directores = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(3);

    public DirectorController() {
        directores.add(new Director(1L, "Christopher Nolan", 54));
        directores.add(new Director(2L, "Pedro Almodovar", 75));
    }

    @GetMapping({"/director", "/directores"})
    public List<Director> obtenerDirector() {
        return directores;
    }

    @PostMapping({"/director", "/directores"})
    public ResponseEntity<Director> guardarDirector(@Valid @RequestBody Director director) {
        if (director.getId() == 0) {
            director.setId(nextId.getAndIncrement());
        }
        directores.add(director);
        return ResponseEntity.status(HttpStatus.CREATED).body(director);
    }
}
