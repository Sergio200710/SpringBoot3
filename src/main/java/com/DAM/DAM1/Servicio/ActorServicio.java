package com.DAM.DAM1.Servicio;

import com.DAM.DAM1.Dominio.Actor;
import com.DAM.DAM1.Repositorio.ActorRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActorServicio {

    private final ActorRepository repositorio;

    public List<Actor> obtenerTodos() {
        return repositorio.findAll();
    }

    public Optional<Actor> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public Actor guardar(Actor actor) {
        return repositorio.save(actor);
    }
    
    public Actor actualizar(Long id, Actor detalle) {
        return repositorio.findById(id).map(actor -> {
            actor.setNombre(detalle.getNombre());
            actor.setNacionalidad(detalle.getNacionalidad());
            return repositorio.save(actor);
        }).orElseThrow(() -> new RuntimeException("Actor no encontrado con id " + id));
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
