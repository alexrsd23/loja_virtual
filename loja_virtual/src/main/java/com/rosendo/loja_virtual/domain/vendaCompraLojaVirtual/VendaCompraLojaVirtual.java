package com.rosendo.loja_virtual.domain.vendaCompraLojaVirtual;

import com.rosendo.loja_virtual.domain.cupomDesconto.CupomDesconto;
import com.rosendo.loja_virtual.domain.endereco.Endereco;
import com.rosendo.loja_virtual.domain.formaPagamento.FormaPagamento;
import com.rosendo.loja_virtual.domain.notaFiscalVenda.NotaFiscalVenda;
import com.rosendo.loja_virtual.domain.pessoa.Pessoa;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_VendaCompraLojaVirtual")
public class VendaCompraLojaVirtual {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;
    @ManyToOne(targetEntity = Endereco.class)
    @JoinColumn(name = "enderecoEntrega_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "enderecoEntrega_fk"))
    private Endereco enderecoEntrega;
    @ManyToOne(targetEntity = Endereco.class)
    @JoinColumn(name = "enderecoCobranca_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "enderecoCobranca_fk"))
    private Endereco enderecoCobranca;
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
    @ManyToOne(targetEntity = FormaPagamento.class)
    @JoinColumn(name = "formaPagamento_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "formaPagamento_fk"))
    private FormaPagamento formaPagamento;
    @OneToOne(targetEntity = NotaFiscalVenda.class)
    @JoinColumn(name = "notaFiscalVenda_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "notaFiscalVenda_fk"))
    private NotaFiscalVenda notaFiscalVenda;
    @ManyToOne(targetEntity = CupomDesconto.class)
    @JoinColumn(name = "cumpomDesconto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "cumpomDesconto_fk"))
    private CupomDesconto cumpomDesconto;
    private Integer diasEntrega;
    private BigDecimal valorFrete;
    @Temporal(TemporalType.DATE)
    private LocalDate dataVenda;
    @Temporal(TemporalType.DATE)
    private LocalDate dataEntrega;

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

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Endereco getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public void setEnderecoCobranca(Endereco enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
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

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public NotaFiscalVenda getNotaFiscalVenda() {
        return notaFiscalVenda;
    }

    public void setNotaFiscalVenda(NotaFiscalVenda notaFiscalVenda) {
        this.notaFiscalVenda = notaFiscalVenda;
    }

    public CupomDesconto getCumpomDesconto() {
        return cumpomDesconto;
    }

    public void setCumpomDesconto(CupomDesconto cumpomDesconto) {
        this.cumpomDesconto = cumpomDesconto;
    }

    public Integer getDiasEntrega() {
        return diasEntrega;
    }

    public void setDiasEntrega(Integer diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
