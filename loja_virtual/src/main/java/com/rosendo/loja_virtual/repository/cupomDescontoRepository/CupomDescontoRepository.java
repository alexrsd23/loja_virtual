package com.rosendo.loja_virtual.repository.cupomDescontoRepository;

import com.rosendo.loja_virtual.domain.cupomDesconto.CupomDesconto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomDescontoRepository extends JpaRepository<CupomDesconto, Long> {
}
