package com.rosendo.loja_virtual.domain.cupomDesconto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_CupomDesconto")
public class CupomDesconto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String codigoDescricao;

    private BigDecimal valorDinheiro;

    private BigDecimal valorPorcentagem;

    @Temporal(TemporalType.DATE)
    private LocalDate dataExpiracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoDescricao() {
        return codigoDescricao;
    }

    public void setCodigoDescricao(String codigoDescricao) {
        this.codigoDescricao = codigoDescricao;
    }

    public BigDecimal getValorDinheiro() {
        return valorDinheiro;
    }

    public void setValorDinheiro(BigDecimal valorDinheiro) {
        this.valorDinheiro = valorDinheiro;
    }

    public BigDecimal getValorPorcentagem() {
        return valorPorcentagem;
    }

    public void setValorPorcentagem(BigDecimal valorPorcentagem) {
        this.valorPorcentagem = valorPorcentagem;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}
