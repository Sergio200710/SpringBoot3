package com.DAM.DAM1.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "Pelicula")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El titulo es obligatorio")
    @Size(max = 120, message = "El titulo no puede superar 120 caracteres")
    private String titulo;

    @NotBlank(message = "El director es obligatorio")
    @Size(max = 80, message = "El director no puede superar 80 caracteres")
    private String director;

    @Min(value = 1888, message = "El anio no es valido")
    @Max(value = 2100, message = "El anio no es valido")
    private Integer anio;
}
