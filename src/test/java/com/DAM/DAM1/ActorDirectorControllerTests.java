package com.DAM.DAM1;

import com.DAM.DAM1.Controlador.ActorController;
import com.DAM.DAM1.Controlador.DirectorController;
import com.DAM.DAM1.Controlador.GlobalExceptionHandler;
import com.DAM.DAM1.Dominio.Actor;
import com.DAM.DAM1.Servicio.ActorServicio;
import com.DAM.DAM1.Servicio.DirectorServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ActorDirectorControllerTests {

    @Mock
    private ActorServicio actorServicio;

    @Mock
    private DirectorServicio directorServicio;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(
                        new ActorController(actorServicio),
                        new DirectorController(directorServicio))
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    void laRutaActorGuardaUnActorValido() throws Exception {
        Actor actorGuardado = new Actor(1L, "Morgan Freeman", "Estadounidense", null);
        Mockito.when(actorServicio.guardar(Mockito.any(Actor.class))).thenReturn(actorGuardado);

        mockMvc.perform(post("/actores")
                        .contentType("application/json")
                        .content("""
                                {
                                  "nombre": "Morgan Freeman",
                                  "nacionalidad": "Estadounidense"
                                }
                                """))
                .andExpect(status().isCreated());
    }

    @Test
    void laRutaDirectorRechazaUnDirectorNoValido() throws Exception {
        mockMvc.perform(post("/directores")
                        .contentType("application/json")
                        .content("""
                                {
                                  "nombre": "",
                                  "edad": 0
                                }
                                """))
                .andExpect(status().isBadRequest());
    }
}
