package com.DAM.DAM1.Repositorio;

import com.DAM.DAM1.Dominio.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
