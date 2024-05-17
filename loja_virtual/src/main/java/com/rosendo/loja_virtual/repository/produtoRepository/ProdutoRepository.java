package com.rosendo.loja_virtual.repository.produtoRepository;

import com.rosendo.loja_virtual.domain.produto.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
}
