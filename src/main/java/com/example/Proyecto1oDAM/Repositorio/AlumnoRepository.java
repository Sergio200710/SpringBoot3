package com.example.Proyecto1oDAM.Repositorio;

import com.example.Proyecto1oDAM.Dominio.Alumnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "alumnos", path = "alumnos")
public interface AlumnoRepository extends JpaRepository<Alumnos, Long> {
    Alumnos findFirstByOrderByIdAsc();
}
