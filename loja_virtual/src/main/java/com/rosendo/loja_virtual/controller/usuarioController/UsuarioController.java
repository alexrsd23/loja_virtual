package com.rosendo.loja_virtual.controller.usuarioController;

import com.rosendo.loja_virtual.domain.usuario.CadastroUsuarioDTO;
import com.rosendo.loja_virtual.domain.usuario.DetalhesUsuarioDTO;
import com.rosendo.loja_virtual.domain.usuario.Usuario;
import com.rosendo.loja_virtual.services.usuarioService.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Controller
@RequestMapping("/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<DetalhesUsuarioDTO> salvarUsuario(@RequestBody @Valid CadastroUsuarioDTO dto){
        Usuario usuario = usuarioService.salvarUsuario(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DetalhesUsuarioDTO(usuario));
    }
}