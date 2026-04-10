package com.example.Proyecto1oDAM;

import com.example.Proyecto1oDAM.Dominio.Alumnos;
import com.example.Proyecto1oDAM.Controlador.AlumnoController;
import com.example.Proyecto1oDAM.Repositorio.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlumnoController.class)
class AlumnoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AlumnoRepository alumnoRepository;

    @Test
    void laRutaRaizMuestraElNombreDelAlumno() throws Exception {
        given(alumnoRepository.findFirstByOrderByIdAsc())
                .willReturn(new Alumnos("Sergio", "Garcia", 20));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("El nombre del alumno es Sergio"));
    }
}
