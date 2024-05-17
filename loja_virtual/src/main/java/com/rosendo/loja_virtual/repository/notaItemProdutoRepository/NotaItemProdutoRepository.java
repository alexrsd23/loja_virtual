package com.rosendo.loja_virtual.repository.notaItemProdutoRepository;

import com.rosendo.loja_virtual.domain.notaItemProduto.NotaItemProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaItemProdutoRepository extends JpaRepository<NotaItemProduto, Long> {
}
