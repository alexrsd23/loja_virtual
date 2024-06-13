package com.rosendo.loja_virtual;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rosendo.loja_virtual.config.defaultMessages.DefaultMessages;
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

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
        cadastroUsuarioDTO.setLogin("Virginia");
        cadastroUsuarioDTO.setEmail("Virginiateste@email.com");
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

    @Test
    public void deveRetornarMensagemDeSucessoQuandoAdministradorForSalvoNoBancoDeDados() throws JsonProcessingException, Exception {
        DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(wac);
        MockMvc mockMvc = mockMvcBuilder.build();

        cadastroUsuarioDTO = new CadastroUsuarioDTO();
        cadastroUsuarioDTO.setDataSenha(LocalDate.now());
        cadastroUsuarioDTO.setLogin("Marcia");
        cadastroUsuarioDTO.setEmail("marcia@email.com");
        cadastroUsuarioDTO.setSenha("Cont@12345");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        ResultActions retornoDaApi = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/admin/criarAdministrador")
                        .content(objectMapper.writeValueAsString(cadastroUsuarioDTO))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON));

        String mensagemEsperada = DefaultMessages.getMensagemCriacaoSucesso("Administrador");

        retornoDaApi
                .andExpect(jsonPath("$.mensagem", equalTo(mensagemEsperada)))
                .andExpect(status().isCreated());
    }

    @Test
    public void deveRetornarErroQuandoCadastrarEmailRepetido() throws JsonProcessingException, Exception {
        DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(wac);
        MockMvc mockMvc = mockMvcBuilder.build();

        cadastroUsuarioDTO = new CadastroUsuarioDTO();
        cadastroUsuarioDTO.setDataSenha(LocalDate.now());
        cadastroUsuarioDTO.setLogin("MarciaFarias");
        cadastroUsuarioDTO.setEmail("marcia@email.com");
        cadastroUsuarioDTO.setSenha("Cont@12345");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String mensagemEsperada = "Erro: O email informado já existe.";

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/admin/criarAdministrador")
                        .content(objectMapper.writeValueAsString(cadastroUsuarioDTO))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.message", equalTo(mensagemEsperada)));

    }


    @Test
    public void deveRetornarErroQuandoLoginRepetido() throws JsonProcessingException, Exception {
        DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(wac);
        MockMvc mockMvc = mockMvcBuilder.build();

        cadastroUsuarioDTO = new CadastroUsuarioDTO();
        cadastroUsuarioDTO.setDataSenha(LocalDate.now());
        cadastroUsuarioDTO.setLogin("MarciaFreitas");
        cadastroUsuarioDTO.setEmail("marciafreitas@email.com");
        cadastroUsuarioDTO.setSenha("Cont@12345");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String mensagemEsperada = "Erro: O login informado já existe.";

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/admin/criarAdministrador")
                        .content(objectMapper.writeValueAsString(cadastroUsuarioDTO))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.message", equalTo(mensagemEsperada)));
    }

    @Test
    @WithMockUser(username = "Marcia", roles = {"ADMIN"})
    public void deveDeletarAdministrador() throws Exception {
        DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(wac);
        MockMvc mockMvc = mockMvcBuilder.build();

        Long adminId = 45L; // ID do administrador a ser deletado

        String mensagemEsperada = "Requisição completa: Usuário foi removido com sucesso!";

        // Simula o contexto de segurança
        MockedStatic<SecurityContextHolder> securityContextHolder = Mockito.mockStatic(SecurityContextHolder.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Authentication authentication = Mockito.mock(Authentication.class);

        securityContextHolder.when(SecurityContextHolder::getContext).thenReturn(securityContext);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getName()).thenReturn("Marcia");

        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/v1/admin/deletar")
                            .param("id", adminId.toString())
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.mensagem", equalTo(mensagemEsperada)));
        } finally {
            securityContextHolder.close();
        }
    }

}
