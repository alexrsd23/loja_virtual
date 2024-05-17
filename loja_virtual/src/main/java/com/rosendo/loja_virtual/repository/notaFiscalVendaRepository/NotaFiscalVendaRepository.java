package com.rosendo.loja_virtual.repository.notaFiscalVendaRepository;

import com.rosendo.loja_virtual.domain.notaFiscalVenda.NotaFiscalVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalVendaRepository extends JpaRepository<NotaFiscalVenda, Long> {
}
