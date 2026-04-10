package com.example.Proyecto1oDAM.Controlador;

import com.example.Proyecto1oDAM.Dominio.Alumnos;
import com.example.Proyecto1oDAM.Repositorio.AlumnoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoController {

    private final AlumnoRepository alumnoRepository;

    public AlumnoController(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @GetMapping("/")
    public String mostrarNombreAlumno() {
        Alumnos alumno = alumnoRepository.findFirstByOrderByIdAsc();
        String nombreAlumno = alumno != null ? alumno.getNombre() : "Sergio";
        return "El nombre del alumno es " + nombreAlumno;
    }

    @GetMapping("/alumno-java")
    public String mostrarNombreAlumnoJava() {
        // Alumno creado en Java usando tu clase
        Alumnos alumno = new Alumnos("Sergio", "Ejemplo", 25);
        return "¡Funciona! El alumno creado con clases de Java es: " + alumno.getNombre() + " " + alumno.getApellido();
    }
}
