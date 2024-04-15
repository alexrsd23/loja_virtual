package com.rosendo.loja_virtual.domain.endereco;

public enum TipoEndereco {
        COBRANCA ("Cobrança"),
        ENTREGA ("Entrega");

        private String descricao;

    TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
