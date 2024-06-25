package com.rosendo.loja_virtual.services.usuarioService;

import com.rosendo.loja_virtual.config.role.Role;
import com.rosendo.loja_virtual.config.role.RoleName;
import com.rosendo.loja_virtual.domain.usuario.*;
import com.rosendo.loja_virtual.domain.usuario.exceptions.PropriaContaException;
import com.rosendo.loja_virtual.repository.roleRepository.RoleRepository;
import com.rosendo.loja_virtual.repository.usuarioRepository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public Usuario salvarAdmin(CadastroUsuarioDTO dto) {
        return salvar(dto, roleRepository.findByRoleName(RoleName.ROLE_ADMIN));
    }

    @Transactional
    public Usuario salvarUsuario(CadastroUsuarioDTO dto) {
        return salvar(dto, roleRepository.findByRoleName(RoleName.ROLE_USER));
    }

    private Usuario salvar(CadastroUsuarioDTO dto , Optional<Role> role){
        Usuario usuario = new Usuario(dto, role
                .orElseThrow( () -> new EntityNotFoundException("Perfil não encontrado.")));
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setDataSenha(LocalDate.now());
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return usuarioSalvo;
    }

    public Page<Usuario> listarUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
    }

    public Page<Usuario> buscarPorPerfil(RoleName name, Integer page, Integer size, String sort) {

        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
            return usuarioRepository.findUsuarioByRole(name, pageable);
        } catch (Exception e) {
            throw new InvalidDataAccessApiUsageException("Parâmetros de paginação incorretos");
        }

    }

    public void tornarAdmin(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entidade não encontrada")
        );

        usuario.getRoles().clear();
        usuario.getRoles().add(roleRepository.findByRoleName(RoleName.ROLE_ADMIN).get());
        usuarioRepository.save(usuario);
    }

    public Usuario atualizarLoginUsuario(Long id,
                                         AtualizarLoginUsuarioDTO atualizarLoginUsuarioDTO) {
        Usuario usuario = this.buscarUsuarioPorId(id);
        usuario.AtualizarLoginUsuario(atualizarLoginUsuarioDTO);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarSenhaUsuario(Long id,
                                         AtualizarSenhaUsuarioDTO atualizarSenhaUsuarioDTO) {
        Usuario usuario = this.buscarUsuarioPorId(id);
        usuario.AtualizarSenhaUsuario(atualizarSenhaUsuarioDTO);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarEmailUsuario(Long id,
                                         AtualizarEmailUsuarioDTO atualizarEmailUsuarioDTO) {
        Usuario usuario = this.buscarUsuarioPorId(id);
        usuario.AtualizarEmailUsuario(atualizarEmailUsuarioDTO);
        return usuarioRepository.save(usuario);
    }

    private Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("Usuário não encontrado.")
        );
    }

    @Transactional
    public void deletar(Long id) {
        String nomeUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entidade não encontrada")
        );

        if (usuario.getLogin().equals(nomeUsuario)) {
            throw new PropriaContaException("Impossível deletar a própria conta.");
        }

        usuarioRepository.delete(usuario);
    }
}