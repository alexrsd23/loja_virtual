package com.rosendo.loja_virtual.domain.notaFiscalVenda;

import com.rosendo.loja_virtual.domain.vendaCompraLojaVirtual.VendaCompraLojaVirtual;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_NotaFiscalVenda")
public class NotaFiscalVenda implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String numeroNota;
    @Column(nullable = false)
    private String serieNota;
    @Column(nullable = false)
    private String tipoNota;
    @Column(columnDefinition = "text")
    private String xmlNota;
    @Column(columnDefinition = "text")
    private String pdfNota;
    @OneToOne(targetEntity = VendaCompraLojaVirtual.class)
    @JoinColumn(name = "vendaCompraLojaVirtual_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "vendaCompraLojaVirtual_fk"))
    private VendaCompraLojaVirtual vendaCompraLojaVirtual;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getSerieNota() {
        return serieNota;
    }

    public void setSerieNota(String serieNota) {
        this.serieNota = serieNota;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    public String getXmlNota() {
        return xmlNota;
    }

    public void setXmlNota(String xmlNota) {
        this.xmlNota = xmlNota;
    }

    public String getPdfNota() {
        return pdfNota;
    }

    public void setPdfNota(String pdfNota) {
        this.pdfNota = pdfNota;
    }

    public VendaCompraLojaVirtual getVendaCompraLojaVirtual() {
        return vendaCompraLojaVirtual;
    }

    public void setVendaCompraLojaVirtual(VendaCompraLojaVirtual vendaCompraLojaVirtual) {
        this.vendaCompraLojaVirtual = vendaCompraLojaVirtual;
    }
}
