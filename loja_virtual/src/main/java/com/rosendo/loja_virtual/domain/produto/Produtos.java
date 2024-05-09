package com.rosendo.loja_virtual.domain.produto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_Produtos")
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tipoUnidade;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;

//    nota item produto - ASSSOCIAR
    private Double peso;
    private Double largura;
    private Double altura;
    private Double profundidade;
    @Column(nullable = false)
    private BigDecimal valorVenda = BigDecimal.ZERO;
    @Column(nullable = false)
    private Integer quantidadeEstoque = 0;
    @Column(nullable = false)
    private Integer quantidadeAlertaEstoque = 0;
    private String linkImagem = "sem Link";
    @Column(nullable = false)
    private Boolean AlertaEstoque = false;
    private Integer quantidadeClique = 0;
    private Boolean ativo = Boolean.TRUE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Integer getQuantidadeAlertaEstoque() {
        return quantidadeAlertaEstoque;
    }

    public void setQuantidadeAlertaEstoque(Integer quantidadeAlertaEstoque) {
        this.quantidadeAlertaEstoque = quantidadeAlertaEstoque;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public void setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
    }

    public Boolean getAlertaEstoque() {
        return AlertaEstoque;
    }

    public void setAlertaEstoque(Boolean alertaEstoque) {
        AlertaEstoque = alertaEstoque;
    }

    public Integer getQuantidadeClique() {
        return quantidadeClique;
    }

    public void setQuantidadeClique(Integer quantidadeClique) {
        this.quantidadeClique = quantidadeClique;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
