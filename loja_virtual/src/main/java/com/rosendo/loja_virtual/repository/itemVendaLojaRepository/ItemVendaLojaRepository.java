package com.rosendo.loja_virtual.repository.itemVendaLojaRepository;

import com.rosendo.loja_virtual.domain.itemVendaLoja.ItemVendaLoja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaLojaRepository extends JpaRepository<ItemVendaLoja, Long> {
}
