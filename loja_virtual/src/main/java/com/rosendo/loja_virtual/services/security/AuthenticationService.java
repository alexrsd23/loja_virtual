package com.rosendo.loja_virtual.services.security;

import com.rosendo.loja_virtual.config.security.JwtService;
import com.rosendo.loja_virtual.config.security.auth.AuthenticationResponse;
import com.rosendo.loja_virtual.config.security.auth.RequisicaoLogin;
import com.rosendo.loja_virtual.domain.usuario.DetalhesUsuarioDTO;
import com.rosendo.loja_virtual.domain.usuario.Usuario;
import com.rosendo.loja_virtual.domain.usuario.exceptions.CredenciaisInvalidasException;
import com.rosendo.loja_virtual.repository.usuarioRepository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

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
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);
        authenticationResponse.setUsuario(new DetalhesUsuarioDTO(usuarioAutenticado));
        return authenticationResponse;
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
