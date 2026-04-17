package com.DAM.DAM1.Controlador;

import com.DAM.DAM1.Dominio.Alumnos;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoController {

    private final List<Alumnos> alumnos = new ArrayList<>();

    public AlumnoController() {
        alumnos.add(new Alumnos("Sergio", "Hidalgo", 18));
        alumnos.add(new Alumnos("Lucia", "Martin", 19));
    }

    @GetMapping({"/mostrar-alumno", "/alumno/primero"})
    public Alumnos mostrarAlumno() {
        return alumnos.getFirst();
    }

    @GetMapping({"/alumno", "/alumnos"})
    public List<Alumnos> obtenerAlumnos() {
        return alumnos;
    }

    @PostMapping({"/alumno", "/alumnos"})
    public ResponseEntity<Alumnos> guardarAlumno(@Valid @RequestBody Alumnos alumno) {
        alumnos.add(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumno);
    }
}
