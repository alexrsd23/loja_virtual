package com.rosendo.loja_virtual.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AtualizarLoginUsuarioDTO {
    @NotBlank(message = "login é necessário.")
    @Size(min = 4, max = 10, message="É necessário ter entre 4 e 10 caracteres.")
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
