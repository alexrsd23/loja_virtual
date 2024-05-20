package com.rosendo.loja_virtual.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AtualizarSenhaUsuarioDTO {
    @NotBlank(message = "Senha é necessário.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^\\w\\s]).{10,20}$", message = "Deve conter"
            + ": números, letras minúsculas e maiúsculas, caracteres especiais e deve ter entre 10 e 20 dígitos")
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
