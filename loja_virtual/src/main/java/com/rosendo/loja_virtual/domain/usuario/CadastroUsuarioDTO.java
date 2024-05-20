package com.rosendo.loja_virtual.domain.usuario;

import com.rosendo.loja_virtual.config.role.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroUsuarioDTO {
    @NotBlank(message = "email é necessário.")
    private String email;
    @NotBlank(message = "login é necessário.")
    @Size(min = 4, max = 10, message="É necessário ter entre 4 e 10 caracteres.")
    private String login;
    @NotBlank(message = "Senha é necessário.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^\\w\\s]).{10,20}$", message = "Deve conter"
            + ": números, letras minúsculas e maiúsculas, caracteres especiais e deve ter entre 10 e 20 dígitos")
    private String senha;
    private LocalDate dataSenha;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataSenha() {
        return dataSenha;
    }

    public void setDataSenha(LocalDate dataSenha) {
        this.dataSenha = dataSenha;
    }
}
