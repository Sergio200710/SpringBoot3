package com.DAM.DAM1.Controlador;

import com.DAM.DAM1.Dominio.Director;
import com.DAM.DAM1.Servicio.DirectorServicio;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/directores")
@AllArgsConstructor
public class DirectorController {

    private final DirectorServicio servicio;

    @GetMapping
    public List<Director> listar() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Director> guardar(@Valid @RequestBody Director director) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardar(director));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> actualizar(@PathVariable Long id, @Valid @RequestBody Director director) {
        try {
            return ResponseEntity.ok(servicio.actualizar(id, director));
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
