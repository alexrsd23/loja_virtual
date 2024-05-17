package com.rosendo.loja_virtual.repository.pessoaFisicaRepository;

import com.rosendo.loja_virtual.domain.pessoaFisica.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
}
