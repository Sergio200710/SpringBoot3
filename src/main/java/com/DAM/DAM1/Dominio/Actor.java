package com.DAM.DAM1.Dominio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    @PositiveOrZero(message = "El id no puede ser negativo")
    private long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 80, message = "El nombre no puede superar 80 caracteres")
    private String nombre;

    @NotBlank(message = "La nacionalidad es obligatoria")
    @Size(max = 80, message = "La nacionalidad no puede superar 80 caracteres")
    private String nacionalidad;
}
