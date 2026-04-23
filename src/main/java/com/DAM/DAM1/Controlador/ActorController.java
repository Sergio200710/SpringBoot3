package com.DAM.DAM1.Controlador;

import com.DAM.DAM1.Dominio.Actor;
import com.DAM.DAM1.Servicio.ActorServicio;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actores")
@AllArgsConstructor
public class ActorController {

    private final ActorServicio servicio;

    @GetMapping
    public List<Actor> listar() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Actor> guardar(@Valid @RequestBody Actor actor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardar(actor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> actualizar(@PathVariable Long id, @Valid @RequestBody Actor actor) {
        try {
            return ResponseEntity.ok(servicio.actualizar(id, actor));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
