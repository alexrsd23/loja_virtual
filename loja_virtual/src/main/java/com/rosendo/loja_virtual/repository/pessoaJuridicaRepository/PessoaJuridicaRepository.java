package com.rosendo.loja_virtual.repository.pessoaJuridicaRepository;

import com.rosendo.loja_virtual.domain.pessoaJuridica.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
}
