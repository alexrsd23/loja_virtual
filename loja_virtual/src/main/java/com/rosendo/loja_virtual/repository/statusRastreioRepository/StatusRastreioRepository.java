package com.rosendo.loja_virtual.repository.statusRastreioRepository;

import com.rosendo.loja_virtual.domain.statusRastreio.StatusRastreio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRastreioRepository extends JpaRepository<StatusRastreio, Long> {
}
