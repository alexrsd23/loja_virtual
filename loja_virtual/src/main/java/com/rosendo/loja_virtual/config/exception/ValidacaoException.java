package com.rosendo.loja_virtual.config.exception;

public class ValidacaoException extends RuntimeException {
    private static final long serialVersionUID = 8032745402603802213L;

    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}