package com.DAM.DAM1.Servicio;

import com.DAM.DAM1.Dominio.Director;
import com.DAM.DAM1.Repositorio.DirectorRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DirectorServicio {

    private final DirectorRepository repositorio;

    public List<Director> obtenerTodos() {
        return repositorio.findAll();
    }

    public Optional<Director> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public Director guardar(Director director) {
        return repositorio.save(director);
    }
    
    public Director actualizar(Long id, Director detalle) {
        return repositorio.findById(id).map(director -> {
            director.setNombre(detalle.getNombre());
            director.setEdad(detalle.getEdad());
            return repositorio.save(director);
        }).orElseThrow(() -> new RuntimeException("Director no encontrado con id " + id));
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
