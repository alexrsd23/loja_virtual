package com.rosendo.loja_virtual.config.security.auth;

import com.rosendo.loja_virtual.domain.usuario.DetalhesUsuarioDTO;

public class AuthenticationResponse {
    private DetalhesUsuarioDTO usuario;
    private String token;

    public DetalhesUsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(DetalhesUsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(DetalhesUsuarioDTO usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }
}
