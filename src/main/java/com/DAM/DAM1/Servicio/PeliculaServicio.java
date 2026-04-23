package com.DAM.DAM1.Servicio;

import com.DAM.DAM1.Dominio.Pelicula;
import com.DAM.DAM1.Repositorio.PeliculaRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PeliculaServicio {

    private final PeliculaRepository repositorio;

    public List<Pelicula> obtenerTodas() {
        return repositorio.findAll();
    }

    public Optional<Pelicula> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public Pelicula guardar(Pelicula pelicula) {
        return repositorio.save(pelicula);
    }
    
    public Pelicula actualizar(Long id, Pelicula detalle) {
        return repositorio.findById(id).map(pelicula -> {
            pelicula.setTitulo(detalle.getTitulo());
            pelicula.setDirector(detalle.getDirector());
            pelicula.setActores(detalle.getActores());
            pelicula.setAnio(detalle.getAnio());
            return repositorio.save(pelicula);
        }).orElseThrow(() -> new RuntimeException("Película no encontrada con id " + id));
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
