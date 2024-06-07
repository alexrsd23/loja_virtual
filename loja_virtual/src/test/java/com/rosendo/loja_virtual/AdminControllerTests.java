package com.rosendo.loja_virtual;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rosendo.loja_virtual.domain.usuario.CadastroUsuarioDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

@SpringBootTest
public class AdminControllerTests {
    @Autowired
    private WebApplicationContext wac;
    private CadastroUsuarioDTO cadastroUsuarioDTO;

    @Test
    public void deveSalvarAdministradorNoBancoDeDados() throws JsonProcessingException, Exception {
        DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(wac);
        MockMvc mockMvc = mockMvcBuilder.build();

        cadastroUsuarioDTO = new CadastroUsuarioDTO();
        cadastroUsuarioDTO.setDataSenha(LocalDate.now());
        cadastroUsuarioDTO.setLogin("Carlos");
        cadastroUsuarioDTO.setEmail("carlosteste@email.com");
        cadastroUsuarioDTO.setSenha("Cont@12345");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        ResultActions retornoDaApi = mockMvc
                        .perform(MockMvcRequestBuilders
                        .post("/v1/admin/criarAdministrador")
                        .content(objectMapper.writeValueAsString(cadastroUsuarioDTO))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON));

        System.out.println(retornoDaApi.andReturn().getResponse().getContentAsString());
    }
}
