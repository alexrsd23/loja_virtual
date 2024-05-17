package com.rosendo.loja_virtual.repository.vendaCompraLojaVirtualRepository;

import com.rosendo.loja_virtual.domain.vendaCompraLojaVirtual.VendaCompraLojaVirtual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaCompraLojaVirtualRepository extends JpaRepository<VendaCompraLojaVirtual, Long> {
}
