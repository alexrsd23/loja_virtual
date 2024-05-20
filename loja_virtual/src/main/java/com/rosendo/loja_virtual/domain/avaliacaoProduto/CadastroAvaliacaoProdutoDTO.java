package com.rosendo.loja_virtual.domain.avaliacaoProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CadastroAvaliacaoProdutoDTO {
    @NotBlank(message = "Descrição é necessária!")
    private String descricao;
    @NotBlank(message = "Nota é necessária!")
    private Integer nota;
    @NotNull(message = "É necessário um id de um usuário válido!")
    private Long pessoaId;
    @NotNull(message = "É necessário um id de um produto válido!")
    private Long produtoId;

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

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
}
