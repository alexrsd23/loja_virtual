package com.rosendo.loja_virtual.repository.marcaProdutoRepository;

import com.rosendo.loja_virtual.domain.marcaProduto.MarcaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaProdutoRepository extends JpaRepository<MarcaProduto, Long> {
}
