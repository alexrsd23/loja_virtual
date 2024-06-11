package com.rosendo.loja_virtual.domain.usuario;

import com.rosendo.loja_virtual.config.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_Usuario")
public class Usuario implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    @Column(unique = true)
    private String email;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Temporal(TemporalType.DATE)
    private LocalDate dataSenha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_usuario_role")
    private List<Role> roles = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Usuario() {
    }

    public Usuario(CadastroUsuarioDTO cadastroUsuarioDTO, Role role) {
        this.email = cadastroUsuarioDTO.getEmail();
        this.login = cadastroUsuarioDTO.getLogin();
        this.senha = cadastroUsuarioDTO.getSenha();
        this.roles.add(role);
    }

    public void AtualizarLoginUsuario(AtualizarLoginUsuarioDTO dto) {
        this.login = dto.getLogin();
    }

    public void AtualizarSenhaUsuario(AtualizarSenhaUsuarioDTO dto){
        this.senha = dto.getSenha();
    }

    public void AtualizarEmailUsuario(AtualizarEmailUsuarioDTO dto){
        this.email = dto.getEmail();
    }

}