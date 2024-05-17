package com.rosendo.loja_virtual.repository.categoriaProdutoRepository;

import com.rosendo.loja_virtual.domain.categoriaProduto.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {
}
