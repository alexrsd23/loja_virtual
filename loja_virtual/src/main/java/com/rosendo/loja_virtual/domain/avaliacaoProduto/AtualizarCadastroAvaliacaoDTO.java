package com.rosendo.loja_virtual.domain.avaliacaoProduto;

public class AtualizarCadastroAvaliacaoDTO {
    private String descricao;
    private Integer nota;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
