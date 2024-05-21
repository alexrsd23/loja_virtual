package com.rosendo.loja_virtual.domain.usuario.exceptions;

public class ForbiddenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ForbiddenException(String messagem) {
        super(messagem);
    }
}
