package com.rosendo.loja_virtual.domain.notaItemProduto;

import com.rosendo.loja_virtual.domain.notaFiscalCompra.NotaFiscalCompra;
import com.rosendo.loja_virtual.domain.produto.Produtos;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_NotaItemProduto")
public class NotaItemProduto {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double quantidade;
    @ManyToOne(targetEntity = Produtos.class)
    @JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produtos produto;
    @ManyToOne(targetEntity = NotaFiscalCompra.class)
    @JoinColumn(name = "notaFiscalCompra_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "notaFiscalCompra_fk"))
    private NotaFiscalCompra notaFiscalCompra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public NotaFiscalCompra getNotaFiscalCompra() {
        return notaFiscalCompra;
    }

    public void setNotaFiscalCompra(NotaFiscalCompra notaFiscalCompra) {
        this.notaFiscalCompra = notaFiscalCompra;
    }
}
