package com.cronus.hierarchy.exception;

// exeção criada para sinalizar que um usuario nao tem permissao para realizar uma ação
public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }
}
