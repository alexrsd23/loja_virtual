package com.rosendo.loja_virtual.repository.avaliacaoProdutoRepository;

import com.rosendo.loja_virtual.domain.avaliacaoProduto.AvaliacaoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoProdutoRepository extends JpaRepository<AvaliacaoProduto, Long> {
}
