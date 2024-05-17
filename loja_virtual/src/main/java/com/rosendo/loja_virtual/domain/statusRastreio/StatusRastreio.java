package com.rosendo.loja_virtual.domain.statusRastreio;

import com.rosendo.loja_virtual.domain.vendaCompraLojaVirtual.VendaCompraLojaVirtual;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_StatusRastreio")
public class StatusRastreio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String centroDistribuicao;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String status;

    @ManyToOne(targetEntity = VendaCompraLojaVirtual.class)
    @JoinColumn(name = "vendaCompraLojaVirtual_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "vendaCompraLojaVirtual_fk"))
    private VendaCompraLojaVirtual vendaCompraLojaVirtual;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCentroDistribuicao() {
        return centroDistribuicao;
    }

    public void setCentroDistribuicao(String centroDistribuicao) {
        this.centroDistribuicao = centroDistribuicao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
