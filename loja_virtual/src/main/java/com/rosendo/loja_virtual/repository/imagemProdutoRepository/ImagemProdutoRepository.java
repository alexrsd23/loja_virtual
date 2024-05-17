package com.rosendo.loja_virtual.repository.imagemProdutoRepository;

import com.rosendo.loja_virtual.domain.imagemProduto.ImagemProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemProdutoRepository extends JpaRepository<ImagemProduto, Long> {
}
