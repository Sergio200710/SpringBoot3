package com.example.Proyecto1oDAM;

import com.example.Proyecto1oDAM.Dominio.Alumnos;
import com.example.Proyecto1oDAM.Repositorio.AlumnoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

// Clase desactivada como punto de arranque (ver DAM1Aplication)
// @SpringBootApplication
public class Proyecto1oDamApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto1oDamApplication.class, args);
	}

	@Bean
	CommandLineRunner cargarAlumnoInicial(AlumnoRepository alumnoRepository) {
		return args -> {
			if (alumnoRepository.count() == 0) {
				alumnoRepository.save(new Alumnos("Sergio", "Garcia", 20));
			}
		};
	}
}
