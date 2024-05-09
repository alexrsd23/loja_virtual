package com.rosendo.loja_virtual.domain.itemVendaLoja;

import com.rosendo.loja_virtual.domain.produto.Produtos;
import com.rosendo.loja_virtual.domain.vendaCompraLojaVirtual.VendaCompraLojaVirtual;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_ItemVendaLoja")
public class ItemVendaLoja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double quantidade;
    @ManyToOne(targetEntity = Produtos.class)
    @JoinColumn(name = "produtos_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produtos_fk"))
    private Produtos produtos;
    @ManyToOne(targetEntity = VendaCompraLojaVirtual.class)
    @JoinColumn(name = "vendaCompraLojaVirtual_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "vendaCompraLojaVirtual_fk"))
    private VendaCompraLojaVirtual vendaCompraLojaVirtual;

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

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public VendaCompraLojaVirtual getVendaCompraLojaVirtual() {
        return vendaCompraLojaVirtual;
    }

    public void setVendaCompraLojaVirtual(VendaCompraLojaVirtual vendaCompraLojaVirtual) {
        this.vendaCompraLojaVirtual = vendaCompraLojaVirtual;
    }
}
