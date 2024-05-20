package com.rosendo.loja_virtual.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public class AtualizarEmailUsuarioDTO {
    @NotBlank(message = "email é necessário.")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
