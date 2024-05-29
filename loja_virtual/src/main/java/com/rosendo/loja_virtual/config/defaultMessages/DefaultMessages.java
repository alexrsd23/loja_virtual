package com.rosendo.loja_virtual.config.defaultMessages;

public class DefaultMessages {
    public static String getMensagemCriacaoSucesso(String nomeObjeto) {
        return "Requisição completa: " + nomeObjeto + " foi criado com sucesso!";
    }

    public static String getMensagemAtualizacaoSucesso(String nomeObjeto) {
        return "Requisição completa: " + nomeObjeto + " foi atualizado com sucesso!";
    }

    public static String getMensagemRemocaoSucesso(String nomeObjeto) {
        return "Requisição completa: " + nomeObjeto + " foi removido com sucesso!";
    }

    public static String getMensagemErro(String detalhesErro) {
        return "Erro na requisição: " + detalhesErro;
    }
}
