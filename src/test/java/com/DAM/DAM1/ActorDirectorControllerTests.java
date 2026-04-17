package com.DAM.DAM1;

import com.DAM.DAM1.Controlador.ActorController;
import com.DAM.DAM1.Controlador.DirectorController;
import com.DAM.DAM1.Controlador.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ActorDirectorControllerTests {

    private final MockMvc mockMvc = MockMvcBuilders
            .standaloneSetup(new ActorController(), new DirectorController())
            .setControllerAdvice(new GlobalExceptionHandler())
            .build();

    @Test
    void laRutaActorGuardaUnActorValido() throws Exception {
        mockMvc.perform(post("/actor")
                        .contentType("application/json")
                        .content("""
                                {
                                  "id": 0,
                                  "nombre": "Morgan Freeman",
                                  "nacionalidad": "Estadounidense"
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                        {
                          "id": 3,
                          "nombre": "Morgan Freeman",
                          "nacionalidad": "Estadounidense"
                        }
                        """));
    }

    @Test
    void laRutaDirectorRechazaUnDirectorNoValido() throws Exception {
        mockMvc.perform(post("/director")
                        .contentType("application/json")
                        .content("""
                                {
                                  "id": -1,
                                  "nombre": "",
                                  "edad": 0
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("""
                        {
                          "mensaje": "Solicitud no valida",
                          "errores": {
                            "id": "El id no puede ser negativo",
                            "nombre": "El nombre es obligatorio",
                            "edad": "La edad debe ser mayor que 0"
                          }
                        }
                        """));
    }
}
