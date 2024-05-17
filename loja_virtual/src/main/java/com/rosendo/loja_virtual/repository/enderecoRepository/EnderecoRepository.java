package com.rosendo.loja_virtual.repository.enderecoRepository;

import com.rosendo.loja_virtual.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
