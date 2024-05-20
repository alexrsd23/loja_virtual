package com.rosendo.loja_virtual.domain.usuario;

import com.rosendo.loja_virtual.config.role.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DetalhesUsuarioDTO {
    private Long id;
    private String email;
    private String login;
    private String senha;
    private LocalDate dataSenha;
    private List<Role> roles = new ArrayList<>();

    public DetalhesUsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.dataSenha = usuario.getDataSenha();
        this.roles = usuario.getRoles();
    }
}
