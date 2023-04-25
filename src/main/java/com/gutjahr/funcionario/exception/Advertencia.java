package com.gutjahr.funcionario.exception;

public class Advertencia extends RuntimeException {

    public Advertencia() {
        super();
    }

    public Advertencia(String mensagem) {
        super(mensagem);
    }
}
