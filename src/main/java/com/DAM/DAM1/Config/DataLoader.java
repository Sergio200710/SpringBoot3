package com.DAM.DAM1.Config;

import com.DAM.DAM1.Dominio.Actor;
import com.DAM.DAM1.Dominio.Director;
import com.DAM.DAM1.Dominio.Pelicula;
import com.DAM.DAM1.Dominio.Alumnos;
import com.DAM.DAM1.Repositorio.AlumnoRepository;
import com.DAM.DAM1.Repositorio.ActorRepository;
import com.DAM.DAM1.Repositorio.DirectorRepository;
import com.DAM.DAM1.Repositorio.PeliculaRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final PeliculaRepository peliculaRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final AlumnoRepository alumnoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Cargar Alumno si no existe
        if (alumnoRepository.count() == 0) {
            alumnoRepository.save(new Alumnos(null, "Sergio", "Hidalgo", 18));
            System.out.println("Alumno inicial cargado.");
        }

        if (peliculaRepository.count() == 0) {
            // Crear 10 Directores
            Director d1 = directorRepository.save(new Director(null, "Quentin Tarantino", 60, null));
            Director d2 = directorRepository.save(new Director(null, "Christopher Nolan", 53, null));
            Director d3 = directorRepository.save(new Director(null, "Steven Spielberg", 77, null));
            Director d4 = directorRepository.save(new Director(null, "Martin Scorsese", 81, null));
            Director d5 = directorRepository.save(new Director(null, "Stanley Kubrick", 70, null));
            Director d6 = directorRepository.save(new Director(null, "Francis Ford Coppola", 84, null));
            Director d7 = directorRepository.save(new Director(null, "Alfred Hitchcock", 80, null));
            Director d8 = directorRepository.save(new Director(null, "Ridley Scott", 86, null));
            Director d9 = directorRepository.save(new Director(null, "David Fincher", 61, null));
            Director d10 = directorRepository.save(new Director(null, "James Cameron", 69, null));

            // Crear 10 Actores
            Actor a1 = actorRepository.save(new Actor(null, "Leonardo DiCaprio", "Estados Unidos", null));
            Actor a2 = actorRepository.save(new Actor(null, "Christian Bale", "Reino Unido", null));
            Actor a3 = actorRepository.save(new Actor(null, "Tom Hanks", "Estados Unidos", null));
            Actor a4 = actorRepository.save(new Actor(null, "Robert De Niro", "Estados Unidos", null));
            Actor a5 = actorRepository.save(new Actor(null, "Al Pacino", "Estados Unidos", null));
            Actor a6 = actorRepository.save(new Actor(null, "Jack Nicholson", "Estados Unidos", null));
            Actor a7 = actorRepository.save(new Actor(null, "Brad Pitt", "Estados Unidos", null));
            Actor a8 = actorRepository.save(new Actor(null, "Morgan Freeman", "Estados Unidos", null));
            Actor a9 = actorRepository.save(new Actor(null, "Anthony Hopkins", "Reino Unido", null));
            Actor a10 = actorRepository.save(new Actor(null, "Harrison Ford", "Estados Unidos", null));

            // Crear 10 Películas
            peliculaRepository.save(new Pelicula(null, "Pulp Fiction", d1, List.of(a1, a7), 1994));
            peliculaRepository.save(new Pelicula(null, "Inception", d2, List.of(a1), 2010));
            peliculaRepository.save(new Pelicula(null, "The Dark Knight", d2, List.of(a2, a8), 2008));
            peliculaRepository.save(new Pelicula(null, "Schindler's List", d3, List.of(a3), 1993));
            peliculaRepository.save(new Pelicula(null, "Goodfellas", d4, List.of(a4), 1990));
            peliculaRepository.save(new Pelicula(null, "The Shining", d5, List.of(a6), 1980));
            peliculaRepository.save(new Pelicula(null, "The Godfather", d6, List.of(a5, a4), 1972));
            peliculaRepository.save(new Pelicula(null, "Psycho", d7, List.of(a9), 1960));
            peliculaRepository.save(new Pelicula(null, "Blade Runner", d8, List.of(a10), 1982));
            peliculaRepository.save(new Pelicula(null, "Se7en", d9, List.of(a7, a8), 1995));
            peliculaRepository.save(new Pelicula(null, "Avatar", d10, List.of(a1), 2009));

            System.out.println("Datos de películas, directores y actores cargados correctamente.");
        } else {
            System.out.println("ℹ️  La base de datos ya contiene datos. DataLoader omitido.");
        }
    }
}
