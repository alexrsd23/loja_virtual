package com.rosendo.loja_virtual.domain.usuario.exceptions;

public class IntegridadeDeSistemaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IntegridadeDeSistemaException(String mensagem) {
        super(mensagem);
    }

}
