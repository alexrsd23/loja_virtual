package com.rosendo.loja_virtual.services.security;

import com.rosendo.loja_virtual.config.security.JwtService;
import com.rosendo.loja_virtual.config.security.auth.AuthenticationResponse;
import com.rosendo.loja_virtual.config.security.auth.RequisicaoLogin;
import com.rosendo.loja_virtual.domain.usuario.DetalhesUsuarioDTO;
import com.rosendo.loja_virtual.domain.usuario.Usuario;
import com.rosendo.loja_virtual.domain.usuario.exceptions.CredenciaisInvalidasException;
import com.rosendo.loja_virtual.repository.usuarioRepository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse autenticar(RequisicaoLogin request) {
        validarCredenciais(request);

        var autenticado = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getSenha()
                )
        );
        var usuarioAutenticado = (Usuario) autenticado.getPrincipal();
        var claims = new HashMap<String, Object>();
        claims.put("email", usuarioAutenticado.getEmail());
        var jwtToken = jwtService.generateToken(claims, usuarioAutenticado);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .usuario(new DetalhesUsuarioDTO(usuarioAutenticado))
                .build();
    }
    private void validarCredenciais(RequisicaoLogin request) {
        Usuario usuario = usuarioRepository.findByUsername(request.getLogin())
                .orElseThrow(() -> new CredenciaisInvalidasException("Credenciais inválidas - Usuário não foi encontrado"));


        if (request.getSenha() == null) {
            throw new CredenciaisInvalidasException("Credenciais inválidas - Senha inválida");
        }

        if (!new BCryptPasswordEncoder().matches(request.getSenha(), usuario.getSenha())) {
            throw new CredenciaisInvalidasException("Credenciais inválidas - Senha não corresponde");
        }
    }
}
