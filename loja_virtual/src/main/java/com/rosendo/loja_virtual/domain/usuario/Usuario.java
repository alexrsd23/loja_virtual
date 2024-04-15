package com.rosendo.loja_virtual.domain.usuario;

import com.rosendo.loja_virtual.config.role.Role;
import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Temporal(TemporalType.DATE)
    private LocalDate dataSenha;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_usuario_role",
            uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "role_id"}, name = "unique_role_user"),
            joinColumns = @JoinColumn(
                    name = "usuario_id",
                    referencedColumnName = "id",
                    table = "tb_Usuario",
                    unique = false,
                    foreignKey = @ForeignKey(
                            name = "usuario_fk",
                            value = ConstraintMode.CONSTRAINT
                    )),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id",
                    table = "tb_Role",
                    unique = false,
                    foreignKey = @ForeignKey(
                            name = "role_fk",
                            value = ConstraintMode.CONSTRAINT
                    ))
    )
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
}
