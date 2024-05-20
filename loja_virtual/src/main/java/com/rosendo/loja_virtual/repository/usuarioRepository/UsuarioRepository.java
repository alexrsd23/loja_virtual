package com.rosendo.loja_virtual.repository.usuarioRepository;

import com.rosendo.loja_virtual.config.role.RoleName;
import com.rosendo.loja_virtual.domain.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u " +
            "FROM Usuario u " +
            "WHERE u.login = :login"
    )
    Optional<Usuario> findByUsername(String login);

    List<Usuario> findByEmail(String email);

    Page<Usuario> findByRolesRoleName(RoleName roleName, Pageable pageable);

    @Query("SELECT u "
            + "FROM Usuario u "
            + "JOIN u.roles r "
            + "WHERE r.roleName = :roleName")
    Page<Usuario> findUsuarioByRole(RoleName roleName, Pageable pageable);
}
