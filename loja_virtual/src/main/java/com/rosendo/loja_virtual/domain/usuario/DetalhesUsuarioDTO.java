package com.rosendo.loja_virtual.domain.usuario;

import com.rosendo.loja_virtual.config.role.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DetalhesUsuarioDTO {
    private Long id;
    private String email;
    private String login;
    private LocalDate dataSenha;
    private List<Role> roles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDate getDataSenha() {
        return dataSenha;
    }

    public void setDataSenha(LocalDate dataSenha) {
        this.dataSenha = dataSenha;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public DetalhesUsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.login = usuario.getLogin();
        this.dataSenha = usuario.getDataSenha();
        this.roles = usuario.getRoles();
    }

    @Override
    public String toString() {
        return "DetalhesUsuarioDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", dataSenha=" + dataSenha +
                ", roles=" + roles +
                '}';
    }
}