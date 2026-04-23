package com.DAM.DAM1.Servicio;

import com.DAM.DAM1.Dominio.Alumnos;
import com.DAM.DAM1.Repositorio.AlumnoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlumnoServicio {

    private final AlumnoRepository repositorio;

    public List<Alumnos> obtenerTodos() {
        return repositorio.findAll();
    }

    public Optional<Alumnos> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public Alumnos guardar(Alumnos alumno) {
        return repositorio.save(alumno);
    }

    public Alumnos actualizar(Long id, Alumnos detalle) {
        return repositorio.findById(id).map(alumno -> {
            alumno.setNombre(detalle.getNombre());
            alumno.setApellido(detalle.getApellido());
            alumno.setEdad(detalle.getEdad());
            return repositorio.save(alumno);
        }).orElseThrow(() -> new RuntimeException("Alumno no encontrado con id " + id));
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
