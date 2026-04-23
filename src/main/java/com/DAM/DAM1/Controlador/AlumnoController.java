package com.DAM.DAM1.Controlador;

import com.DAM.DAM1.Dominio.Alumnos;
import com.DAM.DAM1.Servicio.AlumnoServicio;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumnos")
@AllArgsConstructor
public class AlumnoController {

    private final AlumnoServicio servicio;

    @GetMapping
    public List<Alumnos> listar() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumnos> obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alumnos> guardar(@Valid @RequestBody Alumnos alumno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardar(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumnos> actualizar(@PathVariable Long id, @Valid @RequestBody Alumnos alumno) {
        try {
            return ResponseEntity.ok(servicio.actualizar(id, alumno));
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
