package com.rosendo.loja_virtual.repository.contaReceberRepository;

import com.rosendo.loja_virtual.domain.contaReceber.ContaReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaReceberRepository extends JpaRepository<ContaReceber, Long> {
}
