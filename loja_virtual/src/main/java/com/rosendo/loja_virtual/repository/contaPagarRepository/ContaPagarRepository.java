package com.rosendo.loja_virtual.repository.contaPagarRepository;

import com.rosendo.loja_virtual.domain.contaPagar.ContaPagar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaPagarRepository extends JpaRepository<ContaPagar, Long> {
}
