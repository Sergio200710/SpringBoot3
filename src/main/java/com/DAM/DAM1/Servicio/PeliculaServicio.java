package com.DAM.DAM1.Servicio;

import com.DAM.DAM1.Dominio.Pelicula;
import com.DAM.DAM1.Repositorio.PeliculaRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PeliculaServicio {

    private final PeliculaRepository repositorio;

    public List<Pelicula> obtenerTodas() {
        return repositorio.findAll();
    }

    public Pelicula guardar(Pelicula pelicula) {
        return repositorio.save(pelicula);
    }
}
