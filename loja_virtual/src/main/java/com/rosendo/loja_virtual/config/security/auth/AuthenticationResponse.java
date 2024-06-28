package com.rosendo.loja_virtual.config.security.auth;

import com.rosendo.loja_virtual.domain.usuario.DetalhesUsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private DetalhesUsuarioDTO usuario;
    private String token;
}
