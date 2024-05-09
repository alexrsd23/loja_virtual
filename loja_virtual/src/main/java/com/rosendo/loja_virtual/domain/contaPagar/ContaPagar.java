package com.rosendo.loja_virtual.domain.contaPagar;

import com.rosendo.loja_virtual.domain.pessoa.Pessoa;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_ContaPagar")
public class ContaPagar implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoaFornecedor_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoaFornecedor_fk"))
    private Pessoa pessoaFornecedor;
    @Column(nullable = false)
    private String descricao;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusContaPagar statusContaPagar;

    @Temporal(TemporalType.DATE)
    private LocalDate dataVencimento;

    @Temporal(TemporalType.DATE)
    private LocalDate dataPagamento;

    private BigDecimal valorTotal;

    private BigDecimal valorDesconto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoaFornecedor() {
        return pessoaFornecedor;
    }

    public void setPessoaFornecedor(Pessoa pessoaFornecedor) {
        this.pessoaFornecedor = pessoaFornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusContaPagar getStatusContaPagar() {
        return statusContaPagar;
    }

    public void setStatusContaPagar(StatusContaPagar statusContaPagar) {
        this.statusContaPagar = statusContaPagar;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
}
