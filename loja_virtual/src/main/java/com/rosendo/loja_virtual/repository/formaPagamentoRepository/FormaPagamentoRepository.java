package com.rosendo.loja_virtual.repository.formaPagamentoRepository;

import com.rosendo.loja_virtual.domain.cupomDesconto.CupomDesconto;
import com.rosendo.loja_virtual.domain.formaPagamento.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}
