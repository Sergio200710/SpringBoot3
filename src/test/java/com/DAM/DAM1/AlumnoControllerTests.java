package com.DAM.DAM1;

import com.DAM.DAM1.Controlador.AlumnoController;
import com.DAM.DAM1.Controlador.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AlumnoControllerTests {

    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new AlumnoController())
            .setControllerAdvice(new GlobalExceptionHandler())
            .build();

    @Test
    void laRutaMostrarAlumnoDevuelveElAlumnoEnJson() throws Exception {
        mockMvc.perform(get("/mostrar-alumno"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                          "nombre": "Sergio",
                          "apellido": "Hidalgo",
                          "edad": 18
                        }
                        """));
    }

    @Test
    void laRutaAlumnosGuardaUnAlumnoValido() throws Exception {
        mockMvc.perform(post("/alumnos")
                        .contentType("application/json")
                        .content("""
                                {
                                  "nombre": "Carlos",
                                  "apellido": "Ruiz",
                                  "edad": 20
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                        {
                          "nombre": "Carlos",
                          "apellido": "Ruiz",
                          "edad": 20
                        }
                        """));
    }

    @Test
    void laRutaAlumnosRechazaUnAlumnoNoValido() throws Exception {
        mockMvc.perform(post("/alumnos")
                        .contentType("application/json")
                        .content("""
                                {
                                  "nombre": "",
                                  "apellido": "",
                                  "edad": 0
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("""
                        {
                          "mensaje": "Solicitud no valida",
                          "errores": {
                            "nombre": "El nombre es obligatorio",
                            "apellido": "El apellido es obligatorio",
                            "edad": "La edad debe ser mayor que 0"
                          }
                        }
                        """));
    }
}
