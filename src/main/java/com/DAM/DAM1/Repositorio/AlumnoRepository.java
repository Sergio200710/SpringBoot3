package com.DAM.DAM1.Repositorio;

import com.DAM.DAM1.Dominio.Alumnos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumnos, Long> {
}
