package com.rosendo.loja_virtual.domain.usuario.exceptions;

public class ErroNaRespostaDoServidorException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ErroNaRespostaDoServidorException(String mensagem) {
        super(mensagem);
    }
}
