package com.DAM.DAM1.Controlador;

import com.DAM.DAM1.Dominio.Actor;
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
public class ActorController {

    private final List<Actor> actores = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(3);

    public ActorController() {
        actores.add(new Actor(1L, "Leonardo DiCaprio", "Estadounidense"));
        actores.add(new Actor(2L, "Penelope Cruz", "Espanola"));
    }

    @GetMapping({"/actor", "/actores"})
    public List<Actor> obtenerActor() {
        return actores;
    }

    @PostMapping({"/actor", "/actores"})
    public ResponseEntity<Actor> guardarActor(@Valid @RequestBody Actor actor) {
        if (actor.getId() == 0) {
            actor.setId(nextId.getAndIncrement());
        }
        actores.add(actor);
        return ResponseEntity.status(HttpStatus.CREATED).body(actor);
    }
}
