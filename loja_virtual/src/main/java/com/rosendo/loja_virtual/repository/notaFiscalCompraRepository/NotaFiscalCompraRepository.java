package com.rosendo.loja_virtual.repository.notaFiscalCompraRepository;

import com.rosendo.loja_virtual.domain.notaFiscalCompra.NotaFiscalCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalCompraRepository extends JpaRepository<NotaFiscalCompra, Long> {
}
