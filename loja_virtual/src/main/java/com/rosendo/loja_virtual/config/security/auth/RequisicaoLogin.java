package com.rosendo.loja_virtual.config.security.auth;

public class RequisicaoLogin {
    private String login;
    private String senha;

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

    public RequisicaoLogin() {
    }

    public RequisicaoLogin(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
}
