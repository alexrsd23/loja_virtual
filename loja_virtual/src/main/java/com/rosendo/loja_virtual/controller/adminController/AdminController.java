package com.rosendo.loja_virtual.controller.adminController;

import com.rosendo.loja_virtual.config.defaultMessages.DefaultMessages;
import com.rosendo.loja_virtual.config.defaultMessages.MensagemResposta;
import com.rosendo.loja_virtual.config.role.RoleName;
import com.rosendo.loja_virtual.domain.usuario.CadastroUsuarioDTO;
import com.rosendo.loja_virtual.domain.usuario.DetalhesUsuarioDTO;
import com.rosendo.loja_virtual.domain.usuario.Usuario;
import com.rosendo.loja_virtual.services.usuarioService.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@RestController
@Controller
@RequestMapping("/v1/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    @Autowired
    private UsuarioService usuarioService;


    @DeleteMapping("/deletar")
    public ResponseEntity<MensagemResposta> deletar(@RequestParam(value="id", required=true) Long id) {
        usuarioService.deletar(id);
        String mensagem = DefaultMessages.getMensagemRemocaoSucesso("Usuário");
        MensagemResposta resposta = new MensagemResposta(mensagem);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/buscarTodosAdmin")
    public ResponseEntity<Page<DetalhesUsuarioDTO>> buscarTodosAdmin(
            @RequestParam(value="page", required=false, defaultValue="0") Integer page,
            @RequestParam (value="size", required=false, defaultValue="10") Integer size,
            @RequestParam (value="sort", required=false, defaultValue="nome") String sort
    ){

        Page<DetalhesUsuarioDTO> pageAdmins = usuarioService.buscarPorPerfil(RoleName.ROLE_ADMIN, page, size, sort)
                .map(DetalhesUsuarioDTO::new);

        return ResponseEntity.ok(pageAdmins);
    }

    @GetMapping("/buscarTodosUsuarios")
    public ResponseEntity<Page<DetalhesUsuarioDTO>> buscarTodosUsuarios(
            @RequestParam (value="page", required=false, defaultValue="0") Integer page,
            @RequestParam (value="size", required=false, defaultValue="10") Integer size,
            @RequestParam (value="sort", required=false, defaultValue="nome") String sort) {

        Page<DetalhesUsuarioDTO> pageUsuarios = usuarioService.buscarPorPerfil(RoleName.ROLE_USER, page, size, sort)
                .map(DetalhesUsuarioDTO::new);

        return ResponseEntity.ok(pageUsuarios);
    }

    @PostMapping("/criarAdministrador")
    public ResponseEntity<MensagemResposta> salvarAdmin(@RequestBody @Valid CadastroUsuarioDTO dto){
        Usuario usuario = usuarioService.salvarAdmin(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();

        String mensagem = DefaultMessages.getMensagemCriacaoSucesso("Administrador");
        MensagemResposta resposta = new MensagemResposta(mensagem);
        return ResponseEntity.created(uri).body(resposta);
    }

    @PatchMapping("/tornarAdmin")
    public ResponseEntity<MensagemResposta> tornarAdmin(@RequestParam(value="id", required=true) Long id) {
        usuarioService.tornarAdmin(id);

        String mensagem = DefaultMessages.getMensagemAtualizacaoSucesso("Usuário");
        MensagemResposta resposta = new MensagemResposta(mensagem);
        return ResponseEntity.ok(resposta);
    }
}